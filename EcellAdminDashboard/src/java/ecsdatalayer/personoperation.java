/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecsdatalayer;

import classes.admin;
import classes.person;
import classes.users;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author neal
 */
public class personoperation {
    
         SessionFactory sf;

    public personoperation(SessionFactory sf) {
        this.sf = sf;
    }
          
          

    public personoperation() {
    }
         
    public String addPerson(person p)
    {
        Session s=sf.openSession();
         Transaction tx=s.beginTransaction();
         String msg=" ";
        try{
        
        if(p instanceof admin)
        {
            admin ad=(admin)p;
            
                s.save(ad);
           
        }
        if(p instanceof users)
        {
            users us=(users)p;
               s.save(us);
            
        }
        msg="successfull";
        }
        catch(HibernateException h)
        {
            msg=msg+h.getMessage();
        }
        
        tx.commit();
        s.close();
        
        return msg;
    }
    
    public String updatePerson(person p)
    {
        Session s=sf.openSession();
         Transaction tx=s.beginTransaction();
         String msg="";
         try{
             if(p instanceof admin)
        {
            admin ad=(admin)p;
                
                s.update(ad);
            
                
        }
        if(p instanceof users)
        {
            users us=(users)p;
            s.update(us);
            
        }
         
         tx.commit();
         s.close();
         msg="successfull";
         }
         catch(HibernateException h)
         {
            msg=msg+h.getMessage();
         }
        
         
        return msg;
    }
    
    public String removePerson(person p)
    {
        Session s=sf.openSession();
         Transaction tx=s.beginTransaction();
         String msg=" ";
         try{
             if(p instanceof admin)
        {
            admin ad=(admin)p;
        
            s.delete(ad);
            
            
        }
        if(p instanceof users)
        {
            users us=(users)p;
            s.delete(us);
            
        }
        tx.commit();
         s.close();
         msg="succesfull";
         }
         catch(HibernateException h)
         {
             msg=msg+h.getMessage();
         }
         
         
         
        return msg;
    }
    public List viewPerson(person p)
    {
        List l=null;
        Session s=sf.openSession();
         Transaction tx=s.beginTransaction();
         String msg="";
         try{
             if(p instanceof admin)
        {
            
            System.out.println("instance of admin");
            String hql="from admin ";
            Query q=s.createQuery(hql);
            
            l=q.list();
            if(l.isEmpty())
            {
                msg="no such admin exists";
            }
            
            
        }
        if(p instanceof users)
        {
            System.out.println("instance of user");
            String hql="from users";
            Query q=s.createQuery(hql);
            l=q.list();
             if(l.isEmpty())
            {
                msg="no such  exists";
            }
            tx.commit();
         s.close();
        }
        
         }
         catch(HibernateException h)
         {
             msg=msg+h.getMessage();
         }
         
         
        
         return l;
    }
    
    public person searchPerson(int id)
    {
        Session s=sf.openSession();
         Transaction tx=s.beginTransaction();
         personoperation pp=null;
         person p=null;
         String msg="";
        try{
        
            p=(person)s.get(person.class, id);
           
           s.close();
        tx.commit();
         
        }
        catch(HibernateException h)
        {
            
            System.out.println(h.getMessage());
        }
        
        return p;
    }
    
    public String searchPerson(String Email,String Password)
    {
                String ret="";

        try
        {
        List l=viewPerson(new users());
            System.out.println(l.size());
            Session ses=sf.openSession();
            System.out.println("kuch hua");      
            Criteria cr=ses.createCriteria(classes.users.class);
            System.out.println(Email);
            cr.add(Restrictions.eq("Email",Email));
            if(!cr.list().isEmpty())
            {
            System.out.println(Password);
            cr.add(Restrictions.eq("Password",Password));
            if(!cr.list().isEmpty())
            {
                l=cr.list();
              System.out.println("successfull\n"+((users)(l.get(0))).toString());
              ret="successfull";
            }
            else
            {
                ret="Password Incorrect";
            }
            }
            else
            {
                ret="Email Incorrect";
            }
            
          }
        catch(HibernateException e)
        {
             System.out.println("---error"+e.getMessage());
        }
        
        return ret;
    }
//    public admin searchAdmin(int aid)
//    {
//        Session s=sf.openSession();
//         Transaction tx=s.beginTransaction();
//         admin ad=null;
//         String msg="";
//         try{
//         
//         ad=(admin)s.get(admin.class, aid);
//         
//            
//            if(ad==null)
//            {
//                msg="no record found";
//            }
//         }
//         catch(HibernateException h)
//         {
//             System.out.println(""+h.getMessage());
//         }
//        return ad;
//    }
//    public String searchUsers(int uid)
//    {
//        Session s=sf.openSession();
//         Transaction tx=s.beginTransaction();
//         try{
//         users us=null;
//         us=(users)s.load(us.getClass(), uid);
//         }
//         catch(HibernateException h)
//         {
//             System.out.println(""+h.getMessage());
//         }
//        return "Successfull";
//    }
}
