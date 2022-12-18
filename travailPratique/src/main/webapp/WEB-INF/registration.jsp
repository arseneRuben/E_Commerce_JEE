<%-- 
    Document   : registration
    Created on : Dec. 15, 2022, 12:18:02 a.m.
    Author     : isi
--%>
<%@page import="com.isi.travailpratique.manager.UserManager"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <div class="col-md-7 col-lg-6 col-xl-5 order-2 order-lg-1">
                        <div class="product-content-right">
                            <div class="woocommerce">
                                <div class="woocommerce-info">Becoming a new customer? <a class="showlogin" data-toggle="collapse" href="#login-form-wrap" aria-expanded="false" aria-controls="login-form-wrap">Click here to signup</a>
                                </div>
                                <form  id="login-form-wrap" action="signup" class="login collapse" method="post">
                                    <p class="form-row form-row-first">
                                        <label for="email">Email <span class="required">*</span>
                                        </label>
                                        <input type="text" id="username" name="email" class="input-text">
                                    </p>
                                    <p class="form-row form-row-last">
                                        <label for="password">Password <span class="required">*</span>
                                        </label>
                                        <input type="password" id="password" name="password" class="input-text">
                                    </p><!-- comment -->
                                    <p class="form-row form-row-last">
                                        <label for="pws">Password <span class="required">*</span>
                                        </label>
                                        <input type="password" id="pws" name="passwordCheck" class="input-text">
                                    </p><!-- comment -->
                                    <div class="clear"></div>


                                    <p class="form-row">
                                        <input type="submit" value="Register" class="button">
                                    </p>


                                    <div class="clear"></div>

                           </form>

                            </div>

                        </div>
                    </div>
                    <div class="col-md-5 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                        <img src="img/tour_montreal_interieur.jpg"
                                             class="img-fluid" alt="Sample image">

                                    </div>
                </div>
            </div>
        </div>

        <%@include file="partials/footer.jsp" %>
    </body>
</html>
