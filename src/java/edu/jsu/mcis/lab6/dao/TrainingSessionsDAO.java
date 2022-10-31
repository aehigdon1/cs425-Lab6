package edu.jsu.mcis.lab6.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TrainingSessionsDAO {
    
    private final DAOFactory daoFactory;
    
    private final String QUERY_SESSION_LIST = "SELECT * FROM session";
    
    TrainingSessionsDAO(DAOFactory dao) {
        this.daoFactory = dao;
    }
    
    public String getSessionListAsHTML() {
        
        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(QUERY_SESSION_LIST);
            
            boolean hasresults = ps.execute();

            if (hasresults) {

                rs = ps.getResultSet();
                
                s.append("<select>");
                
                s.append("<option selected value=\"").append("\">");
                s.append("Choose Session:");
                s.append("</option>");
                
                while (rs.next()) {
                    
                    int id = rs.getInt("id");
                    String description = rs.getString("description");
                    
                    s.append("<option value=\"").append(id).append("\">");
                    s.append(description);
                    s.append("</option>");
                                        
                }
                
                s.append("</select>");

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }

        }
        
        return s.toString();
        
    }

    public boolean list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean list(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
