<%-- 
    Document   : chercherRayonParId
    Created on : 14 mars 2018, 16:41:33
    Author     : 5153218
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="Entites.Autre.Rayon"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chercher rayon</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="rayon" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <form method="POST" action="...">
                <div class="recherche">
                    <div class="col-md-4">
            <input type="text" name="keyword" placeholder="Recherche un rayon.."value="Recherche"/>
                    <button class="btn btn-success">ok</button>
                    </div>
                </div>
            <h2>Liste des rayons</h2>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Identifiant</th>
                        <th>Nom</th>
                    </tr>
                </thead>
                <tbody>
                <% Collection<Rayon> _rayon = rayon;
          for (Rayon r : _rayon) {%>
                <tr>
                    <td><%=r.getId()%></td>
                    <td><%=r.getNom()%></td>
                </tr><%}%>
            </tbody>
            </table>
            </form>
            </div>
    </body>
</html>
