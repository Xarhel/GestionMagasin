<%-- 
    Document   : listeCommande
    Created on : 22 mars 2018, 09:06:01
    Author     : jules
--%>

<%@page import="Entites.Autre.Article"%>
<%@page import="Entites.Autre.BonDeCommande"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des comandes par magasin</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="bonDecommande" scope="request" class="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="magasin" scope="request" class="Entites.Autre.Magasin"></jsp:useBean>
        <jsp:useBean id="article" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <div class="jumbotron">
                <h1>Liste des commandes</h1>
                <form method="POST" action=".....">
                    <input hidden type="text" name="id" value="<%=magasin.getId()%>" />
                    <table id="example" class="table table-striped table-bordered" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Libelle article</th>
                                <th>Date de commande</th>
                                <th>Chef de rayon</th>
                                <th>Fournisseur</th>

                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Libelle article</th>
                                <th>Date de commande</th>
                                <th>Chef de rayon</th>
                                <th>Fournisseur</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <% Collection<Article> _article = article;
                            for (Article a : _article) {%>
                            <tr>
                                <td><%=a.getLibelle()%></td>
                            </tr><%}%>

                            <% Collection<BonDeCommande> _bonDeCommande = bonDecommande;
                            for (BonDeCommande bc : _bonDeCommande) {%>
                            <tr>
                                <td><%=bc.getDateCommande()%></td>
                                <td><%=bc.getLeChefDeRayon().getId()%></td>
                                <td><%=bc.getLeFournisseur().getRaisonSociale()%></td>

                            </tr><%}%>
                        </tbody>
                    </table>
                </form>
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>