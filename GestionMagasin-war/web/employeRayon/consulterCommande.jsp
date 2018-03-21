<%-- 
    Document   : consulterCommande
    Created on : 19 mars 2018, 14:13:10
    Author     : jules
--%>


<%@page import="Entites.Autre.BonDeCommande"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des bons de commandes</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="commande" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menuEmployeRayon.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des commandes</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Chef de Rayon</th>
                            <th>Fournisseur</th>
                            <th>Date de commande</th>
                           
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>id</th>
                            <th>Chef de Rayon</th>
                            <th>Fournisseur</th>
                            <th>Date de commande</th>
                            
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<BonDeCommande> _commande = commande;
                            for (BonDeCommande c : _commande) {%>
                        <tr><td><%=c.getId()%></td>
                            <td><%=c.getLeChefDeRayon().getNomPersonne() %></td>
                            <td><%=c.getLeFournisseur()%></td>
                            <td><%=c.getDateCommande()%></td>
                        </tr><%}%>
                    </tbody>
                </table>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
