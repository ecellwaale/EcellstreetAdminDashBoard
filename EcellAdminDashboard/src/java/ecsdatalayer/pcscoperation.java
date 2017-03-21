
package ecsdatalayer;


import classes.productmaincat;
import classes.productsubcat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jayesh
 */
public class pcscoperation {
    
    SessionFactory sf;
    String msg;
    public pcscoperation(SessionFactory sf) {
        this.sf=sf;
    }
    



   public String addSubCat(productsubcat pcsc)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.save(pcsc);
        tx.commit();
        session.close();
        msg="Sub category Successfully Added";
        
       }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+"sub cat add";
               }


       return msg;
   }

   public String removeSubCat(productsubcat pcsc)
   {    
       try{
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.delete(pcsc);
        tx.commit();
        session.close();
          msg="Sub category Successfully removed";
        
       }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+"sub cat remove";
               }


       return msg;
   }

   public String updateSubCat(productsubcat pcsc)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
       
       session.update(pcsc);
        tx.commit();
        session.close();
        msg="Sub category title updated";
         }catch(HibernateException e)
               {
                   msg=e.getMessage()+"sub cat title update";
               }

       return msg;
   }
   
   public productsubcat searchProductSubCat(int id)
   {
       
       productsubcat p = null;
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        p=(productsubcat)session.get(productsubcat.class,id);
        tx.commit();
        session.close();
           System.out.println("search sub cat returned");
        }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage()+"search product sub cat");
               }
       
       return p;
   }
   public List getProductSubCat()
   {
       Session session = sf.openSession();
       List l = null;
       try{
       Query q=session.createQuery("from productsubcat");
       l=q.list();
       session.close();
        }
       catch(HibernateException e)
               {
                   session.close();
                   System.out.println(e.getMessage());
               }
       
       return l;    
   }

}
