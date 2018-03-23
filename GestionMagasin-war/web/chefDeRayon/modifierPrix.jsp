<%-- 
    Document   : modifierPrix
    Created on : 20 mars 2018, 15:57:27
    Author     : jules
--%>

<%@page import="Entites.Autre.Article"%>
<%@page import="Entites.Autre.RayonArticle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Modifier prix</title>
        <jsp:useBean id="article" scope="request" type="Entites.Autre.Article"></jsp:useBean>
        <jsp:useBean id="rayonArticle" scope="request" type="Entites.Autre.RayonArticle"></jsp:useBean>
        <jsp:include page="header.jsp"/>

    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <h1>Modifier un prix </h1>              
            <form method="POST" action="ChefDeRayon">
                <input hidden type="text" name="action" value="modifierPrix"/>
                <input hidden type="text" name="idRayonArticle" value="<%=rayonArticle.getId()%>"/>
                <div class="form-group row">
                    <label class="col-md-2">Libelle ariticle<span class="requis">*</span></label>
                    <div class="col-md-4">
                        <input class="form-control" type="text" name="libelle" value="<%=article.getLibelle()%>" disabled />
                    </div>                        
                </div>
                <div class="form-group row">
                    <label class="col-md-2">Reference article<span class="requis">*</span></label>
                    <div class="col-md-4">
                        <input class="form-control" type="text" name="nom" value="<%=article.getReferenceArticle()%>" disabled/>
                    </div>                        
                </div>
                <div class="form-group row">
                    <label class="col-md-2">Rayon<span class="requis">*</span></label>
                    <div class="col-md-4">
                        <input class="form-control" type="text" name="nom" value="<%=rayonArticle.getLesRayons().getRayonNom() %>" disabled/>
                    </div>                        
                </div>
                    
                <div class="form-group row">
                    <label class="col-md-2">Prix article<span class="requis">*</span></label>
                    <div class="col-md-4">
                        <input class="form-control" type="text" name="prix" value="<%=rayonArticle.getPrixRayon()%>" required/>
                    </div>                        
                </div>

                <button type= "submit" class="btn btn-success">Valider</button>                     
            </form> 
        </div>
        <!-- BODY END-->
    </div>
</body>
</html>

