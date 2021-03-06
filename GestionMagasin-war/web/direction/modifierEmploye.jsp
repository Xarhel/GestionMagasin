<%-- 
    Document   : modifierEmploye
    Created on : 14 mars 2018, 09:27:57
    Author     : 5153218
--%>

<%@page import="Entites.Personne.Employe"%>
<%@page import="Entites.Autre.Rayon"%>
<%@page import="Entites.Autre.Magasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Modifier un employée</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="employe" scope="request" type="Entites.Personne.Employe"></jsp:useBean>
        <jsp:useBean id="magasin" scope="request" type="Entites.Autre.Magasin"></jsp:useBean>
        <jsp:useBean id="rayon" scope="request" type="Entites.Autre.Rayon"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Modifier un employée</h1>
                <% Employe _employe = employe;%>                
                <form method="POST" action="....">
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
            
            <div class="form-group row">
                <label class="col-md-2">Mot de Passe<span class="requis">*</span></label>
                <div class="col-md-4">
                    <input class="form-control" type="text" name="mdp_1"/>
                </div>                        
            </div>

            <div class="form-group row">
                <label class="col-md-2">Date de création du compte<span class="requis">*</span></label>
                <div class="col-md-4">
                    <input class="form-control" type="date" name="dateCreationCompte" value="<%=_employe.getDateCreationCompte()%>" readonly/>
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
                        <% Collection<Magasin> _magasin = magasin;
                            for (Magasin m : _magasin) {%>
                        <option value="<%=m.getId()%>"><%=m.getNom()%></option>
                        <%}%>
                    </select>  
                </div>
                <div class="form-group row">
                    <label class="col-md-2">Nom du rayon<span class="requis">*</span></label>
                    <select name="nom" class="col-md-3 form-control" required>
                        <option></option>
                        <% Collection<Rayon> _rayon = rayon;
                            for (Rayon r : _rayon) {%>
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

