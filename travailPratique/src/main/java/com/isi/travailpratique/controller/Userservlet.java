/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.isi.travailpratique.controller;

import com.isi.travailpratique.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.isi.travailpratique.manager.UserManager;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author isi
 */
@WebServlet(name = "Userservlet", urlPatterns = {"/signin"})
public class Userservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("username");
        String psw = request.getParameter("password");
        User user = UserManager.findOneBy(email, psw);
        System.out.println(user);
        if (user != null) {
            HttpSession userSession = request.getSession(true);
            userSession.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/cart.jsp");
        } else {
            request.getRequestDispatcher("WEB-INF/checkout.jsp").forward(request, response);
        }
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
