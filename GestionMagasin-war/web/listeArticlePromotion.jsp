<%-- 
    Document   : listeArticlePromotion
    Created on : 15 mars 2018, 14:42:18
    Author     : jules
--%>

<%@page import="entites.Autre.Article"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>promotion</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="aticle" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des articles en promotion</h1>
                <form method="POST" action=".....">
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Article</th>
                            <th>Promotion</th>
                            <th>Prix</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Article</th>
                            <th>Promotion</th>
                            <th>Prix</th>
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Article> _article = article;
                            for (Article a : _article) {%>
                        <tr><td><%=a.getLibelle()%></td>
                            <td><%=a.getPromotion()%></td>
                            <td><%=a.getPrixPromotion()%></td>
                            <td>
                                <a href="annulerPromotion.jsp =<%=a.getId()%>" class="btn btn-danger btn-md">
                                    <span class="glyphicon glyphicon-remove" tabindex="Annulesla promotion"></span>Annuler
                                </a>
                            </td>
                        </tr><%}%>
                    </tbody>
                </table>
                </form>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
