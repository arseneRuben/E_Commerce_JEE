<%-- 
    Document   : index.jsp
    Created on : Dec 13, 2022, 1:06:42 PM
    Author     : isi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.isi.travailpratique.entity.Activity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Activity> activities = (ArrayList<Activity>) request.getAttribute("activities");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="partials/head.jsp" %>
    </head>
    <body>
        <%@include file="partials/nav.jsp" %>
   



        <div class="product-big-title-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-bit-title text-center">
                            <h2>Login</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End Page title area -->


        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                     <div class="col-md-7">
                        <div class="product-content-right">
                            <div class="woocommerce">
                                <div class="woocommerce-info">Returning customer? <a class="showlogin" data-toggle="collapse" href="#login-form-wrap" aria-expanded="false" aria-controls="login-form-wrap">Click here to login</a>
                                </div>

                                <form id="login-form-wrap" action="signin" class="login collapse" method="get">

 
                                    <p>If you have shopped with us before, please enter your details in the boxes below. If you are a new customer please proceed to the Billing &amp; Shipping section.</p>

                                    <p class="form-row form-row-first">
                                        <label for="username">Username or email <span class="required">*</span>
                                        </label>
                                        <input type="text" id="username" name="email" class="input-text">
                                    </p>
                                    <p class="form-row form-row-last">
                                        <label for="password">Password <span class="required">*</span>
                                        </label>
                                        <input type="password" id="password" name="password" class="input-text">
                                    </p>
                                    <div class="clear"></div>


                                    <p class="form-row">
                                        <input type="submit" value="Login" class="button">
                                        <label class="inline" for="rememberme"><input type="checkbox" value="forever" id="rememberme" name="rememberme"> Remember me </label>
                                    </p>
                                   

                                    <div class="clear"></div>
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
