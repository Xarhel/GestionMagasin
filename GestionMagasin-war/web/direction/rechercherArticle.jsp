<%-- 
    Document   : rechercherArticle
    Created on : 20 mars 2018, 11:04:24
    Author     : jules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rechercher un article</title>
        <jsp:include page="header.jsp"/>
        <jsp:include page="menuDirection.jsp"/>
        <script src="js/script.js" type="text/javascript"></script>
        </head>
        <body>
            <div class="container">
            <!-- BODY START -->
            <div>    
                <form method="POST" action="Administrateur">
                    <div class="recherche">
                        <div class="col-md-4">
                            <input type="text" name="nom" placeholder="Nom de l'article"/>
                            <input type="hidden" name="action" value="rechercherArticleParNom"/>
                            <button type="submit">Rechercher</button>
                        </div>
                    </div>
                </form>
            </div>
            </div>
        </body>
</html>