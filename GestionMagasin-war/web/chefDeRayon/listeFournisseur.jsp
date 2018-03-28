<%-- 
    Document   : listeArticle
    Created on : 20 mars 2018, 15:45:59
    Author     : jules
--%>

<%@page import="Entites.Personne.Fournisseur"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des fournisseurs</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="fournisseur" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">  
            <jsp:include page="menu.jsp"/>
            <div class="jumbotron"
            <!-- BODY START -->
            <div>
                <h1>Liste des fournisseurs</h1>
                <a style="float: right; " class="btn btn-success" href="ChefDeRayon?action=versAjouterFournisseur">Ajouter Fournisseur</a>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    
                    <thead>
                        <tr>
                            <th>Référence fournisseur</th>
                            <th>Raison Sociale</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Référence fournisseur</th>
                            <th>Raison Sociale</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Fournisseur> _fournisseur = fournisseur;
                            for (Fournisseur a : _fournisseur) {%>
                        <tr><td><%=a.getId()%></td>
                            <td><%=a.getRaisonSociale()%></td>
                           

                        </tr><%}%>
                    </tbody>
                </table>
                     
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
