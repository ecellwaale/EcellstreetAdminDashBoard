/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecsdatalayer;

import classes.productsubcat;
import classes.producttype;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class pctoperation {
    
         SessionFactory sf;
         String msg;

    public pctoperation(SessionFactory sf) {
        this.sf=sf;
    }
         
         
      
        
   public String addProductType(producttype pct)
   {
        try{
            
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(pct);
        tx.commit();
        session.close();
        msg="ProductType Successfully Added";
        }
        catch(HibernateException e)
                {
                    msg=e.getMessage()+" producttype add";
                }
       return msg;
   }
   
   public String removeProductType(producttype pct)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.delete(pct);
        tx.commit();
        session.close();
        msg="ProductType Successfully removed";
         }
        catch(HibernateException e)
                {
                    msg=e.getMessage()+"producttype";
                }
       return msg;
   }
    
   public String updateProductType(producttype pct)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
       
       session.update(pct);
       tx.commit();
       session.close();
       msg="ProductType title successfully updated";
        }
        catch(HibernateException e)
                {
                    msg=e.getMessage()+"update producttype title";
                }
       
       return msg;
   }
//   
//    public String updateProductType(producttype pct,String NewTitle,int visible,int SortOrder,String Image,Date ModIfyDate,String ModifyIp)
//   {
//       try{
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//       pct.setTitle(NewTitle);
//       pct.setVisible(visible);
//       pct.setSortorder(SortOrder);
//       pct.setImage(Image);
//       pct.setModifyDate(ModIfyDate);
//       pct.setModifyIp(ModifyIp);
//       session.update(pct);
//       tx.commit();
//       session.close();
//       msg="ProductType title successfully updated";
//        }
//        catch(HibernateException e)
//                {
//                    msg=e.getMessage()+"update producttype title";
//                }
//       
//       return msg;
//   }
//   
//    public String updateProductType(producttype pct,int visible,Date ModIfyDate,String ModifyIp)
//   {
//       try{
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//        
//       pct.setVisible(visible);
//       pct.setModifyDate(ModIfyDate);
//       pct.setModifyIp(ModifyIp);
//       session.update(pct);
//       tx.commit();
//       session.close();
//       msg="ProductType visibility updated";
//        }
//        catch(HibernateException e)
//                {
//                    msg=e.getMessage()+"product type visible";
//                }
//       return msg;
//   }
//    
//     public String updateProductType(producttype pct,Date ModIfyDate,String ModifyIp,int SortOrder)
//   {
//       try{
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//       pct.setSortorder(SortOrder);
//       pct.setModifyDate(ModIfyDate);
//       pct.setModifyIp(ModifyIp);
//       session.update(pct);
//       tx.commit();
//       session.close();
//       msg="ProductType sort order updated";
//        }
//        catch(HibernateException e)
//                {
//                    msg=e.getMessage()+"ProductType sort order";
//                }
//       
//       return msg;
//   }
//     
//    public String updateProductType(producttype pct,Date ModIfyDate,String ModifyIp,String Image)
//   {
//       try{
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//       
//       pct.setImage(Image);
//       pct.setModifyDate(ModIfyDate);
//       pct.setModifyIp(ModifyIp);
//       session.update(pct);
//       tx.commit();
//       session.close();
//       msg="ProductType Image successfully updated";
//        }
//        catch(HibernateException e)
//                {
//                    msg=e.getMessage()+"ProductType Image";
//                }
//       
//       return msg;
//   }

    public producttype searchProductType(int id)
   {
       
       producttype p = null;
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        p=(producttype)session.get(producttype.class,id);
        tx.commit();
        session.close();
           System.out.println("producttype found");
        }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage()+"product type search");
               }
       
       return p;
   }
   public List getProductType()
   {
       Session session = sf.openSession();
       List l = null;
       try{
       Query q=session.createQuery("from producttype");
       l=q.list();
       session.close();
           System.out.println("producttype list returned");
        }
       catch(HibernateException e)
               {
                   session.close();
                   System.out.println(e.getMessage()+"producttype list");
               }
       
       return l;    
   }
}
