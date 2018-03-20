<%-- 
    Document   : ListeLivraison
    Created on : 20 mars 2018, 14:47:41
    Author     : jules
--%>

<%@page import="Entites.Autre.Livraison"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des livraisons</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="livraison" scope="request" class="java.util.Collection"></jsp:useBean>
       
        </head>
        <body>
            <div class="container">
            <jsp:include page="menuAgentLivraison.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des livraison</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Libelle article</th>
                            <th>quantiteLivree</th>
                            <th>quantiteAcceptee</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                           <th>Libelle article</th>
                            <th>quantiteLivree</th>
                            <th>quantiteAcceptee</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Livraison> _livraison = livraison;
                            for (Livraison l : _livraison) {%>
                        <tr><td><%=l.getLeBonDeCommande()%></td>
                            <td><%=l.getlAgentDeLivraison()%></td>
                           

                           
                        </tr><%}%>
                    </tbody>
                </table>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>