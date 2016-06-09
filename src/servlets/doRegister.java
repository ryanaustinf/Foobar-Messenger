/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dbhandler.DBManager;
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

/**
 *
 * @author miguelgomez
 */
@WebServlet(name = "Registrator", urlPatterns = {"/Registrator"})
public class doRegister extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DBManager dbConnector = null;
        String userName = null;
        String userPassword = null;
        String userFirstName = null;
        String userLastName = null;
        String userEmail = null;
        String userMailAddress = null;

        try {
            //Get user information
            userName = request.getParameter("user_name");
            userPassword = request.getParameter("user_password");
            userFirstName = request.getParameter("user_first_name");
            userLastName = request.getParameter("user_last_name");
            userEmail = request.getParameter("user_email");
            userMailAddress = request.getParameter("user_mail_address");
            //Valdiate user information
            dbConnector = DBManager.getInstance();
            //Create new user
            dbConnector.createUser(2, userName, userPassword, userFirstName, userLastName, userEmail, userMailAddress);
            //Redirect to login page
            response.sendRedirect("index.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Extract.class.getName()).log(Level.SEVERE, null, ex);
            //Log this properly
        } catch (SQLException ex) {
            Logger.getLogger(Extract.class.getName()).log(Level.SEVERE, null, ex);
            //Log this properly
        } finally {        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
