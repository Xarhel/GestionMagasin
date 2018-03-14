<%-- 
    Document   : rechercherMagasinParNom
    Created on : 14 mars 2018, 13:40:51
    Author     : 5153218
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="Entites.Autre.Magasin"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rechercher magasin par nom du magasin</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="magasin" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <input type="text" placeholder="Rechercher par nom du magasin..">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Identifiant</th>
                        <th>Nom</th>
                    </tr>
                </thead>
                <tbody>
                <% Collection<Magasin> _magasin = magasin;
          for (Magasin m : _magasin) {%>
                <tr>
                    <td><%=m.getId()%></td>
                    <td><%=m.getNom()%></td>
                </tr><%}%>
            </tbody>
    </body>
</html>
