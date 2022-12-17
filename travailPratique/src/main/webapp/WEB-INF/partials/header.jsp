<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.isi.travailpratique.entity.Site"%>
<%@page import="com.isi.travailpratique.entity.User"%>
<%
    User user = (User) session.getAttribute("user");
    List<Site> sites = (ArrayList<Site>) request.getAttribute("sites");

%>
<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">
                    <ul>
                        <li><a href="index"><i class="fa fa-home"></i> Home</a></li>
                        <li><a href="cart"><i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                My Cart</a></li>
                                <% if (user != null) {%>
                        <li><a href="signout"><i class="fa fa-user"></i> Logout</a></li>
                            <%} else {%>
                        <li><a href="signin"><i class="fa fa-user"></i> Login</a></li>
                        <li><a href="signup"><i class="fa fa-user-plus" aria-hidden="true"></i> Signup</a></li>
                            <%}%>
                    </ul>
                </div>
            </div>

            <div class="col-md-4">
                <div class="header-right">
                    <ul class="list-unstyled list-inline">
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div><!-- comment -->
<!-- End header area -->
<% if (user != null) {%>
<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="logo">
                    <h1><a href="index"><img src="img/logo.png"></a></h1>
                </div>
            </div>

            <div class="col-sm-6">
                  <%  if(request.getServletPath().contains("cart") ){  %>
                <div class="shopping-item">
                    <a href="cart">Cart <i class="fa fa-shopping-cart"></i> </a>
                </div>
                 <% } %>
            </div>
        </div>
    </div>
</div> <!-- End site branding area -->

<div class="mainmenu-area">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div> 
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    
                    <li class="<%= request.getServletPath().contains("index")?"active":"" %>"><a href="index">Bienvenu(e)   <%= user.getEmail()  %>  </a></li>
                    <li class="<%= request.getServletPath().contains("cart")?"active":"" %>" ><a href="cart"> Panier</a></li>
                    <li><a href="signout">Logout</a></li>



                </ul>
            </div>  
        </div>
    </div>
</div> <!-- End mainmenu area -->
<% }%>