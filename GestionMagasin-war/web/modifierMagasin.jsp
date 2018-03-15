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
        <jsp:include page="include/header.jsp"/>
        
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <h1>Modifier un </h1>    
                <% Magasin _magasin = magasin;%>                
                <form method="POST" action="Menu">
                    <input hidden type="text" name="action" value="modifierMagasin"/>
                    <input hidden type="text" name="id" value="<%=_magasin.getId()%>"/>
                    <div class="form-group row">
                        <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value="<%=_magasin.getAdresse()%>" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value ="<%_magasin.getNom%>"required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        
                        </div>                        
                
                    <button type="submit" class="btn btn-success">Enregistre</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
