<%-- 
    Document   : ajouterFournisseur
    Created on : 20 mars 2018, 11:17:19
    Author     : jules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un fournisseur</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Créer fournisseur</h1>
                <form method="POST" action="ChefDeRayon">
                    <input hidden type="text" name="action" value="ajouterFournisseur"/>
                    <div class="form-group row">
                        <label class="col-md-2">Raison Sociale<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="raisonSociale" required/>
                        </div>                        
                    </div>                    
                    <div class="form-group row">
                        <label class="col-md-2">Nom du Responsable<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Prénom du Responsable<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="prenom" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Login<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="login" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Mot de Passe<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="mdp" required/>
                        </div>                        
                    </div>                    
                    <button type="submit" class="btn btn-success">Ajouter</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>