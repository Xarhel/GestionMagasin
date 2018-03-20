<%-- 
    Document   : listeArticle
    Created on : 19 mars 2018, 10:09:39
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
        <jsp:include page="menuDirection.jsp"/>
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="article" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <!-- BODY START -->
            <div>
                <h1>Liste des articles</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Libelle</th>
                            
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
                           
                            <td><a href="Administrateur?action=versAjouterPromotion&id=<%=a.getId()%>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-edit" title="Faire une promotion"></span>Ajouter une promotion
                                </a>
                                <a href="Administrateur?action=ModifierPrixArticle&id=<%=a.getId()%>" class="btn btn-success btn-md">
                                    <span class="glyphicon glyphicon-pencil" title="Modifier prix article"></span>Modifier une promotion
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
