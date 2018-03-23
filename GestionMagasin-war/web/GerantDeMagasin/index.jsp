<%-- 
    Document   : index
    Created on : 21 mars 2018, 08:51:17
    Author     : 5153218
--%>

<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Gestion Magasin</title>
        <jsp:include page="header.jsp"/>
        <style>
            .jumbotron{
               
                width: 100%;                    
                color: #fff;
                background-size:cover;
                background-position: center;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menuEmployeRayon.jsp"/>            
            <!-- Main component for a primary marketing message or call to action -->
            <div class="image">
                <img src="images/Magasin_Aarhus.jpg"  alt="Magasin" class="img-responsive">
            </div>
        </div> <!-- /container -->
    </div>
</body>
</html>>
