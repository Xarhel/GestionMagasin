<%-- 
    Document   : rechercherArticle
    Created on : 20 mars 2018, 11:04:24
    Author     : jules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="Entites.Autre.Article"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chercher article</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="article" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>    
                <form method="POST" action=" ">
                    <div class="recherche">
                        <div class="col-md-4">
                            <input type="text" name="keyword" placeholder="Rechercher un article.."value="Recherche"/>
                            <button>Rechercher</button>
                        </div>
                    </div>

                    <h1>Liste des articles</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Libelle article</th>
                            
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Libelle article</th>
                            
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Article> _article = article;
                            for (Article a : _article) {%>
                        <tr><td><%=a.getLibelle()%></td>
                           
                            <td><a href="Menu?action=pageAjouterPromotion&id=<%=a.getId()%>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-edit" title="Faire une promotion"></span>Edit promotion
                                </a>
                                <a href="Menu?action=pageModifierPrixArticle&id=<%=a.getId()%>" class="btn btn-success btn-md">
                                    <span class="glyphicon glyphicon-pencil" title="Modifier prix article"></span> Modifier prix
                                </a>
                                
                            </td>
                        </tr><%}%>
                        </tbody>
                    </table>
                </form>
            </div>
            </div>
        </body>
</html>