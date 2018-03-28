<%-- 
    Document   : modifierPrixPromotion
    Created on : 20 mars 2018, 12:57:10
    Author     : jules
--%>

<%@page import="Entites.Autre.Article"%>
<%@page import="Entites.Autre.Rayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Modifier prix</title>
        <jsp:useBean id="article" scope="request" type="Entites.Autre.Article"></jsp:useBean>
        <jsp:useBean id="rayon" scope="request" type="Entites.Autre.Rayon"></jsp:useBean>
        <jsp:include page="header.jsp"/>
        <jsp:include page="menu.jsp"/>

    </head>
    <body>
        <div class="container">

             <div class="jumbotron">
            <!-- BODY START -->
            <h1>Ajouter l'article au rayon</h1>              
            <form method="POST" action="ChefDeRayon">
                <input hidden type="text" name="action" value="ajouterAuRayon"/>
                <input hidden type="text" name="idArticle" value="<%=article.getId()%>"/>
                <div class="form-group row">
                    <label class="col-md-2">Libellé de l'article<span class="requis">*</span></label>
                    <div class="col-md-4">
                        <input class="form-control" type="text" name="libelle" value="<%=article.getLibelle()%>" disabled />
                    </div>                        
                </div>
                <div class="form-group row">
                    <label class="col-md-2">Référence article<span class="requis">*</span></label>
                    <div class="col-md-4">
                        <input class="form-control" type="text" name="nom" value="<%=article.getReferenceArticle()%>" disabled/>
                    </div>                        
                </div>
                <div class="form-group row">
                    <label class="col-md-2">Rayon<span class="requis">*</span></label>
                    <div class="col-md-4">
                        <input class="form-control" type="text" name="nom" value="<%=rayon.getRayonNom()%>" disabled/>
                    </div>                        
                </div>
                    
                <div class="form-group row">
                    <label class="col-md-2">Prix de l'article<span class="requis">*</span></label>
                    <div class="col-md-4">
                        <input class="form-control" type="text" name="prix" required/>
                    </div>                        
                </div>

                <button type= "submit" class="btn btn-success">Enregistrer</button>                     
            </form> 
        </div>
        </div>
        <!-- BODY END-->
    </div>
</body>
</html>

