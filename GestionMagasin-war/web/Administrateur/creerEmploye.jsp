<%-- 
    Document   : creerEmploye
    Created on : 14 mars 2018, 09:09:01
    Author     : 5153218
--%>
<%@page import="java.util.Collection"%>
<%@page import="Entites.Enum.TypeCompte"%>
<%@page import="Entites.Autre.Magasin"%>
<%@page import="Entites.Autre.Rayon"%>
<%@page import="Entites.Personne.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un employe</title>
        <jsp:include page="header.jsp"/>
        <jsp:include page="menu.jsp"/>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
            <jsp:useBean id="magasin" scope="request" class="java.util.Collection"></jsp:useBean>
            <jsp:useBean id="typeCompte" scope="request" class="java.util.Collection"></jsp:useBean>
            
          <%--  <jsp:useBean id="rayon" scope="request" class="java.util.Collection"></jsp:useBean> --%>
                <!-- BODY START -->
                <div>
                    <h1>Créer employe</h1>
                    <form method="POST" action="Administrateur">
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
                        </div>
                            <div class="form-group row">
                                <label class="col-md-2">Date de création du compte<span class="requis">*</span></label>
                                <div class="col-md-4">
                                    <input class="form-control" type="date" name="dateCreationCompte"/>
                                </div>                        
                            </div>
                        <div id="typeCompte" class="form-group row">
                            <label class="col-md-2">Type de compte<span class="requis">*</span></label>
                            <select name="typeCompte" class="col-md-3 form-control" required>
                                <% Collection<TypeCompte> tc = typeCompte;
                                for(TypeCompte t : tc )
                                {%>
                                <option value="<%=t%>"><%=t.name()%></option>
                                <%}%>
                            </select>
                        </div>
                        <%--
                        <div id="magasin" class="form-group row">
                            <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                            <select name="nom" class="col-md-3 form-control" required>
                                <option></option>
                            <% Collection<Magasin> _magasins = magasin;
                            for (Magasin m : _magasins) {%>
                            <option value="<%=m.getId()%>"><%=m.getNom()%></option>
                            <%}%>
                        </select>  
                    </div>
                        
                    <div id="rayon" class="form-group row">
                        <label class="col-md-2">Nom du rayon<span class="requis">*</span></label>
                        <select name="nom" class="col-md-3 form-control" required>
                                <option></option>
                            <% Collection<Rayon> _rayons = rayon;
                            for (Rayon r : _rayons) {%>
                            <option value="<%=r.getId()%>"><%=r.getRayonNom()%></option>
                            <%}%>
                        </select>  
                    </div> 
                    --%>
                    <button type="submit" class="btn btn-success">Enregistrer</button>                    
                </form> 
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>

