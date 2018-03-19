<%-- 
    Document   : modifierMagasin
    Created on : 14 mars 2018, 11:17:11
    Author     : 5153218
--%>

<%@page import="Entites.Autre.Adresse"%>
<%@page import="Entites.Autre.Magasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Modifier un magasin</title>
        <jsp:useBean id="magasin" scope="request" type="Entites.Autre.Magasin"></jsp:useBean>
        <jsp:include page="/include/header.jsp"/>
        
    </head>
    <body>
        <div class="container">
            <jsp:include page="/include/menu.jsp"/>
            <!-- BODY START -->
            <h1>Modifier un magasin </h1>                    
                <form method="post" action="Administrateur">
                    <input hidden type="text" name="action" value="modifierMagasin"/>
                    <input hidden type="text" name="id" value="<%=magasin.getId()%>"/>
                    <div class="form-group row">
                        <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value="<%=magasin.getNom()%>"required/>
                        </div>                        
                    </div>
                        <%--
                    <div class="form-group row">
                        <label class="col-md-2">Libellé de l'adresse<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value="<%=magasin.getAdresse().getLibelleAdresse()%>"readonly/>
                            </div>                        
                        </div>
                    <div class="form-group row">
                        <label class="col-md-2">Rue<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value="<%=magasin.getAdresse().getRueNom()%>"readonly/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Complément<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value="<%=magasin.getAdresse().getRueComplement()%>"readonly/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Code postal<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value="<%=magasin.getAdresse().getCodePostal()%>"readonly/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Ville<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value="<%=magasin.getAdresse().getVille()%>"readonly/>
                        </div>                        
                    </div>
                        --%>
                    <button type="submit" class="btn btn-success">Enregistrer</button>                    
                </form> 
            </div>
            <!-- BODY END-->
    </body>
</html>
