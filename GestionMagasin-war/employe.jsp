<%-- 
    Document   : employe
    Created on : 14 mars 2018, 10:21:30
    Author     : 5153218
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
                        <% Collection<Employe> _employes = employe;
                            for (Employe e : _employes) {%>
                        <tr><td><%=e.getNomPersonne()%></td>
                            <td><%=e.getPrenomPersonne()%></td>
                            <td><%=e.getDateCreationCompte()%></td>
                            <td><%=e.getTypeCompte()%></td>
                            
                            <td><a href="Menu?action=pagemodifierEmploye&id=<%=e.getId()%>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-edit" title="Modifier un employée"></span>Modifier
                                </a>
                                    <a href="Menu?action=pagesupprimerEmploye&id=<%=e.getId()%>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-edit" title="Supprimer un employe"></span>Supprimer
                                </a>
                                
                            </td>
                        </tr><%}%>
                    </tbody>
                </table>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
