<%-- 
    Document   : consulterLivraison
    Created on : 19 mars 2018, 14:53:16
    Author     : jules
--%>

<%@page import="Entites.Autre.Livraison"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des livraison</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="livraison" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menuEmployeRayon.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des Livraison</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Livraison lots</th>
                            <th>Date de créeation</th>
                            <th>Agent de livraison</th>
                            <th>Date de reception</th>
                            <th>Statut de livraison</th>
                           
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Livraison lots</th>
                            <th>Date de créeation</th>
                            <th>Agent de livraison</th>
                            <th>Date de reception</th>
                            <th>Statut de livraison</th>
                           
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Livraison> _livraison = livraison;
                            for (Livraison l : _livraison) {%>
                        <tr><td><%=l.getLivraisonLots()%></td>
                            <td><%=l.getDateCreationLivraison()%></td>
                            <td><%=l.getlAgentDeLivraison()%></td>
                            <td><%=l.getDateReceptionLivraison()%></td>
                            <td><%=l.getStatutLivraison()%></td>
                        </tr><%}%>
                    </tbody>
                </table>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
