/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reverseCookBook.CookBookDataBase.RCookBookDataBase;

/**
 *
 * @author maimonlior
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Servlets/LoginServlet"})
public class LoginServlet extends HttpServlet {

    RCookBookDataBase rCookBookDB;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (   // get response writer
                PrintWriter out = response.getWriter()){
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            // read form fields
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // build HTML code
            String htmlRespone = "<html>";
            htmlRespone += "<h2>From the form: <br/>"
                        + "Your username is: " + username + "<br/>"
                        + "Your password is: " + password + "</h2>";
            out.println(htmlRespone);

            // Bakara
            System.out.println("username: " + username);
            System.out.println("password: " + password);

            // do some processing here...
            rCookBookDB = new RCookBookDataBase();
            rCookBookDB.connectToDataBase();

            String sql = "SELECT User_Name, Password FROM Users WHERE User_Name = ? AND Password = ?";            
            PreparedStatement stmt = rCookBookDB.getCon().prepareStatement(sql);
//            PreparedStatement pstmt = null;
//            pstmt = rCookBookDB.getCon().prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            System.out.println("Sql: " + sql);
            ResultSet rs = stmt.executeQuery();
            
//            ResultSet rs = rCookBookDB.executeQueryFromDataBase(sql);
            System.out.println("DataBase user name is: " + rs.getString(1) + " DataBase Password: " + rs.getString(2));
            
            String db_user_name;
            String db_password;
            while (rs.next()) {  // rs => next row
//                int id_col = rs.getInt("ID");
//                String first_name = rs.getString("First_Name");
                db_user_name = rs.getString("User_Name");
                db_password = rs.getString("Password");
//                String last_name = rs.getString("Last_Name");
//                String address = rs.getString("Address");
//                Date birthDate = rs.getDate("Birthdate");
                System.out.println("DataBase user name is: " + db_user_name + " DataBase Password: " + db_password);

//              // build HTML code
                htmlRespone = "<html>";
                htmlRespone += "<h2>From the DATABASE: <br/>"
                            + "username is: " + db_user_name + "<br/>"
                            + "password is: " + db_password + "</h2>";
                out.println(htmlRespone);
//                System.out.println(id_col + " " + first_name + " " + last_name + " " + address + " " + birthDate);
            }
        } catch (Exception ex) {
            response.setStatus(400);
            response.getWriter().write(ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
