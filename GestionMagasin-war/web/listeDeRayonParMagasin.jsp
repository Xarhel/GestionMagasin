<%-- 
    Document   : ListeDeRayonParMagasin
    Created on : 15 mars 2018, 09:47:41
    Author     : jules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="Entites.Autre.Rayon"%>
<%@page import="Entites.Autre.Magasin"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chercher rayon par magasin</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="rayon" scope="request" class="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="magasin" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des rayons</h1>
            <table class="table.table-hover">
                <thead>
                    <tr>
                        <th>Nom du rayon</th>
                        <th>Nom du magasin</th>
                    </tr>
                </thead>
                <tbody>
                <% Collection<Rayon> _rayons = rayons;
                for (rayon r : _rayons) {%>
                <tr>
                    <td><%=r.getRayonNom()%></td>
                    <td><%=r.getMadasi().getNom()%></td>
                </tr><%}%>
            </tbody>
            </table>
            </div>
    </body>
</html>
