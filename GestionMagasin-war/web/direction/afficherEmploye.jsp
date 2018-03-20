<%-- 
    Document   : afficherEmploye
    Created on : 19 mars 2018, 10:38:06
    Author     : jules
--%>

<%@page import="Entites.Personne.Employe"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des employées</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="employe" scope="request" class="java.util.Collection"></jsp:useBean>
       
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des employées</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Date de création du compte</th>
                            <th>Type de Compte</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Date de création du compte</th>
                            <th>Type de Compte</th>
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Employe> _employe = employe;
                            for (Employe e : _employe) {%>
                        <tr><td><%=e.getNomPersonne()%></td>
                            <td><%=e.getPrenomPersonne()%></td>
                            <td><%=e.getDateCreationCompte()%></td>
                            <td><%=e.getTypeCompte()%></td>
                        </tr><%}%>
                    </tbody>
                </table>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
