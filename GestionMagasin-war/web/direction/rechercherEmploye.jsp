<%-- 
    Document   : rechercherEmploye
    Created on : 20 mars 2018, 10:50:09
    Author     : jules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="Entites.Personne.Employe"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chercher article</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="employe" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>    
                <form method="POST" action="Administrateur">
                    <div class="recherche">
                        <div class="col-md-4">
                            <input type="text" name="keyword" placeholder="Rechercher employé.."value="Recherche"/>
                            <button>Rechercher</button>
                        </div>
                    </div>

                    <h1>Liste des employées</h1>
                    <table id="example" class="table table-striped table-bordered" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Type de Compte</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Type de Compte</th>
                                <th>Actions</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <% Collection<Employe> _employe = employe;
                            for (Employe e : _employe) {%>
                            <tr><td><%=e.getNomPersonne()%></td>
                                <td><%=e.getPrenomPersonne()%></td>
                                <td><%=e.getTypeCompte()%></td>

                                <td><a href="Menu?action=pagemodifierEmploye&id=<%=e.getId()%>" class="btn btn-info btn-md">
                                        <span class="glyphicon glyphicon-edit" title="Modifier un employée"></span>Modifier
                                    </a>
                                    <a href="Administrateur?action=supprimerEmploye&id=<%=e.getId()%>" class="btn btn-info btn-md">
                                        <span class="glyphicon glyphicon-edit" title="Supprimer un employe"></span>Supprimer
                                    </a>
                                </td>
                            </tr><%}%>
                        </tbody>
                    </table>
                </form>
            </div>
            </div>
        </body>
</html>

