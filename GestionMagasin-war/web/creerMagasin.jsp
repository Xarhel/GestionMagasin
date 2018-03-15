<%-- 
    Document   : creerMagasin
    Created on : 14 mars 2018, 10:46:36
    Author     : 5153218
--%>
<%@page import="Entites.Autre.Adresse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un magasin</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="Adresse" scope="request" type="Entites.Autre.Adresse"></jsp:useBean>

        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Créer un magasin</h1>
                <form method="POST" action="Menu">
                    <input hidden type="text" name="action" value="creerEmploye"/>
                    <div class="form-group row">
                        <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" required/>
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