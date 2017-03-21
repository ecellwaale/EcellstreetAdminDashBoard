/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.productmaincat;
import classes.productmodel;
import classes.productsubcat;
import classes.producttype;
import ecsdatalayer.pcmcoperation;
import ecsdatalayer.pcscoperation;
import ecsdatalayer.pctoperation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author neal
 */
public class NewServlet1 extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        SessionFactory sf=(SessionFactory)(this.getServletContext()).getAttribute("sf");
        pcscoperation ps=new pcscoperation(sf);
        pcmcoperation pcm=new pcmcoperation(sf);
        pctoperation pct=new pctoperation(sf);
        List l=ps.getProductSubCat();
        List l1=pcm.getProductMainCat();
        productsubcat psc=new productsubcat();
        productmaincat pms=new productmaincat();
        producttype pt=new producttype();
        productmodel pm=new productmodel();
        JSONArray ja=new JSONArray();
        
        try{
            if(request.getParameter("status")!=null){
                System.out.println("1");
                String status=request.getParameter("status");
                switch(status){
                case "getsc":
                
                int mainid=Integer.parseInt(request.getParameter("main"));
                    System.out.println("main id : "+mainid);
                productmaincat pmc1=pcm.searchProductMainCat(mainid);
                    System.out.println("pmc1 : "+pmc1.toString());
                Set<productsubcat> set=pmc1.getPcsc();
                    System.out.println("set");
                    
                Object[] arraysc=set.toArray();
                    System.out.println("cast");
                JSONArray ja1=new JSONArray();
                for(int i=0;i<arraysc.length;i++){
                    JSONObject obj=new JSONObject();
                    psc=(productsubcat)arraysc[i];
                    obj.put("pc2id",psc.getPc2id());
                    obj.put("sctitle",psc.getTitle());
                    ja1.put(obj);
                }    
                out.println(ja1.toString());
                
                break;
            
                case "gettype":
                
                    int scid=Integer.parseInt(request.getParameter("sub"));
                    System.out.println("type id : "+scid);
                productsubcat psc1=ps.searchProductSubCat(scid);
                    System.out.println("psc1 : "+psc1.toString());
                Set<producttype> set1=psc1.getPct();
                    System.out.println("set"+set1.size());
                    
                Object[] arraysc1=set1.toArray();
                    System.out.println("cast");
                JSONArray ja2=new JSONArray();
                for(int i=0;i<arraysc1.length;i++){
                    JSONObject obj=new JSONObject();
                    pt=(producttype)arraysc1[i];
                    obj.put("pc3id",pt.getPc3id());
                    obj.put("typetitle",pt.getTitle());
                    ja2.put(obj);
                }
                System.out.println(ja2.toString());
                out.println(ja2.toString());
                
            break;
                case "getmc":
            
        for(int i=0;i<l1.size();i++)
        {
            JSONObject obj=new JSONObject();
            pms=(productmaincat)l1.get(i);
            
            obj.put("pc1id", pms.getPc1id());
            obj.put("mctitle", pms.getTitle());
            ja.put(obj);
            
        }
           out.println(" "+ja.toString());
           
            
        break;
       case "getmo":
            
        int bid=Integer.parseInt(request.getParameter("mod"));
                    System.out.println("type id : "+bid);
                producttype pct1=pct.searchProductType(bid);
                    System.out.println("psc1 : "+pct1.toString());
                Set<productmodel> set2=pct1.getPcmd();
                    System.out.println("set"+set2.size());
                    
                Object[] arraysc2=set2.toArray();
                    System.out.println("cast");
                JSONArray ja3=new JSONArray();
                for(int i=0;i<arraysc2.length;i++){
                    JSONObject obj=new JSONObject();
                    pm=(productmodel)arraysc2[i];
                    obj.put("pc4id",pm.getPc4id());
                    obj.put("modeltitle",pm.getTitle());
                    ja3.put(obj);
                }
                System.out.println(ja3.toString());
                out.println(ja3.toString());
           
           break;
            }}
            
        }
        catch(Exception e){
            System.out.println("e:"+e.getMessage());
        }
        
        
    }

  

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
