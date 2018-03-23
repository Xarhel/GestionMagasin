<%-- 
    Document   : creerLivraison
    Created on : 19 mars 2018, 14:33:59
    Author     : jules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un livraison</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Créer un livraison</h1>
                <form method="POST" action="">
                    <input hidden type="text" name="action" value="creerLivraison"/>
                   <div class="form-group row">
                        <label class="col-md-2">Date de livraison<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="date" name="dateCreationLivraison"/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Date de reception<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="date" name="dateReceptionLivraison"/>
                        </div>                        
                    </div>  
                    <div class="form-group row">
                        <label class="col-md-2">Statut de livraison<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="Statut" required/>
                        </div>                        
                    </div>
                                      
                    <button type="submit" class="btn btn-success">Enregistrer</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>