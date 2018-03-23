<%-- 
    Document   : rechercherLivraison
    Created on : 23 mars 2018, 16:04:39
    Author     : 5153218
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rechercher Livraison</title>
        <jsp:include page="header.jsp"/>
        <script src="js/script.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>    
                <form method="POST" action="GerantMagasin">
                    <div class="recherche">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" name="nom" placeholder="Nom de l'aricle" class="form-control left-rounded">
                                    <input type="hidden" name="action" value="rechercherLivraisonParArticle">
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
