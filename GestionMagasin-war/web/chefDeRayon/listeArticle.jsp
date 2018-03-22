<%-- 
    Document   : listeArticle
    Created on : 20 mars 2018, 15:45:59
    Author     : jules
--%>

<%@page import="Entites.Autre.Article"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des articles</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="article" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des articles</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Libelle</th>
                            <th>Reference article</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Libelle</th>
                            
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Article> _article = article;
                            for (Article a : _article) {%>
                        <tr><td><%=a.getLibelle()%></td>
                            <td><%=a.getReferenceArticle()%></td>
                           
                            <td>                               
                                <a href="ChefDeRayon?action=versAjouterAuRayon&idArticle=<%=a.getId()%>" class="btn btn-success btn-md">
                                    <span class="glyphicon glyphicon-pencil" title="ajouterAuRayon"></span> Ajouter au rayon
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
