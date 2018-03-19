<%-- 
    Document   : creerArticle
    Created on : 15 mars 2018, 15:27:00
    Author     : jules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un article</title>
        <jsp:include page="include/header.jsp"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Créer abonne</h1>
                <form method="POST" action=".....">
                    <input hidden type="text" name="action" value="creerArticle"/>
                    <div class="form-group row">
                        <label class="col-md-2">Reference de l'article<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="referenceArticle" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Libelle<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="libelle" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Code barre<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="codeBarre" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Prix promotion<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="prixPromotion" required/>
                        </div>                        
                    </div>

                    <button type="submit" class="btn btn-success">Ajouter</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
