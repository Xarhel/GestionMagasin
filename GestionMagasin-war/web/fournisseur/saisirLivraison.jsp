<%-- 
    Document   : creerLivraison
    Created on : 20 mars 2018, 09:33:13
    Author     : jules
--%>

<%@page import="Entites.Autre.Livraison"%>
<%@page import="Entites.Autre.BonDeCommande"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un livraison</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="livraison" scope="request" class="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="bonDeCommande" scope="request" class="java.util.Collection"></jsp:useBean>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/menuFournisseur.jsp"/>
            <div class="jumbotron">
            <!-- BODY START -->
            <div>
                <h1>Créer un livraison</h1>
                <form method="get" action="">
                    <input hidden type="text" name="action" value="creerLivraison"/>
                    <div class="form-group row">
                        <label class="col-md-1">Bon de commande<span class="requis">*</span></label>
                        <select name="bonCommande" class="col-md-3 form-control" required>
                            <option></option>
                            <% Collection<BonDeCommande> _bonDeCommande = bonDeCommande;
                                for (BonDeCommande b : _bonDeCommande) {%>
                                <option value="<%=b.getId()%>"><%=b.getDateCommande()%></option>
                            <%}%>
                        </select>
                    </div> 
                    <div class="form-group row">
                        <label class="col-md-1">Agent de livraison<span class="requis">*</span></label>
                        <select name="exemplaire" class="col-md-3 form-control" required>
                            <option></option>
                            <% Collection<Livraison> _livraison = livraison;
                                for (Livraison l : _livraison) {%>
                                <option value="<%=l.getId()%>"><%=l.getlAgentDeLivraison().getNomPersonne()%><%=l.getlAgentDeLivraison().getPrenomPersonne()%>)</option>
                            <%}%>
                        </select>
                    </div> 
                    <div class="form-group row">
                        <label class="col-md-1">Date de livraison<span class="requis">*</span></label>
                        <div class="col-md-3">
                            <input class="form-control" type="date" name="dateLivraison"/>
                        </div>                        
                    </div>
                    <button type="submit" class="btn btn-success">Enregistre</button>
                      
                </form> 
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
