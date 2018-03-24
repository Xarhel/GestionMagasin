<%-- 
    Document   : listeArticle
    Created on : 20 mars 2018, 15:45:59
    Author     : jules
--%>

<%@page import="Entites.Autre.BonDeCommande"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des Commandes</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="commande" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des Commandes</h1>
                <a style="float: right; " class="btn btn-success" href="ChefDeRayon?action=versCommande">Passer une Commande</a>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    
                    <thead>
                        <tr>
                            <th>Référence Bon de Commande</th>
                            <th>Fournisseur</th>
                            <th>Date de Commande</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Référence Bon de Commande</th>
                            <th>Fournisseur</th>
                            <th>Date de Commande</th>
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<BonDeCommande> _commande = commande;
                            for (BonDeCommande a : _commande) {%>
                        <tr><td><%=a.getId()%></td>
                            <td><%=a.getLeFournisseur().getRaisonSociale()%></td>
                            <td><%=a.getDateCommande()%></td>                          

                        </tr><%}%>
                    </tbody>
                </table>
                     
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
