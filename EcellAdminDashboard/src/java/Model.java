
import classes.productmodel;
import classes.producttype;
import ecsdatalayer.pcmdoperation;
import ecsdatalayer.pctoperation;
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


@WebServlet(urlPatterns = {"/Model"})
public class Model extends HttpServlet {

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
             productmodel pmd=new productmodel();
             pcmdoperation pcmd=new pcmdoperation(sf);
               PrintWriter out=response.getWriter();
            if(request.getParameter("addmodelbut")!=null)
            {
                
                pctoperation po=new pctoperation(sf);
                pmd.setPc4id(5);
                pmd.setAddedDate(date);
                pmd.setAddedIp(ipAddress);
                pmd.setModifyDate(date);
                pmd.setModifyIp(ipAddress);
                pmd.setTitle(request.getParameter("modeltitle"));
                pmd.setSortorder(Integer.parseInt(request.getParameter("modelsortorder")));
                pmd.setVisible(Integer.parseInt(request.getParameter("modelvisible")));
                pmd.setImage(request.getParameter("modelimage"));
                System.out.println("ascasccfsaasvavwavwavwawa");
                pmd.setPct(po.searchProductType(Integer.parseInt(request.getParameter("brandformodels"))));
                pcmd.addProductModel(pmd);
                System.out.println("sdvvvvvdsfasaskashahcoushcuosahco");
                response.sendRedirect("productaddmodeladd.jsp");
            }
            else if(request.getParameter("status")!=null)
            {
            if(request.getParameter("status").equals("getmo")){   
        int bid=Integer.parseInt(request.getParameter("mod"));
                    System.out.println("type id : "+bid);
                    pctoperation pct = new pctoperation(sf);
                producttype pct1=pct.searchProductType(bid);
                    System.out.println("psc1 : "+pct1.toString());
                Set<productmodel> set2=pct1.getPcmd();
                    System.out.println("set"+set2.size());
                    
                Object[] arraysc2=set2.toArray();
                    System.out.println("cast");
                JSONArray ja3=new JSONArray();
                for(int i=0;i<arraysc2.length;i++){
                    JSONObject obj=new JSONObject();
                    pmd=(productmodel)arraysc2[i];
                    obj.put("pc4id",pmd.getPc4id());
                    obj.put("modeltitle",pmd.getTitle());
                    ja3.put(obj);
                }
                System.out.println(ja3.toString());
                out.println(ja3.toString());
         }
            }
               
            else{
                //MainPage View
            List pmdview=pcmd.getProductModel();
            JSONArray jarr=new JSONArray();
            for(int i=0;i<pmdview.size();i++)
            {
                JSONObject jo=new JSONObject();
                jo.put("Mid", (((productmodel)pmdview.get(i)).getPct()).getTitle());
                jo.put("Title", ((productmodel)pmdview.get(i)).getTitle());
                jo.put("ImageName", ((productmodel)pmdview.get(i)).getImage());
                jo.put("SortOrder", ((productmodel)pmdview.get(i)).getSortorder());
                jo.put("Visible", ((productmodel)pmdview.get(i)).getVisible());
                jarr.put(jo);
                System.out.println("dslcnsdlkjdnv");

            }
            out.println(jarr);
            }
        }
        catch(IOException | NumberFormatException | JSONException e)
        {
            System.out.println(e.getMessage());
        } 
         
    }

    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
