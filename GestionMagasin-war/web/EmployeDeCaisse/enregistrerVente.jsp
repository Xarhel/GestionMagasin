<%-- 
    Document   : enregistreVente
    Created on : 22 mars 2018, 14:44:48
    Author     : jules
--%>

<%@page import="java.util.Collection"%>
<%@page import="Entites.Autre.Article"%>
<%@page import="Entites.Autre.RayonArticle"%>
<%@page import="Entites.Vente.ArticleVente"%>
<%@page import="Entites.Vente.PanierCaisse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
    <head>        
        <title>Enregistrer une vente</title>
        
        <jsp:useBean id="idPanier" scope="request" type="java.lang.Long"></jsp:useBean>
        <jsp:useBean id="rayonArticles" scope="request" type="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="articlesVente" scope="request" type="java.util.Collection"></jsp:useBean>
        
        <jsp:include page="header.jsp"/>
        <jsp:include page="menu.jsp"/>
        
        <script>
        function selectionQuantite()
        {
            var input = document.getElementById("quantite").value;
            if(input == null || input == "")
            {
                alert("Merci de bien vouloir saisir une quantité");
            }
            else
            {
                alert("Vous allez ajouter " + quantite.toString() + " article(s) à votre panier");
            }
        }
        </script>

    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                
                 <!-- BODY START -->
                 
                 <h1>Enregistrer une vente</h1>              
                <form method="POST" action="EmployeCaisse">
                    <input hidden="" type="text" name="action" value="ajouterArticle"/>
                    <input hidden="" type="text" name="idPanier" value="<%=idPanier%>"/>
                    
                    <div id="article" class="form-group row">
                        <label class="col-md-2">Article à ajouter<span class="requis">*</span></label>
                        <select name="article" class="col-md-3 form-control" required>
                            <% Collection<RayonArticle> articlesDisponibles = rayonArticles;
                            for(RayonArticle ra : articlesDisponibles )
                            {%>
                            <option value="<%=ra.getId()%>"><%=ra.getLesArticles().getLibelle()%>, <%=ra.getPrixVente()%>€</option>
                            <%}%>
                        </select>
                    </div>
                    
                    <div class="form-group row">
                        <label class="col-md-2">Quantite<span class="requis"></span></label>
                        <div class="col-md-4">
                            <input class="form-control" id="quantite" type="text" name="quantite" />
                        </div>
                    </div>
                        
                    <button type="submit" class="btn btn-success">Ajouter au panier</button>
                </form>
                        </br>
                        </br>
                         
        
            <%-- RÉCAPITULATIF DE PAIEMENT --%>           
            
            <h2>Liste des articles du panier</h2>
           
            <table class="table table-hover" >
                <thead>
                    <tr>
                        <th>Libelle de l'article</th>
                        <th>Quantité</th>
                        <th>Prix de vente unitaire</th>
                        <th>Prix total</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <% Collection<ArticleVente> _articlesVente = articlesVente;
                            for (ArticleVente a : _articlesVente) {%>
                    <tr>
                        <td><% if(a.getId() != null) {%>
                            <%=a.getStock().getlArticle().getLibelle()%>
                            <%} else {%> Aucun <%}%>
                        </td>
                        <td><% if(a.getId() != null) {%>
                            <%=a.getQuantite()%>
                            <%} else {%> Aucun <%}%>
                        </td>
                        <td><% if(a.getId() != null) {%>
                            <%=a.getPrixUnitaire()%>
                            <%} else {%> Aucun <%}%>
                        </td>
                        <td><% if(a.getId() != null) {%>
                            <%=a.getPrixUnitaire()*a.getQuantite()%>
                            <%} else {%> Aucun <%}%>
                        </td>
                        <td>
                        <a href="EmployeDeCaise?action=&id=<%=a.getId()%>"  class="btn btn-warning">
                            <span class=" glyphicon glyphicon-remove" title="retirer du panier"></span>Retirer du panier
                        </a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                    
                <!-- Un champ qui affiche la somme de prix des produits vendus -->
            
                <div class="form-group row">
                        <label class="col-md-2">Total<span class=""></span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="" value=" " readonly />
                        </div>                        
                </div>
                <div class="buton">
                <button type="submit" class="btn btn-success">Valider</button>
                <button type="submit" class="btn btn-success">Imprimer la facture</button>
                </div>
              
                    <!-- BODY END-->
                    
        </div>
    </body>
</html>
