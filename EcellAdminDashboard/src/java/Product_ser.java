
import classes.product;
import classes.productmodel;
import classes.productsubcat;
import classes.producttype;
import ecsdatalayer.pcmdoperation;
import ecsdatalayer.productoperation;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import java.util.List;
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
 * @author neal
 */
@WebServlet(urlPatterns = {"/Product_ser"})
public class Product_ser extends HttpServlet {

 
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
            productoperation p1=new productoperation(sf);

            PrintWriter out=response.getWriter();
            if(request.getParameter("addproductbut")!=null)
            {
                     System.out.println("asvc22222cjnascasnancccn");
                    String b=request.getParameter("producttitle");
                    int sort=Integer.parseInt(request.getParameter("psort"));
                    String des=request.getParameter("pdescription");
                    int visible=Integer.parseInt(request.getParameter("productvisible"));
                    double productsp=Integer.parseInt(request.getParameter("productsp"));
                    double productcp=Integer.parseInt(request.getParameter("productcp"));
                    String cdevice=request.getParameter("productcomdevice");

                    int stock=Integer.parseInt(request.getParameter("productstock"));
                    String sku=request.getParameter("productskucode");
                    

                    int onsale=Integer.parseInt(request.getParameter("productonsale"));
                    int featured=Integer.parseInt(request.getParameter("productfeatured"));
                    
                    double discount=Integer.parseInt(request.getParameter("pdiscount"));
                    System.out.println("asvcjnascasnanc444422224ccn");
                    int cod=Integer.parseInt(request.getParameter("productoncod"));
                    System.out.println("asvcjnascasnancccn");
                    pcmdoperation ps=new pcmdoperation(sf);
                    product pr=new product();
                    pr.setAddedDate(date);
                    pr.setAddedIp(ipAddress);
                    pr.setModifyIp(ipAddress);
                    pr.setModifyDate(date);
                    pr.setPid(5);
                    pr.setTitle(b);
                    pr.setSortorder(sort);
                    pr.setVisible(visible);
                    pr.setOnSale(onsale);
                    pr.setCod(cod);
                    pr.setIsfeatured(featured);
                    pr.setDiscount(discount);
                    pr.setCompatible_device(cdevice);
                    pr.setDescription(des);
                    pr.setCostprice(productcp);
                    pr.setSellprice(productsp);
                    pr.setInventory(stock);
                    pr.setSkucode(sku);
                                        System.out.println("asvcjnasacsacsacassacsaccscasnancccn");

                    pr.setPcmd(ps.searchProductModel(Integer.parseInt(request.getParameter("modelforproduct"))));
                    p1.addProduct(pr);
                                        System.out.println("asvcjnasascascsacscsacascsacsavasvasvsavsvsvsvsvsavsavascasnancccn");

                    response.sendRedirect("productaddproductadd.jsp");
                 

            }
            else{   
            List scview=p1.getProduct();
            JSONArray jarr=new JSONArray();
            System.out.println("----"+scview.size());
            for(int i=0;i<scview.size();i++)
            {
                JSONObject jo=new JSONObject();
                jo.put("Title", ((product)scview.get(i)).getTitle());
                jo.put("Pmid", (((product)scview.get(i)).getPcmd()).getTitle());
                jo.put("SortOrder", ((product)scview.get(i)).getSortorder());
                jo.put("Visible", ((product)scview.get(i)).getVisible());
                jo.put("Isfeatured", ((product)scview.get(i)).getIsfeatured());
                jo.put("Onsale", ((product)scview.get(i)).getOnSale());
                jo.put("Cod", ((product)scview.get(i)).getCod());
                jo.put("costprice", ((product)scview.get(i)).getCostprice());
                jo.put("sellprice", ((product)scview.get(i)).getSellprice());
                jo.put("discount", ((product)scview.get(i)).getDiscount());
                jo.put("Compatible", ((product)scview.get(i)).getCompatible_device());
                jo.put("description", ((product)scview.get(i)).getDescription());
                jo.put("inventory", ((product)scview.get(i)).getInventory());
                
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
