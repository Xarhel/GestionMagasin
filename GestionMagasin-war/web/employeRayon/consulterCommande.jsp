<%-- 
    Document   : consulterCommande
    Created on : 19 mars 2018, 14:13:10
    Author     : jules
--%>


<%@page import="Entites.Autre.CommandeLot"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des de commandes</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="commande" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menuDirection.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des commandes</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Libelle article</th>
                            <th>Date de commande</th>
                            <th>Prix</th>
                            <th>Quantité</th>
                           
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Libelle article</th>
                            <th>Prix</th>
                            <th>Quantité</th>
                            
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<CommandeLot> _commande = commande;
                            for (CommandeLot c : _commande) {%>
                        <tr><td><%=c.getLeBonDeCommande()%></td>
                            <td><%=c.getLeLot()%></td>
                            <td><%=c.getPrixAchat()%></td>
                        </tr><%}%>
                    </tbody>
                </table>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
