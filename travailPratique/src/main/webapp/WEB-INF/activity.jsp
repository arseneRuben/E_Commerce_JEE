<%-- 
    Document   : activity
    Created on : Dec 13, 2022, 1:55:51 PM
    Author     : isi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.isi.travailpratique.entity.Image"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.isi.travailpratique.entity.Activity"%>

<%
    Activity activity = (Activity) request.getAttribute("activity");
    List<Activity> otherActivities = (ArrayList<Activity>) request.getAttribute("otherActivities");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="partials/head.jsp" %>
    </head>
    <body>
        <%@include file="partials/header.jsp" %>


        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">

                    <div class="col-md-6">
                        <div class="single-sidebar">
                            <h2 class="sidebar-title">Search Activity</h2>
                            <form action="">
                                <input type="text" placeholder="Search products...">
                                <input type="submit" value="Search">
                            </form>
                        </div>

                        <div class="single-sidebar">
                            <h2 class="sidebar-title">Activities of the same site</h2>
                            <%                                for (Activity act : otherActivities) {
                            %>
                            <div class="thubmnail-recent">
                                <img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
                                <h2><a href="index?id=<%= act.getId()%>"><%= act.getWording()%></a></h2>


                            </div>
                            <%
                                }
                            %>
                        </div>


                    </div>
                    <div class="col-md-6">
                        <div class="product-content-right">
                            <div class="product-breadcroumb">
                                <a href="index">Home</a>
                                <a href="site?id=<%=activity.getSite().getId()%>"><%= activity.getSite().getName()%></a>
                                <a href="index?id=<%= activity.getId()%>"><%= activity.getWording()%></a>
                            </div>

                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="product-images">
                                        <div class="product-main-img">
                                            <% if (activity.getImages().size() > 0) {%>
                                            <img src="img/<%= activity.getImages().get(0).getPath() %>" alt="<%= activity.getImages().get(0).getPath() %>">

                                            <% } else { %>
                                            <img src="img/grande_roue1.png" alt="faute d'image de bonne taille on fixe cette image de maniere statique">
                                            <% }%>                                            
                                        </div>


                                    </div>

                                </div>
                                <div class="col-sm-8">
                                    <div class="product-inner">
                                        <h2 class="product-name"><%= activity.getWording()%></h2>
                                        <div class="product-inner-price">
                                            <ins>$<%= activity.getPrice()%></ins>
                                        </div>    

                                        <form method="post" action="cart" class="cart">
                                            <div class="quantity">
                                                <input type="hidden" name="activity" value="<%= activity.getId()%>" />
                                                <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                                            </div>
                                            <button class="add_to_cart_button" type="submit">Add to cart</button>
                                        </form>   
                                    </div>
                                </div>
                            </div>
                        </div>                    
                    </div>
                </div>

            </div>
        </div>



        <%@include file="partials/footer.jsp" %>
    </body>
</html>
