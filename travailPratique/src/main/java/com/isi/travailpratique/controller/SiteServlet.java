package com.isi.travailpratique.controller;

import com.isi.travailpratique.manager.SiteManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

@WebServlet(name = "SiteServlet", urlPatterns = {"/siteServlet"})
public class SiteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //HttpSession session=req.getSession(true);
        if (SiteManager.findAll() != null) {
            req.setAttribute("sites", SiteManager.findAll());
            req.getRequestDispatcher("WEB-INF/site.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
