package edu.jsu.mcis.lab6.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

        
    public class AttendeesDAO {
    
        private final DAOFactory daoFactory;

        private final String QUERY_ATTENDEE_LIST = "SELECT * FROM attendee";

        AttendeesDAO(DAOFactory dao) {
            this.daoFactory = dao;
        }
        
    
    
    public String getAttendeesListAsHTML() {
        
        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(QUERY_ATTENDEE_LIST);
            
            boolean hasresults = ps.execute();
            
            s.append("<select>");
            s.append("<option selected value=\"").append("\">");
            s.append("Select Name:");
            s.append("</option>");
            
            if (hasresults) {

                rs = ps.getResultSet();
                
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    //String firstname = rs.getString("firstname");
                    //String lastname = rs.getString("lastname");
                    String displayname = rs.getString("displayname");
                    
                    s.append("<option value=\"").append(id).append("\">");
                    //s.append(firstname);
                    //s.append(lastname);
                    s.append(displayname);
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
    

    public boolean list(int attendeeid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean create(HashMap<String, String> hashmap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean update(HashMap<String, String> hashmap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
