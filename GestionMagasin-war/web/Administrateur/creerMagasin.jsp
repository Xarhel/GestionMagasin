<%-- 
    Document   : creerMagasin
    Created on : 14 mars 2018, 10:46:36
    Author     : 5153218
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un magasin</title>
        <jsp:include page="header.jsp"/>
        </head>
        <body>
            <div class="container">
                
            <jsp:include page="menu.jsp"/>
            <div class="jumbotron">
            <!-- BODY START -->
            <div>
                <h1>Créer un magasin</h1>
                <form method="post" action="Administrateur">
                    <input hidden type="text" name="action" value="creerMagasin"/>
                    <div class="form-group row">
                        <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Libellé de l'adresse<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="libelle" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Nom de la rue<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="rueNom" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Complément<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="rueComplement" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Code postal<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="codePostal" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Ville<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="ville" required/>
                        </div>                        
                    </div>
                    <button type="submit" class="btn btn-success">Enregistrer</button>                    
                </form> 
            </div>
                </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
