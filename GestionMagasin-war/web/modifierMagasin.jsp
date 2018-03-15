<%-- 
    Document   : modifierMagasin
    Created on : 14 mars 2018, 11:17:11
    Author     : 5153218
--%>

<%@page import="Entites.Autre.Adresse"%>
<%@page import="Entites.Autre.Magasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Modifier un magasin</title>
        <jsp:useBean id="magasin" scope="request" type="Entites.Autre.Magasin"></jsp:useBean>
        <jsp:useBean id="adresse" scope="request" type="Entites.Autre.Adresse"></jsp:useBean>
        <jsp:include page="include/header.jsp"/>
        
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <h1>Modifier un magasin </h1>    
                <% Magasin _magasin = magasin;%>                
                <form method="POST" action="Menu">
                    <input hidden type="text" name="action" value="modifierMagasin"/>
                    <input hidden type="text" name="id" value="<%=_magasin.getId()%>"/>
                    
                    <div class="form-group row">
                        <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" value ="<%_magasin.getNom%>"required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Libelle adresse<span class="requis">*</span></label>
                        <select name="adresse" class="col-md-3 form-control" required>
                            <option></option>
                        <% Collection<Adresse> _adresses = adresses;
                            for (adresse a : _adresses) {%>
                            <option value="<%=a.getId()%>"><%=a.getlibelleAdresse()%></option>
                            <%}%>
                        </select>
                        <label class="col-md-2">Nom du rue<span class="requis">*</span></label>
                        <select name="adresse" class="col-md-3 form-control" required>
                            <option></option>
                        <% Collection<Adresse> _adresses = adresses;
                            for (adresse a : _adresses) {%>
                            <option value="<%=a.getId()%>"><%=a.getrueNom()%></option>
                            <%}%>
                        </select>

                        <label class="col-md-2">Complement du rue<span class="requis">*</span></label>
                        <select name="adresse" class="col-md-3 form-control" required>
                            <option></option>
                        <% Collection<Adresse> _adresses = adresses;
                            for (adresse a : _adresses) {%>
                            <option value="<%=a.getId()%>"><%=a.getrueComplement()%></option>
                            <%}%>
                        </select>
                        <label class="col-md-2">Code postal<span class="requis">*</span></label>
                        <select name="adresse" class="col-md-3 form-control" required>
                            <option></option>
                        <% Collection<Adresse> _adresses = adresses;
                            for (adresse a : _adresses) {%>
                            <option value="<%=a.getId()%>"><%=a.getcodePostal()%></option>>
                            <%}%>
                        </select>    
                        <label class="col-md-2">Ville<span class="requis">*</span></label>
                        <select name="adresse" class="col-md-3 form-control" required>
                            <option></option>
                        <% Collection<Adresse> _adresses = adresses;
                            for (adresse a : _adresses) {%>
                            <option value="<%=a.getId()%>"><%=a.getville()%></option>
                            <%}%>
                        </select>
                        </div>                        
                
                    <button type="submit" class="btn btn-success">Enregistre</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
