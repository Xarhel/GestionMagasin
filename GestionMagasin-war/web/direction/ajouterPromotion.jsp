<%-- 
    Document   : ajouterPromotion
    Created on : 15 mars 2018, 13:51:55
    Author     : jules
--%>

<%@page import="Entites.Autre.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Promotion</title>
        
        <jsp:include page="header.jsp"/>
        <jsp:include page="menuDirection.jsp"/>
        <jsp:useBean id="article" scope="request" type="Entites.Autre.Article"></jsp:useBean>

        </head>
        <body>
            <div class="container">
            <!-- BODY START -->
            <div>
                <h1>Ajouter une promotion</h1>
                <form method="POST" action="Administrateur">
                    <input hidden type="text" name="action" value="ajouterPromotion"/> 
                    <div class="form-group row">
                        <label class="col-md-2">Nom de l'article</label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" placeholder="<%=article.getLibelle()%>" disabled=""/>
                        </div>                        
                    </div>        
                    <div class="form-group row">
                        <label class="col-md-2">Prix promotion<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="prixPromotion" required=""/>
                        </div>                        
                    </div>
                    <button type="submit" class="btn btn-success">Valider</button>                  
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>

