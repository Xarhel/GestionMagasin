<%-- 
    Document   : RechercherEmploye
    Created on : 15 mars 2018, 16:03:46
    Author     : jules
--%>

<%@page import="Entites.Personne.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rechercher employé</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="employe" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menuDirection.jsp"/>
            <!-- BODY START -->
            <form method="POST" action="...">
                <div class="recherche">
                    <div class="col-md-4">
            <input type="text" name="keyword" placeholder="Rechercher un employé.."value="Recherche"/>
                    <button class="btn btn-success">ok</button>
                    </div>
                </div>
            <h2>Liste des employées</h2>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                    </tr>
                </thead>
                <tbody>
                <% Collection<Employe> _employe = employe;
                    for (Employe e : _employe) {%>
                <tr>
                    <td><%=e.getNomPersonne()%></td>
                    <td><%=e.getPrenomPersonne()%></td>
                </tr><%}%>
            </tbody>
            </table>
            </form>
            </div>
            
    </body>
</html>

