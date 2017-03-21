/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author jayesh
 */
public class HibernateUtility implements ServletContextListener{

    private SessionFactory sessionfactory=null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext sc=sce.getServletContext();
        try{
            System.out.println("__________________________Going to check config files________________________________________");
            Configuration cf=new Configuration();                
            Configuration cfg=cf.configure("/hbmfolder/hibernate.cfg.xml");
            sessionfactory=cfg.buildSessionFactory();
            System.out.println("______________________________done______________________________");
            sc.setAttribute("sf",sessionfactory);
        }
        catch(HibernateException e)
            {
                    System.out.println(e.getMessage());
            }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         try{
            ServletContext sc=sce.getServletContext();
            sessionfactory=(SessionFactory)sc.getAttribute("sf");
            sessionfactory.close();
            System.out.println("\n\ndone");
            
        }
        catch(HibernateException e)
            {
                    System.out.println(e.getMessage());
            }
        
    }
    
}
