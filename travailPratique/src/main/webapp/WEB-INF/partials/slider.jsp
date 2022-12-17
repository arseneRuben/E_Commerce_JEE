 
<!-- Slider -->

<div class="block-slider block-slider4">
     <h2 class="section-title">Our sites for different activities</h2>
    <ul class="" id="bxslider-home4">
        <%     if (sites != null) {
                for (Site site : sites) {
        %>
        <li>
            <% if(site.getImages().size()>0  ){ %>
                <img src="img/<%= site.getImages().get(0).getPath() %>" alt="img/<%=  site.getName()  %>">
            <% }else { %>
            <img src="img/montreal_slide1.jpg" alt="Slide">
            <% } %>
            <div class="caption-group">
                
             <h2><a href="site?id=<%=site.getId()%>"><%= site.getName()%></a></h2>
                            <div class="product-sidebar-price">
                                <ins><%= site.getAddress()%></ins> 
                            </div> 
            	</div>
        </li>
        <%
                }
            }
        %>

    </ul>
</div>
<!-- ./Slider -->
