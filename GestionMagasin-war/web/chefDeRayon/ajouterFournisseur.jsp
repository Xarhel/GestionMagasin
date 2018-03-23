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
        <jsp:include page="include/header.jsp"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/menuChefRayon.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Créer fournisseur</h1>
                 <div class="jumbotron">
                <form method="POST" action="">
                    <input hidden type="text" name="action" value="creerFournisseur"/>
                    <div class="form-group row">
                        <label class="col-md-2">Nom<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Prénom<span class="requis">*</span></label>
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
                    <div class="form-group row">
                        <label class="col-md-2">Type de compte<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="type" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Date de création<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="date" name="date"/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Numero de matricule<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="numero" required/>
                        </div>                        
                    </div>                    
                    <button type="submit" class="btn btn-success">Enregistre</button>                    
                </form> 
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>