package edu.jsu.mcis.lab6;

import edu.jsu.mcis.lab6.dao.TrainingSessionsDAO;
import edu.jsu.mcis.lab6.dao.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TrainingSessionsServlet", urlPatterns = {"/TrainingSessionsServlet"})
public class TrainingSessionsServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrainingSessionsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrainingSessionsServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // Handles the HTTP <code>GET</code> method.
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DAOFactory daoFactory = new DAOFactory();
        
        TrainingSessionsDAO trainSes = daoFactory.getTrainingSessionsDAO();
        
        response.setContentType("application/json; charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            String p_id = request.getParameter("id"); 
            
            if (p_id == null || "".equals(p_id)) { 
            /* corresponding code */ 
            out.println(trainSes.list());
            
            }
            
            else{
                out.println(trainSes.list(Integer.parseInt(p_id)));
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    //Handles the HTTP <code>POST</code> method.
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
