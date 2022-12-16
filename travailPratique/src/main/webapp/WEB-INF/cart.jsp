<%-- 
    Document   : index.jsp
    Created on : Dec 13, 2022, 1:06:42 PM
    Author     : isi
--%>

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
        <%@include file="partials/nav.jsp" %>
        <div class="slider-area">
            <%@include file="partials/slider.jsp" %>
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
                                <h2><a href="single-product.html">Sony Smart TV - 2015</a></h2>
                                <div class="product-sidebar-price">
                                    <ins>$700.00</ins> <del>$800.00</del>
                                </div>             
                            </div>
                            <% }
                                }%>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="product-content-right">
                            <div class="woocommerce">
                                <form method="post" action="#">
                                    <table cellspacing="0" class="shop_table cart">
                                        <thead>
                                            <tr>
                                                <th class="product-remove">&nbsp;</th>

                                                <th class="product-name">Product</th>
                                                <th class="product-price">Price</th>
                                                <th class="product-quantity">Quantity</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                        
                                            <% if (cart != null) {
                                                  
                                                  for(Map.Entry<Integer, Integer> entry : cart.entrySet()) { %>
                                            <tr class="cart_item">
                                                <td class="product-remove">
                                                    <a title="Remove this item" class="remove" href="#">×</a> 
                                                </td>



                                                <td class="product-name">
                                                    <a href="single-product.html">
                                                        <%= activitiesMap.get(entry.getKey()).getWording() %>
                                                       </a> 
                                                </td>

                                                <td class="product-price">
                                                    <span class="amount">$<%= activitiesMap.get(entry.getKey()).getPrice() %></span> 
                                                </td>

                                                <td class="product-quantity">
                                                    <div class="quantity buttons_added">
                                                        <input type="button" class="minus" value="-">
                                                        <input type="number" size="4" class="input-text qty text" title="Qty" value="1" min="0" step="1">
                                                        <input type="button" class="plus" value="+">
                                                    </div>
                                                </td>

                                               
                                            </tr>
                                            <% }
                                                }%>
                                            <tr>
                                                <td class="actions" colspan="6">
                                                    <div class="coupon">
                                                        <label for="coupon_code">Coupon:</label>
                                                        <input type="text" placeholder="Coupon code" value="" id="coupon_code" class="input-text" name="coupon_code">
                                                        <input type="submit" value="Apply Coupon" name="apply_coupon" class="button">
                                                    </div>
                                                    <input type="submit" value="Update Cart" name="update_cart" class="button">
                                                    <input type="submit" value="Checkout" name="proceed" class="checkout-button button alt wc-forward">
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <%@include file="partials/footer.jsp" %>



    </body>
</html>
