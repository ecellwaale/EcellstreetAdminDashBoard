
package ecsdatalayer;

import classes.product;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jayesh
 */
public class productoperation {
    
        
         SessionFactory sf;
         String msg;
         
    public productoperation(SessionFactory sf) {
        this.sf=sf;
    }
         
        
   public String addProduct(product p)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
        msg="Product Successfully Added";
        }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage()+"Product Successfully Added");
               }
       
       return msg;
   }
   public product searchProduct(int id)
   {
       
       product p = null;
       try{
          Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        p=(product)session.get(product.class,id);
        tx.commit();
        session.close();
           System.out.println("Searche product completed");
        }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage()+"product search");
               }
       
       return p;
   }
   public List getProduct()
   {
       Session session = sf.openSession();
       List l = null;
       try{
       Query q=session.createQuery("from product");
       l=q.list();
       session.close();
           System.out.println("product list returned");
        }
       catch(HibernateException e)
               {
                   session.close();
                   System.out.println(e.getMessage()+"product list");
               }
       
       return l;    
   }
   public String removeProduct(product p)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
        session.close();
        msg="Product Successfully removed";
        }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage()+"Product remove");
               }
       return msg;
   }
    
   public String updateProduct(product p)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
       session.update(p);
       tx.commit();
       session.close();
       msg="Product successfully updated";
       }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage()+"Product update");
               }
       
       return msg;
   }
    
}
