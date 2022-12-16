
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.isi.travailpratique.controller;

import com.isi.travailpratique.entity.Activity;
import com.isi.travailpratique.entity.Site;
import com.isi.travailpratique.entity.User;
import com.isi.travailpratique.manager.ActivityManager;
import com.isi.travailpratique.manager.SiteManager;
import com.isi.travailpratique.manager.UserManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
@WebServlet(name = "IndexServlet", urlPatterns = {"/index", "/cart", "/site", "/search"})
public class IndexServlet extends HttpServlet {

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
        List<Activity> activities = ActivityManager.findAll();
        List<Site> sites = SiteManager.findAll();
         HttpSession userSession;
        switch (request.getServletPath()) {
            case "/search":
            case "/cart":
                if (request.getMethod().equals("GET")) {
                    String pattern = request.getParameter("pattern");
                    if (pattern != null) {
                        activities = ActivityManager.findByName(pattern);
                        request.setAttribute("activities", activities);
                    }
                    request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);
                } 
                if (request.getMethod().equals("POST")) {
                    userSession = request.getSession(true);
                    HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>)userSession.getAttribute("cart");
                }
                break;
            case "/index":
                if (request.getParameter("id") != null) {
                    Activity activity = ActivityManager.findById(Integer.parseInt(request.getParameter("id")));
                    request.setAttribute("activity", activity);
                    //other activities of the same site
                    List<Activity> otherActivities = ActivityManager.findBySiteId(activity.getSite_id());
                    request.setAttribute("otherActivities", otherActivities);
                    request.getRequestDispatcher("WEB-INF/activity.jsp").forward(request, response);

                } else {
                    request.setAttribute("activities", activities);
                    request.setAttribute("sites", sites);
                    System.out.println(sites.size());
                }
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
                break;

            case "/site":
                int idSite = Integer.parseInt(request.getParameter("id"));
                activities = ActivityManager.findBySiteId(idSite);
                request.setAttribute("activities", activities);

                //request.setAttribute("sites", SiteManager.findAll());
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

                break;
            default:
                throw new AssertionError();
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
