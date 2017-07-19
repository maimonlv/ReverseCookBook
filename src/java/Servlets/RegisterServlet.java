/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reverseCookBook.CookBookDataBase.RCBUsersDataBaseConnector;
import reverseCookBook.Model.Users.User;

/**
 *
 * @author maimonlior
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/Servlets/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    RCBUsersDataBaseConnector rCookBookDBConnect;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String fname = request.getParameter("firstName");
            String lname = request.getParameter("lastName");
            String addr = request.getParameter("address");
            String bDate = request.getParameter("birthDate");
            String userName = request.getParameter("userName");
            String pass = request.getParameter("password");
            String email = request.getParameter("email");
            //debugging
            System.out.println("before new user");
            
            User user = new User(fname, lname, addr, bDate, userName, pass, email);
            System.out.println("We got: fname=" + fname + 
                    "lname = " + lname + 
                    "addr = " + addr + 
                    "bDate = " + bDate + 
                    "userName = " + userName + 
                    "pass = " + pass + 
                    "email = " + email);
            out.print("We Got The Information Please Wait... ");
            System.out.println("We Got The Information Please Wait... ");
            
            // do some processing here...
            rCookBookDBConnect = new RCBUsersDataBaseConnector();
            rCookBookDBConnect.connectToUsersDataBase();
            
            out.print("We Successfully Connected to DataBase ");
            System.out.println("We Successfully Connected to DataBase ");
            
            rCookBookDBConnect.prepareStatement("insert into USERS values(?,?,?,?,?,?,?,?,?)");
            rCookBookDBConnect.setPreparedStmntInt(1, user.getUserID());
            rCookBookDBConnect.setPreparedStmntString(2, lname);
            rCookBookDBConnect.setPreparedStmntString(3, fname);
            rCookBookDBConnect.setPreparedStmntString(4, addr);
            rCookBookDBConnect.setPreparedStmntString(5, bDate);
            rCookBookDBConnect.setPreparedStmntString(6, userName);
            rCookBookDBConnect.setPreparedStmntString(7, pass);
            rCookBookDBConnect.setPreparedStmntString(8, email);
            rCookBookDBConnect.setPreparedStmntString(9, "1");
            
            
            out.print("We Successfully prepared the statement ");
            System.out.println("We Successfully prepared the statement ");
            
            int i = rCookBookDBConnect.getPs().executeUpdate();
            if (i > 0){
                out.print("You are successfully registered... ");
                System.out.println("You are successfully registered... ");
            }
                
        }
        catch(Exception e2) {
            
            System.out.println("EXCEPTION: Servlets.RegisterServlet.processRequest(): e2");
            
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
