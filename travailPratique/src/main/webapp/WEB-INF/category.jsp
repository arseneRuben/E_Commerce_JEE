<%@page import="com.isi.travailpratique.entity.Image"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.isi.travailpratique.entity.Site"%>
<%
    Site site = null;
    if (request.getAttribute("site") != null) {
        site = (Site) request.getAttribute("site");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="partials/head.jsp" %>
    </head>
    <body>
        <div class="header-area">            <%@include file="partials/header.jsp" %>
        </div>
        <%@include file="partials/nav.jsp" %>
        <div class="slider-area">
            <%@include file="partials/slider.jsp" %>
        </div>

        <%for (Image img : site.getImages()) {%>
        <img src="image/<%= img.getPath()%>" alt="<%= img.getItem_id()%>"/>

        <% }%>
    </div>
    <ul>
        <li><%=site.getName()!=null?site.getName():"image non disponible"%></li>
        <li><%=site.getAddress()!=null?site.getAddress():"Adresse non disponile"%></li>
        <li><%=site.getDescription()!=null?site.getDescription():"non decrite"%></li>
        <li><a href="siteDescription?id=<%=site.getId()!=0?site.getId():0%>">Detail...</a></li>
    </ul>
    
</body>
</html>
