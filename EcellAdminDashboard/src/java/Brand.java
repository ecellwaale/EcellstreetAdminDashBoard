
import classes.productsubcat;
import classes.producttype;
import ecsdatalayer.pcscoperation;
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

/**
 *
 * @author jayesh
 */
@WebServlet(urlPatterns = {"/Brand"})
public class Brand extends HttpServlet {

    

   
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
             producttype pt=new producttype();
             pctoperation pct=new pctoperation(sf);
               PrintWriter out=response.getWriter();
            if(request.getParameter("addbrandbut")!=null)
            {
                    String b=request.getParameter("brandtitle");
                    int sort=Integer.parseInt(request.getParameter("brandsortorder"));
                    String image=request.getParameter("brandimage");
                    int visible=Integer.parseInt(request.getParameter("brandvisible"));
                    pcscoperation ps=new pcscoperation(sf);
                    
                   
                    pt.setPcsc(ps.searchProductSubCat(Integer.parseInt(request.getParameter("subcatforbrand"))));
                    pt.setPc3id(5);
                    pt.setAddedDate(date);
                    pt.setAddedIp(ipAddress);
                    pt.setModifyDate(date);
                    pt.setModifyIp(ipAddress);
                    pt.setTitle(b);
                    pt.setSortorder(sort);
                    pt.setImage(image);
                    pt.setVisible(visible);
                    pct.addProductType(pt);
                  
                    response.sendRedirect("productaddbrandadd.jsp");
            }
            
            else if(request.getParameter("status")!=null)
            {
            if(request.getParameter("status").equals("gettype")){
                    int scid=Integer.parseInt(request.getParameter("sub"));
                    System.out.println("type id : "+scid);
                    pcscoperation pcsc=new pcscoperation(sf);
                productsubcat psc1=pcsc.searchProductSubCat(scid);
                    System.out.println("psc1 : "+psc1.toString());
                Set<producttype> set1=psc1.getPct();
                    System.out.println("set"+set1.size());
                    
                Object[] arraysc1=set1.toArray();
                    System.out.println("cast");
                JSONArray ja2=new JSONArray();
                for(int i=0;i<arraysc1.length;i++)
                {
                    JSONObject obj=new JSONObject();
                    pt=(producttype)arraysc1[i];
                    obj.put("pc3id",pt.getPc3id());
                    obj.put("typetitle",pt.getTitle());
                    ja2.put(obj);
                }
                System.out.println(ja2.toString());
                out.println(ja2.toString());
                }
            }
            else{
                //MainPage View
            List pctview=pct.getProductType();
            JSONArray jarr=new JSONArray();
            for(int i=0;i<pctview.size();i++)
            {
                JSONObject jo=new JSONObject();
                jo.put("Scid", (((producttype)pctview.get(i)).getPcsc()).getTitle());
                jo.put("Title", ((producttype)pctview.get(i)).getTitle());
                jo.put("ImageName", ((producttype)pctview.get(i)).getImage());
                jo.put("SortOrder", ((producttype)pctview.get(i)).getSortorder());
                jo.put("Visible", ((producttype)pctview.get(i)).getVisible());
                jarr.put(jo);
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
