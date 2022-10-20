package edu.jsu.mcis.lab6;

import edu.jsu.mcis.lab6.dao.AttendeesDAO;
import edu.jsu.mcis.lab6.dao.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AttendeesServlet", urlPatterns = {"/AttendeesServlet"})
public class AttendeesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AttendeesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendeesServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DAOFactory daoFactory = null;

        ServletContext context = request.getServletContext();

        if (context.getAttribute("daoFactory") == null) {
            System.err.println("*** Creating new DAOFactory ...");
            daoFactory = new DAOFactory();
            context.setAttribute("daoFactory", daoFactory);
        }
        else {
            daoFactory = (DAOFactory) context.getAttribute("daoFactory");
        }
        
        response.setContentType("application/json; charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            
            int attendeeid = Integer.parseInt(request.getParameter("attendeeid"));
            
            AttendeesDAO Adao = daoFactory.getAttendeesDAO();
            
            out.println(Adao.list(attendeeid));
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DAOFactory daoFactory = null;

        ServletContext context = request.getServletContext();

        if (context.getAttribute("daoFactory") == null) {
            System.err.println("*** Creating new DAOFactory ...");
            daoFactory = new DAOFactory();
            context.setAttribute("daoFactory", daoFactory);
        }
        else {
            daoFactory = (DAOFactory) context.getAttribute("daoFactory");
        }
        
        response.setContentType("application/json; charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            
            HashMap<String, String> hashmap = new HashMap<>();
            
            hashmap.put("attendeeid", request.getParameter("attendeeid"));
            hashmap.put("firstname", request.getParameter("firstname"));
            hashmap.put("lastname", request.getParameter("lastname"));
            hashmap.put("displayname", request.getParameter("displayname"));
            
            AttendeesDAO Adao = daoFactory.getAttendeesDAO();
            out.println(Adao.create(hashmap));
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DAOFactory daoFactory = null;

        ServletContext context = request.getServletContext();

        if (context.getAttribute("daoFactory") == null) {
            System.err.println("*** Creating new DAOFactory ...");
            daoFactory = new DAOFactory();
            context.setAttribute("daoFactory", daoFactory);
        }
        else {
            daoFactory = (DAOFactory) context.getAttribute("daoFactory");
        }
        
        response.setContentType("application/json; charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            
            HashMap<String, String> hashmap = new HashMap<>();
            
            hashmap.put("attendeeid", request.getParameter("attendeeid"));
            hashmap.put("firstname", request.getParameter("firstname"));
            hashmap.put("lastname", request.getParameter("lastname"));
            hashmap.put("displayname", request.getParameter("displayname"));
            
            AttendeesDAO Adao = daoFactory.getAttendeesDAO();
            out.println(Adao.update(hashmap));
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
