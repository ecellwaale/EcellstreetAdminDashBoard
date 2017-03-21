
package ecsdatalayer;

import classes.productmaincat;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
;

/**
 *
 * @author jayesh
 */
public class pcmcoperation {

    
    SessionFactory sf;
    public pcmcoperation(SessionFactory sf) {
        this.sf=sf;
    }
  
   public String addMainCat(productmaincat pcmc)
   { String msg;
       try{
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(pcmc);
        tx.commit();
        session.close();
        msg="main cat success";
         }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage());
                   msg=e.getMessage()+" main cat";
               }
       
       return msg;
   }
   
   public String removeMainCat(productmaincat pcmc)
   {
       String msg;
       try{
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(pcmc);
        tx.commit();
        session.close();
        msg="main cat Successfully removed";
         }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+" main cat";
               }
       return msg;
   }
     public String updateMainCat(productmaincat pcmc)
   {
       String msg;
       try{
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       session.update(pcmc);
       tx.commit();
        session.close();
        msg="title successfully updated";
         }
       catch(HibernateException e)
               {
               msg=e.getMessage()+"mai  cat";
               }
       
       return msg;
   }
     
//   public String updateMainCat(productmaincat pcmc,String NewTitle,Date ModIfyDate,String ModifyIp)
//   {
//       String msg;
//       try{
//       Session session = sf.openSession();
//       Transaction tx = session.beginTransaction();
//       pcmc.setTitle(NewTitle);
//       pcmc.setModifyDate(ModIfyDate);
//       pcmc.setModifyIp(ModifyIp);
//       session.update(pcmc);
//       tx.commit();
//        session.close();
//        msg="title successfully updated";
//         }
//       catch(HibernateException e)
//               {
//               msg=e.getMessage()+"mai  cat";
//               }
//       
//       return msg;
//   }
//   
//    public String updateMainCat(productmaincat pcmc,int visible,Date ModIfyDate,String ModifyIp)
//   {
//       String msg;
//       try{
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//       pcmc.setVisible(visible);
//       pcmc.setModifyDate(ModIfyDate);
//       pcmc.setModifyIp(ModifyIp);
//       session.update(pcmc);
//       tx.commit();
//        session.close();
//        msg="main cat visibility updated";
//         }
//       catch(HibernateException e)
//               {
//                   msg=e.getMessage()+" main cat";
//               }
//       
//       return msg;
//   }
//    
//     public String updateMainCat(int Id,Date ModIfyDate,String ModifyIp,int SortOrder)
//   {
//       String msg;
//       try{
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//       productmaincat pcmc=(productmaincat) session.get(productmaincat.class,Id);
//       pcmc.setSortorder(SortOrder);
//       pcmc.setModifyDate(ModIfyDate);
//       pcmc.setModifyIp(ModifyIp);
//       session.update(pcmc);
//       tx.commit();
//        session.close();
//        msg="Main category sort order updated";
//         }
//       catch(HibernateException e)
//               {
//                   msg=e.getMessage()+" mai cat";
//               }
//       
//       return msg;
//   }
//     
//    public String updateMainCat(int Id,Date ModIfyDate,String ModifyIp,String Image)
//   {
//       String msg;
//       try{
//       Session session = sf.openSession();
//       Transaction tx = session.beginTransaction();
//       productmaincat pcmc=(productmaincat) session.get(productmaincat.class,Id);
//       pcmc.setImage(Image);
//       pcmc.setModifyDate(ModIfyDate);
//       pcmc.setModifyIp(ModifyIp);
//       session.update(pcmc);
//       tx.commit();
//       session.close();
//       msg="Main category Image successfully updated";
//        }
//       catch(HibernateException e)
//               {
//                   msg=e.getMessage()+"main cat";
//               }
//       
//       return msg;
//   }
//    
    public productmaincat searchProductMainCat(int id)
   {
       productmaincat p = null;
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        p=(productmaincat)session.get(productmaincat.class,id);
        tx.commit();
        session.close();
           System.out.println("\nSuccessfully returned main cat");
        }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage());
               }
       
       return p;
   }
   public List getProductMainCat()
   {
       Session session = sf.openSession();
       List l = null;
       try{
       Query q=session.createQuery("from productmaincat");
       l=q.list();
       session.close();
           System.out.println("\nSuccessfully returned main cat list");
        }
       catch(HibernateException e)
               {
                   session.close();
                   System.out.println(e.getMessage());
               }
       
       return l;    
   }
}
