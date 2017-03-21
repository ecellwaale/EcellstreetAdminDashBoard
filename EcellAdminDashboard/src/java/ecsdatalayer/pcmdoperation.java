/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecsdatalayer;

import classes.productmodel;
import classes.producttype;
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
public class pcmdoperation {
    
    
         SessionFactory sf;
         String msg;

    public pcmdoperation(SessionFactory sf) {
        
        this.sf=sf;
    }
         
        
   public String addProductModel(productmodel pcmd)
   {
       
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.save(pcmd);
        tx.commit();
        session.close();
        msg="ProductModel Successfully Added";
        
        }
       catch(HibernateException e)
               {
                  msg=e.getMessage()+" model";
                   
               }
       
       return msg;
   }
   
   public String removeProductModel(productmodel pcmd)
   {
       
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.delete(pcmd);
        tx.commit();
        session.close();
        msg="ProductModel Successfully removed";
        }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+" model";
               }
       return msg;
   }

   
      public String updateProductModel(productmodel pcmd)
   {
      
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
       session.update(pcmd);
       tx.commit();
       session.close();
       msg="ProductModel title successfully updated";
       }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+"";
               }
       
       return msg;
   }
   
//   public String updateProductModel(productmodel pcmd,String NewTitle,Date ModIfyDate,String ModifyIp)
//   {
//      
//       try{
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//       
//       pcmd.setTitle(NewTitle);
//       pcmd.setModifyDate(ModIfyDate);
//       pcmd.setModifyIp(ModifyIp);
//       session.update(pcmd);
//       tx.commit();
//       session.close();
//       msg="ProductModel title successfully updated";
//       }
//       catch(HibernateException e)
//               {
//                   msg=e.getMessage()+"";
//               }
//       
//       return msg;
//   }
//   
//    public String updateProductModel(productmodel pcmd,int visible,Date ModIfyDate,String ModifyIp)
//   {
//       
//       try{
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//       
//       pcmd.setVisible(visible);
//       pcmd.setModifyDate(ModIfyDate);
//       pcmd.setModifyIp(ModifyIp);
//       session.update(pcmd);
//       tx.commit();
//       session.close();
//       msg="ProductModel visibility updated";
//       }
//       catch(HibernateException e)
//               {
//                   msg=e.getMessage()+" model";
//                  
//               }
//       return msg;
//   }
//    
//     public String updateProductModel(productmodel pcmd,Date ModIfyDate,String ModifyIp,int SortOrder)
//   {
//       try{
//           
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//       
//       pcmd.setSortorder(SortOrder);
//       pcmd.setModifyDate(ModIfyDate);
//       pcmd.setModifyIp(ModifyIp);
//       session.update(pcmd);
//       tx.commit();
//       session.close();
//       msg="ProductModel sort order updated";
//       }
//       catch(HibernateException e)
//               {
//                    msg=e.getMessage()+" model";
//               }
//       
//       return msg;
//   }
//     
//    public String updateProductModel(productmodel pcmd,Date ModIfyDate,String ModifyIp,String Image)
//   {
//       try{
//           
//           Session session = sf.openSession();
//           Transaction tx = session.beginTransaction();
//       
//       pcmd.setImage(Image);
//       pcmd.setModifyDate(ModIfyDate);
//       pcmd.setModifyIp(ModifyIp);
//       session.update(pcmd);
//       tx.commit();
//       session.close();
//       msg="ProductModel Image successfully updated";
//       }
//       catch(HibernateException e)
//               {
//                   msg=e.getMessage()+" model";
//               }
//       
//       return msg;
//   }
      
      
    public productmodel searchProductModel(int id)
   {
       
       productmodel p = null;
       try{
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        p=(productmodel)session.get(productmodel.class,id);
        tx.commit();
        session.close();
           System.out.println("Model returned");
        }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage()+" model");
               }
       
       return p;
   }
   public List getProductModel()
   {
       Session session = sf.openSession();
       List l = null;
       try{
       Query q=session.createQuery("from productmodel");
       l=q.list();
       session.close();
           System.out.println("success in getting model list");
        }
       catch(HibernateException e)
               {
                   session.close();
                   System.out.println(e.getMessage()+" model list");
               }
       
       return l;    
   }

}
