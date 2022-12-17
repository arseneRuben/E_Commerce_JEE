<%-- 
    Document   : index.jsp
    Created on : Dec 13, 2022, 1:06:42 PM
    Author     : isi
--%>

<%@page import="com.isi.travailpratique.entity.Site"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@page import="com.isi.travailpratique.entity.Activity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Activity> activities = (ArrayList<Activity>) request.getAttribute("activities");
    HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
    HashMap<Integer, Activity> activitiesMap = (HashMap<Integer, Activity>) request.getAttribute("activitiesMap");

%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="partials/head.jsp" %>
    </head>
    <body>
        <div class="header-area">            <%@include file="partials/header.jsp" %>
        </div>





        <div class="product-big-title-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-bit-title text-center">
                            <h2>Shopping Cart</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End Page title area -->


        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="single-sidebar">
                            <h2 class="sidebar-title">Search Activities</h2>
                            <form action="search">
                                <input type="text" placeholder="Search products..." name="pattern">
                                <input type="submit" value="Search">
                            </form>
                        </div>
                        <div class="single-sidebar">
                            <h2 class="sidebar-title">Products</h2>

                            <%
                                if (activities != null) {
                                    for (Activity a : activities) {

                            %>
                            <div class="thubmnail-recent">
                                <img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
                                <h2><a href="index?id=<%= a.getId()%>"><%= a.getWording()%></a></h2>
                                <div class="product-sidebar-price">
                                    <ins>$<%= a.getPrice()%></ins> <del><%= a.getPrice() * 5%></del>
                                </div>             
                            </div>
                            <% }
                                }%>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="product-content-right">
                            <div class="woocommerce">

                                <table cellspacing="0" class="shop_table cart">
                                    <thead>
                                        <tr>


                                            <th class="product-name">Product</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-subtotal">Total</th>
                                            <th class="product-remove">&nbsp;</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%! float total = 0;%>
                                        <% if (cart != null && activitiesMap != null) {

                                       for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {%>
                                            <tr class="cart_item">
                                                <% total += activitiesMap.get(entry.getKey()).getPrice() * entry.getValue();%>
                                                <td class="product-name">

                                                    <a href="index?id=<%= activitiesMap.get(entry.getKey()).getId()%>">
                                                        <%= activitiesMap.get(entry.getKey()).getWording()%> 
                                                    </a> 

                                                </td>

                                                <td class="product-price">
                                                    <span class="amount">£ <%= activitiesMap.get(entry.getKey()).getPrice()%>  </span> 
                                                </td>

                                                <td class="product-quantity">
                                                    <div class="quantity buttons_added">
                                                        <form method="post" action="cart">
                                                            <input type="hidden" name="activity" value="<%= activitiesMap.get(entry.getKey()).getId()%>"/>
                                                            <input type="hidden" name="action" value="plus"/>
                                                            <input type="submit" class="minus" value="+">
                                                        </form>
                                                        <input type="number" size="4" class="input-text qty text" title="Qty" value="<%= cart.get(activitiesMap.get(entry.getKey()).getId())%>" min="0" step="1">
                                                        <form method="post" action="cart">
                                                            <input type="hidden" name="activity" value="<%= activitiesMap.get(entry.getKey()).getId()%>"/>
                                                            <input type="hidden" name="action" value="minus"/>
                                                            <input type="submit" class="plus" value="-">
                                                        </form>
                                                    </div>
                                                </td>
                                                <td class="product-subtotal">
                                                    <span class="amount">£ <%= activitiesMap.get(entry.getKey()).getPrice() * cart.get(activitiesMap.get(entry.getKey()).getId())%> </span> 
                                                </td>
                                                <td class="product-remove">
                                                    <form method="post" action="cart">
                                                        <input type="hidden" name="action" value="delete"/>
                                                        <input type="hidden" name="activity" value="<%= activitiesMap.get(entry.getKey()).getId()%>"/>
                                                        <input type="submit" class="remove btn btn-danger" value="×"/>
                                                    </form>
                                                </td>

                                            </tr>
                                        <% }
                                            }%>
                                        <tr>
                                    <form method="post" action="cart">
                                        <input type="hidden" name="action" value="checkout"/>
                                        <td class="actions" colspan="6">
                                            <div class="coupon">
                                                <label for="coupon_code">Total</label>
                                                <label>  <%= total%> </label>

                                            </div>
                                            <% if(user != null) { %>
                                            <input type="submit" value="Proceed to checkout" name="proceed" class="checkout-button button alt wc-forward">
                                            <% } else {%>
                                            <a href="signin" class="btn btn-warning">Login</a>
                                             <% } %>
                                        </td>
                                    </form>
                                    </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <%@include file="partials/footer.jsp" %>



    </body>
</html>
