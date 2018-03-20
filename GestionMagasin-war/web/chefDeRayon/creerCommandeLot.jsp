<%-- 
    Document   : creerCommandeLot
    Created on : 20 mars 2018, 14:06:07
    Author     : jules
--%>

<%@page import="java.util.Collection"%>
<%@page import="Entites.Autre.Article"%>
<%@page import="Entites.Autre.FournisseurMagasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer une commande</title>
        <jsp:include page="include/header.jsp"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menuChefRayon.jsp"/>
            <jsp:useBean id="article" scope="request" class="java.util.Collection"></jsp:useBean>
            <jsp:useBean id="fournisseur" scope="request" class="java.util.Collection"></jsp:useBean>
                <!-- BODY START -->
                <div>
                    <h1>Créer une commande</h1>
                    <form method="POST" action="....">
                        <input hidden type="text" name="action" value="creerCommande"/>
                        <div class="form-group row">
                            <label class="col-md-2">Libelle article<span class="requis">*</span></label>
                            <select name="libelle" class="col-md-3 form-control" required>
                            <% Collection<Article> _article = article;
                            for (Article a : _article) {%>
                            <option value="<%=a.getId()%>"><%=a.getLibelle()%></option>
                            <option value="<%=a.getId()%>"><%=a.getLots()%></option>
                            
                            <%}%>
                        </select>  
                    </div>
                        <div class="form-group row">
                            <label class="col-md-2">Fournisseur<span class="requis">*</span></label>
                            <select name="libelle" class="col-md-3 form-control" required>
                            <% Collection<FournisseurMagasin> _fournisseur = fournisseur;
                            for (FournisseurMagasin f : _fournisseur) {%>
                            <option value="<%=f.getId()%>"><%=f.getLeFournisseur()%></option>
                            
                            <%}%>
                        </select>  
                    </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-md-2">Quantité<span class="requis">*</span></label>
                            <div class="col-md-4">
                                <input class="form-control" type="text" name="quatite" required/>
                            </div>                        
                        </div>
                         </div>
                        <div class="form-group row">
                            <label class="col-md-2">Prix d'achat<span class="requis">*</span></label>
                            <div class="col-md-4">
                                <input class="form-control" type="text" name="login" required/>
                            </div>                        
                        </div>
                    <button type="submit" class="btn btn-success">Enregistre</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>