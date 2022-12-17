<div class="footer-top-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="footer-about-us">
                    <h2>U<span>Stora</span></h2>
                    <p>Suivez-nous dans les reseaux sociaux!</p>
                    <div class="footer-social">
                        <a href="https://www.facebook.com/" target="_blank"><i class="fa fa-facebook"></i></a>
                        <a href="https://www.twitter.com" target="_blank"><i class="fa fa-twitter"></i></a>
                        <a href="https://www.youtube.com" target="_blank"><i class="fa fa-youtube"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">User Navigation </h2>
                    <ul>
                        <li><a href="cart">My cart</a></li>
                            <% if (user != null) {%>
                        <li><a href="signout">Signout</a></li>
                            <%} else {%>
                        <li><a href="signin">Signin</a></li>
                        <li><a href="signup">Signup</a></li>
                            <%}%>


                    </ul>                        
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">Categories</h2>
                    <ul>
                        <%     if (sites != null) {
                                for (Site site : sites) {
                        %>
                        <li><a href="site?id=<%=site.getId()%>"><%= site.getName()%></a></li>
                            <%
                                    }
                                }
                            %>
                    </ul>                        
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-newsletter">
                    <h2 class="footer-wid-title">Patners</h2>
                    <div class="newsletter-form">
                        <ul>
                            <li><a href="https://isbbethesda.com/">Bethesda</a></li>
                             <li><a href="https://wafrica.online/">With Africa</a></li>


                        </ul>    
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End footer top area -->


<!-- Latest jQuery form server -->
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- Bootstrap JS form CDN -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- jQuery sticky menu -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.sticky.js"></script>

<!-- jQuery easing -->
<script src="js/jquery.easing.1.3.min.js"></script>

<!-- Main Script -->
<script src="js/main.js"></script>

<!-- Slider -->
<script type="text/javascript" src="js/bxslider.min.js"></script>
<script type="text/javascript" src="js/script.slider.js"></script>