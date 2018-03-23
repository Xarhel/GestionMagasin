<%-- 
    Document   : creerLivraison
    Created on : 20 mars 2018, 09:33:13
    Author     : jules
--%>
<%@page import="Entites.Personne.Fournisseur"%>
<%@page import="Entites.Autre.Livraison"%>
<%@page import="Entites.Autre.BonDeCommande"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer une livraison</title>
        <jsp:include page="header.jsp"/>
      
        <jsp:useBean id="bdc" scope="request" class="java.util.Collection"></jsp:useBean>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <div class="jumbotron">
            <!-- BODY START -->
            <div>
                <h1>Créer une livraison</h1>
                <form method="POST" action="FournisseurServlet">
                    
                <input hidden type="text" name="action" value="creerLivraison"/>
                
                    <div class="form-group row">
                        <label class="col-md-1">Bon de commande<span class="requis">*</span></label>
                        <select name="bonCommande" class="col-md-3 form-control" required>
                            <% Collection<BonDeCommande> _bonDeCommande = bdc;
                                for (BonDeCommande b : _bonDeCommande) {%>
                                <option value="<%=b.getId()%>"> La commande: (<%=b.getId()%>) Passée le: (<%=b.getDateCommande()%>)</option>
                            <%}%>
                        </select>
                    </div> 
                   
                    <div class="form-group row">
                        <label class="col-md-1">Date de livraison<span class="requis">*</span></label>
                        <div class="col-md-3">
                            <input class="form-control" type="date" name="dateLivraison"/>
                        </div>                        
                    </div>
                        
                        
                    <button type="submit" class="btn btn-success">Créer Livraison et visualiser les lots expédiés</button>
                      
                </form>
                 
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
