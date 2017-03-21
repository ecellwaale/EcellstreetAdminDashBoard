
package ecsdatalayer;

import classes.product_images;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class pcioperations {
      
        
         SessionFactory sf;
     String msg;
         
        public pcioperations(SessionFactory sf) {
        this.sf=sf;
    }
         
        
   public String addProductImage(product_images p)
   {
      
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
        msg="ProductImage Successfully Added";
        }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+"productimage";
               }
       
       return msg;
   }
   public product_images searchProductImage(int id)
   {
       
       product_images p = null;
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        p=(product_images)session.get(product_images.class,id);
        tx.commit();
        session.close();
           System.out.println("Successfully returned pimage");
        }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage()+"product image");
               }
       
       return p;
   }
   public List getProductImage()
   {
       Session session = sf.openSession();
       List l = null;
       try{
       Query q=session.createQuery("from product_images");
       l=q.list();
       session.close();
           System.out.println("Successfully retuned pimages");
        }
       catch(HibernateException e)
               {
                   session.close();
                   System.out.println(e.getMessage()+"pimages");
               }
       
       return l;    
   }
   public String removeProductImage(product_images p)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
        session.close();
        msg="ProductImage Successfully removed";
        }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+" pimages";
               }
       return msg;
   }
    
   public String updateProductImage(product_images p)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
       session.update(p);
       tx.commit();
       session.close();
       msg="ProductImage successfully updated";
       }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+" pimages";
               }
       
       return msg;
   }
  
    
}
