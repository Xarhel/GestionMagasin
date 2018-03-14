<%-- 
    Document   : creerEmploye
    Created on : 14 mars 2018, 09:09:01
    Author     : 5153218
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un employe</title>
        <jsp:include page="include/header.jsp"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Créer employe</h1>
                <form method="POST" action="Menu">
                    <input hidden type="text" name="action" value="creerEmploye"/>
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
                        <div class="form-group row">
                        <label class="col-md-2">Date de création du compte<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="date" name="dateCreationCompte"/>
                        </div>                        
                    </div> 
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Type de Compte<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="typeCompte" required/>
                        </div>                        
                    </div>
                                       
                    <button type="submit" class="btn btn-success">Enregistre</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
