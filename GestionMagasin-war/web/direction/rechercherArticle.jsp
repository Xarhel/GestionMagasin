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
        <script src="js/script.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menuDirection.jsp"/>
            <!-- BODY START -->
            <div>    
                <form method="POST" action="Administrateur">
                    <div class="recherche">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" name="nom" placeholder="Nom de l'article" class="form-control left-rounded">
                                    <input type="hidden" name="action" value="rechercherArticleParNom">
                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-success right-rounded">Rechercher</button>
                                    </div> 
                                </div><br/>

                                <div class="image">
                                    <img src="images/Magasin_Aarhus.jpg"  alt="Magasin" class="img-responsive">
                                </div>     
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>