/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.productmaincat;
import ecsdatalayer.pcmcoperation;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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
public class Maincat extends HttpServlet {

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
            productmaincat pcm=new productmaincat();
            pcmcoperation pcmc=new pcmcoperation(sf);
               PrintWriter out=response.getWriter();
            if(request.getParameter("addmainbut")!=null)
            {
                System.out.println("\n\n\naayo");
                pcm.setPc1id(5);
                pcm.setAddedDate(date);
                pcm.setAddedIp(ipAddress);
                pcm.setModifyDate(date);
                pcm.setModifyIp(ipAddress);
                pcm.setTitle(request.getParameter("maincattitle"));
                pcm.setSortorder(Integer.parseInt(request.getParameter("maincatsortorder")));
                pcm.setVisible(Integer.parseInt(request.getParameter("maincatvisible")));
                pcm.setImage(request.getParameter("maincatimage"));
                pcmc.addMainCat(pcm);
                
                response.sendRedirect("productaddmaincatadd.jsp");
            }
            else if(request.getParameter("status")!=null)
              {
                  System.out.println("sdcsascsacasvasca---------------");
               if(request.getParameter("status").equals("getmc"))
                  {    
                      List l1=pcmc.getProductMainCat();
                       JSONArray ja=new JSONArray();
                       for(int i=0;i<l1.size();i++)
                          {
                           JSONObject obj=new JSONObject();
                            pcm=(productmaincat)l1.get(i);

                            obj.put("pc1id", pcm.getPc1id());
                            obj.put("mctitle", pcm.getTitle());
                            ja.put(obj);

                       }
                          out.println(ja.toString());
                        }
                }
            else{
            List mcview=pcmc.getProductMainCat();
            JSONArray jarr=new JSONArray();
            for(int i=0;i<mcview.size();i++)
            {
                JSONObject jo=new JSONObject();
                jo.put("Title", ((productmaincat)mcview.get(i)).getTitle());
                jo.put("ImageName", ((productmaincat)mcview.get(i)).getImage());
                jo.put("SortOrder", ((productmaincat)mcview.get(i)).getSortorder());
                jo.put("Visible", ((productmaincat)mcview.get(i)).getVisible());
                jarr.put(jo);
            }
            out.println(jarr);
          
           }
            
            
            
            
        }
        catch(IOException | NumberFormatException e)
        {
            System.out.println(e.getMessage());
        } catch (JSONException ex) {
            Logger.getLogger(Maincat.class.getName()).log(Level.SEVERE, null, ex);
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
