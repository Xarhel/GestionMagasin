<%-- 
    Document   : modifierEmploye
    Created on : 14 mars 2018, 09:27:57
    Author     : 5153218
--%>

<%@page import="Entites.Personne.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Modifier un employée</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="employe" scope="request" type="Entites.Personne.Employe"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Modifier un employée</h1>    
                <% Employe _employe = employe;%>                
                <form method="POST" action="Menu">
                    <input hidden type="text" name="action" value="modifierEmploye"/>
                    <input hidden type="text" name="id" value="<%=_employe.getId()%>"/>
                    <div class="form-group row">
                        <label class="col-md-2">Nom<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value="<%=_employe.getNomPersonne()%>" readonly/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Prénom<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="prenom" value="<%=_employe.getPrenomPersonne()%>" readonly/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Login<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="login" value="<%=_employe.getLogin()%>" readonly/>
                        </div>                        
                    </div>
                        </div>
                        <div class="form-group row">
                        <label class="col-md-2">Mot de Passe<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="mdp_1"/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Type de Compte<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="typeCompte" value="<%=_employe.getTypeCompte()%>"required/>
                        </div>                        
                    </div>
                        <div class="form-group row">
                            <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                            <select name="nom" class="col-md-3 form-control" required>
                                <option></option>
                            <% Collection<Magasin> _magasins = magasins;
                            for (magasin m : _magasins) {%>
                            <option value="<%=m.getId()%>"><%=m.getNom()%></option>
                            <%}%>
                        </select>  
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Nom du rayon<span class="requis">*</span></label>
                        <select name="nom" class="col-md-3 form-control" required>
                                <option></option>
                            <% Collection<Rayon> _rayons = rayon;
                            for (magasin m : _rayons) {%>
                            <option value="<%=m.getId()%>"><%=m.getRayonNom()%></option>
                            <%}%>
                        </select>  
                    </div>
                                         
                    <button type="submit" class="col-md-3 btn btn-lg btn-success">Modifier</button>                    
                </form>
            </div>
        </div>
        <!-- BODY END-->
    </body>
</html>

