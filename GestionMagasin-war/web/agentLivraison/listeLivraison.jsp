<%-- 
    Document   : listeLivraison
    Created on : 21 mars 2018, 09:33:17
    Author     : 5153218
--%>

<%@page import="Entites.Autre.Livraison"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des livraisons</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="livraison" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des livraisons</h1>
                <form method="POST" action=".....">
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Agent de livraison</th>
                            <th>Date de création livraison</th>
                            <th>Date de livraison</th>
                            <th>Actions</th>
                            
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Agent de livraison</th>
                            <th>Date de création livraison</th>
                            <th>Date de livraison</th>
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Livraison> _livraison = livraison;
                            for (Livraison l : _livraison) {%>
                        <tr>
                            <td><%=l.getlAgentDeLivraison()%></td>
                            <td><%=l.getDateCreationLivraison()%></td>
                            <td><%=l.getDateReceptionLivraison()%></td>  
                        </tr><%}%>
                    </tbody>
                </table>
                </form>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
