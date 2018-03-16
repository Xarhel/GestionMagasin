<%-- 
    Document   : creerGerantMagasin
    Created on : 15 mars 2018, 16:42:10
    Author     : jules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entites.Autre.Magasin"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un gérant</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="magasin" scope="request" class="java.util.Collection"></jsp:useBean>
 
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/menu.jsp"/>
            
            <!-- BODY START -->
            <div>
                <h1>Créer abonne</h1>
                <form method="POST" action="....">
                    <input hidden type="text" name="action" value="creerGerant"/>
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
                        <label class="col-md-2">Date de création<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="date" name="dateCreationCompte"/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Type de compte<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="typeCompte" required/>
                        </div>
                        <div class="form-group row">
                            <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                            <select name="nom" class="col-md-3 form-control" required>
                                <option></option>
                                <% Collection<Magasin> _magasin = magasin;
                            for (Magasin m : _magasin) {%>
                                <option value="<%=m.getId()%>"><%=m.getNom()%></option>
                                <%}%>
                            </select>  
                        </div>                        
                    </div>
                    <button type="submit" class="btn btn-success">Enregistre</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>