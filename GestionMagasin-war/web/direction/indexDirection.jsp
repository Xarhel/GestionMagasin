<%-- 
    Document   : indexDirection
    Created on : 19 mars 2018, 13:05:15
    Author     : jules
--%>


<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Gestion Magasin</title>
        <jsp:include page="include/header.jsp"/>
        <style>
            .jumbotron{
                background-image: url("images/Magasin_Aarhus.jpg");
                width: 100%;                    
                color: #fff;
                background-size:cover;
                background-position: center;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menuDirection.jsp"/>           
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">                
                <h1 >Bienvenue dans votre magasin</h1>
            </div>
        </div> <!-- /container -->
    </div>
</body>
</html>