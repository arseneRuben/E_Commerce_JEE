/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.isi.travailpratique.controller;

import com.isi.travailpratique.entity.User;
import com.isi.travailpratique.manager.UserManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author isi
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/signin", "/signup", "/signout"})
public class UserServlet extends HttpServlet {

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
        HttpSession userSession;
        switch (request.getServletPath()) {
            case "/signin":
                String email = request.getParameter("email");
                String psw = request.getParameter("password");

                if (UserManager.findOneBy(email, psw) != null) {
//            Cookie cookieUser = new Cookie();
                    userSession = request.getSession(true);
                    userSession.setAttribute("user", UserManager.findOneBy(email, psw));
                    request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("WEB-INF/checkout.jsp").forward(request, response);

                }
                break;
            case "/signup":
                String emailRegis = request.getParameter("email");
                String pswRegis = request.getParameter("password");
                String pswCheck = request.getParameter("passwordCheck");
                if(emailRegis!=null && pswRegis != null && pswRegis.equals(pswCheck) ){
                if (UserManager.findOneByEmail(emailRegis) == null) {
                    

                        User user = new User(emailRegis, pswRegis, 0);
                        if (UserManager.insert(user) != -1) {
                            request.getRequestDispatcher("WEB-INF/checkout.jsp").forward(request, response);
                        }
                }
                } else {
                    //showMessageDialog(null, "passwords don't match");
                    request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
                }
                break;
            case "/signout":
                userSession = request.getSession();
                userSession.invalidate();
                response.sendRedirect("index");
                break;
            default:
                throw new AssertionError();
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
