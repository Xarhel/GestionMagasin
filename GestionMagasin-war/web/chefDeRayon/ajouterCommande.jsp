<%-- 
    Document   : ajouterFournisseur
    Created on : 20 mars 2018, 11:17:19
    Author     : jules
--%>

<%@page import="Entites.Autre.BonDeCommande"%>
<%@page import="Entites.Personne.Fournisseur"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer Bon de Commande</title>
        <jsp:include page="header.jsp"/>
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="ListeFournisseur" scope="request" type="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="bonDeCommande" scope="request" type="BonDeCommande"></jsp:useBean>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Créer Bon de Commande</h1>
                <form method="POST" action="ChefDeRayon">
                    <input hidden type="text" name="action" value="creerCommande"/>
                    
                 
                <div id="fournisseur" class="form-group row">
                            <label class="col-md-2">Fournisseur<span class="requis">*</span></label>
                            <select name="four" class="col-md-3 form-control" required>
                                <% Collection<Fournisseur> _fournisseur = ListeFournisseur;                                
                                for(Fournisseur f : _fournisseur )
                                {%>
                                <option value="<%=f.getId()%>"><%=f.getRaisonSociale()%></option>
                                <%}%>
                            </select>
                        </div>
                            <button type="submit" class="btn btn-success">Créer</button>
                </form>
                            
                                <a href="ChefDeRayon?action=versCreerCommandeLot&bon=<%=bonDeCommande.getId()%>" class="btn btn-success btn-md">
                                    <span class="glyphicon glyphicon-pencil" title="AjouterLots"></span> Ajouter des lots
                                </a>
                    
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>