/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecsdatalayer;

import classes.orderitems;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class odioperations {
      SessionFactory sf;
      String msg;
         
    public odioperations(SessionFactory sf) {
        this.sf=sf;
    }
         
        
   public String addOrderItem(orderitems o)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.save(o);
        tx.commit();
        session.close();
        msg="OrderItems Successfully Added";
        }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+" orderitems";
               }
       
       return msg;
   }
   public orderitems searchOrderItem(int id)
   {
       
       orderitems o  = null;
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        o=(orderitems)session.get(orderitems.class,id);
        tx.commit();
        session.close();
           System.out.println("orderitem returned");
        }
       catch(HibernateException e)
               {
                   System.out.println(e.getMessage()+" order items");
               }
       
       return o;
   }
   public List getOrderItems()
   {
       Session session = sf.openSession();
       List l = null;
       try{
       Query q=session.createQuery("from orderitems");
       l=q.list();
       session.close();
           System.out.println("retuned orderitems list");
        }
       catch(HibernateException e)
               {
                   session.close();
                   System.out.println(e.getMessage()+" orderitems");
               }
       
       return l;    
   }
   public String removeProduct(orderitems o)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
        session.delete(o);
        tx.commit();
        session.close();
        msg="OrderItems Successfully removed";
        }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+" orderitems";
               }
       return msg;
   }
    
   public String updateProduct(orderitems o)
   {
       try{
           Session session = sf.openSession();
           Transaction tx = session.beginTransaction();
       session.update(o);
       tx.commit();
       session.close();
       msg="OrderItems successfully updated";
       }
       catch(HibernateException e)
               {
                   msg=e.getMessage()+"orderitem update";
               }
       return msg;
   }
}
