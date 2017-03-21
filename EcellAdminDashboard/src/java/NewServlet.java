/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ecsdatalayer.personoperation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

/**
 *
 * @author jayesh
 */
public class NewServlet extends HttpServlet {

   

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         System.out.println("----do post----");
        PrintWriter out = response.getWriter();
           SessionFactory sf=(SessionFactory)(this.getServletContext().getAttribute("sf"));
            personoperation po=new personoperation(sf);
            out.println(po.searchPerson(request.getParameter("txtn"),request.getParameter("txtp")));
    }

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
