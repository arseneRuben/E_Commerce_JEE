package com.isi.travailpratique.controller;

import com.isi.travailpratique.manager.SiteManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SiteDescriptionServlet", urlPatterns = {"/siteDescription"})
public class SiteCategoryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
        int id = Integer.parseInt(req.getParameter("id"));
       // Site site = SiteManager.findById(id);
        req.setAttribute("site", SiteManager.findById(id));
        req.getRequestDispatcher("WEB-INF/category.jsp").forward(req, resp);
    }


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

}
