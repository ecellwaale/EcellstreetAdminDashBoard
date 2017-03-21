/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.productmaincat;
import classes.productsubcat;
import ecsdatalayer.pcmcoperation;
import ecsdatalayer.pcscoperation;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jayesh
 */
@WebServlet(urlPatterns = {"/Subcat"})
public class Subcat extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
     {
        try{
           
            Date date=Date.from(Instant.now());
            SessionFactory sf=(SessionFactory)(this.getServletContext().getAttribute("sf"));
            String ipAddress = request.getRemoteAddr();
            productsubcat psc=new productsubcat();
            pcscoperation pcsc=new pcscoperation(sf);
            PrintWriter out=response.getWriter();
            if(request.getParameter("addsubbut")!=null)
            {
                pcmcoperation pcmc=new pcmcoperation(sf);
                psc.setPcmc(pcmc.searchProductMainCat(Integer.parseInt(request.getParameter("maincatforsubcat"))));
                psc.setPc2id(5);
                psc.setTitle(request.getParameter("subcattitle"));
                psc.setVisible(Integer.parseInt(request.getParameter("subcatvisible")));
                psc.setSortorder(Integer.parseInt(request.getParameter("subcatsortorder")));
                psc.setAddedDate(date);
                psc.setAddedIp(ipAddress);
                psc.setModifyDate(date);
                psc.setModifyIp(ipAddress);
                pcsc.addSubCat(psc);
                response.sendRedirect("productaddsubcatadd.jsp");
            }
            else if(request.getParameter("status")!=null)
            {
            if(request.getParameter("status").equals("getsc")){
                int mainid=Integer.parseInt(request.getParameter("main"));
                    System.out.println("main id : "+mainid);
                pcmcoperation pcm=new pcmcoperation(sf);
                productmaincat pmc1=pcm.searchProductMainCat(mainid);
                    System.out.println("pmc1 : "+pmc1.toString());
                Set<productsubcat> set=pmc1.getPcsc();
                    System.out.println("set");
                    
                Object[] arraysc=set.toArray();
                    System.out.println("cast");
                JSONArray ja1=new JSONArray();
                for(int i=0;i<arraysc.length;i++)
                {
                    JSONObject obj=new JSONObject();
                    psc=(productsubcat)arraysc[i];
                    obj.put("pc2id",psc.getPc2id());
                    obj.put("sctitle",psc.getTitle());
                    ja1.put(obj);
                }    
                out.println(ja1.toString());
                }
            }
            
            
            else{   
            List scview=pcsc.getProductSubCat();
            JSONArray jarr=new JSONArray();
            System.out.println("----"+scview.size());
            for(int i=0;i<scview.size();i++)
            {
                JSONObject jo=new JSONObject();
                jo.put("Title", ((productsubcat)scview.get(i)).getTitle());
                jo.put("Mcid", (((productsubcat)scview.get(i)).getPcmc()).getTitle());
                jo.put("SortOrder", ((productsubcat)scview.get(i)).getSortorder());
                jo.put("Visible", ((productsubcat)scview.get(i)).getVisible());
                jarr.put(jo);
            }
            out.println(jarr);
        }
            
        }
        catch(IOException | NumberFormatException e)
        {
            System.out.println(e.getMessage());
        } catch (JSONException ex) {
            System.out.println("---------------"+ex.getMessage());
        }
        
        
    }

   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
