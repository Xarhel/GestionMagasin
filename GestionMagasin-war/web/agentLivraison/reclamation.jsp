<%-- 
    Document   : reclamation
    Created on : 23 mars 2018, 09:06:05
    Author     : 5153218
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Faire une reclamation</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <div class="jumbotron">
            <!-- BODY START -->
            <div>
                <h1>Nouvelle réclamation</h1>
                <jsp:useBean id="livraison" scope="request" type="Entites.Autre.Livraison"></jsp:useBean>
                    <form method="POST" action="AgentLivraison">
                        <input hidden type="text" name="action" value="creerReclamation"/>  
                        <input hidden type="text" name="livraison" value="<%=livraison.getId()%>"/>
                        <div class="form-group row">
                            <label class="col-md-2">Description de la réclamation<span class="requis">*</span></label>
                            <div class="col-md-4">
                                <input class="form-control" type="text" name="motifReclamation" required/>
                            </div>                        
                        </div>
                    <button type="submit" class="btn btn-success">Envoyer</button>                    
                </form> 
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>