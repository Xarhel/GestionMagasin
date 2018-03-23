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
        
        <jsp:useBean id="idPanier" scope="request" type="Entites.Vente.PanierCaisse"></jsp:useBean>
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
                alert("Vous allez ajouter " + quantite + " articl(s) à votre panier");
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
                    <input hidden type="text" name="action" value="enregistrerVente"/>

                    <table class="table table-hover" >
                        <thead>
                            <tr>
                                <th>Libelle de l'article</th>
                                <th>Référence</th>
                                <th>Prix unitaire</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% Collection<RayonArticle> articleDisponible = rayonArticles;
                                    for (RayonArticle ra : articleDisponible) {%>                           
                            <tr><td><%=ra.getLesArticles().getLibelle()%></td></tr>
                            <tr><td><%=ra.getLesArticles().getReferenceArticle()%></td></tr>
                            <tr><td><%=ra.getPrixVente()%></td></tr>
                            
                            <div class="form-group row">
                            <label class="col-md-2">Quantite<span class=""></span></label>
                            <div class="col-md-4">
                                <input class="form-control" id="quantite" type="text" name="quantiteArticle" readonly />
                            </div>                        
                            </div>
                            <tr><td><a href="EmployeRayon?action=ajouterArticle&id=<%=ra.getId()%>" class="btn btn-danger">
                                       <span class=" glyphicon glyphicon-remove" onclick="alert('Veuillez renseigner une quantité à ajouter au panier')"></span>Ajouter au panier</a>
                            </td></tr>
                        </tbody>
                    </table>

                    <button type= "submit" class="btn btn-success">Ajouter </button>                     
                </form> 
            </div>
        <br/>
        <br/>
 
        
            <%-- RÉCAPITULATIF DE PAIEMENT --%>
            
            <%--
            
            <h1>Liste des articles et la somme de prix du client</h1>
           
            <table class="table table-hover" >
                <thead>
                    <tr>
                        <th>Libelle de l'article</th>
                        <th>Quantité</th>
                        <th>Prix de vente</th>
                        <th>Prix total</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% Collection<Article> _article = article;
                            for (Article a : _article) {%>
                    <tr><td><%=a.getLibelle()%></td></tr>
                    <% Collection<ArticleVente> _articleVente = articleVentes;
                            for (ArticleVente av : _articleVente) {%>
                    <tr><td><%=av.getQuantite()%></td></tr>
                    <% Collection<RayonArticle> _rayonArticle = rayonArticles;
                            for (RayonArticle ra : _rayonArticle) {%>
                    <tr><td><%=ra.getPrixVente()%></td></tr>
                    <tr><td><%=ra.getPrixVente()%>*<%=av.getQuantite()%></td></tr>
                <td><a href="EmployeDeCaise?action=&id=<%=a.getId()%>"  class="btn btn-warning">
                        <span class=" glyphicon glyphicon-remove" title="retirer dans le panier"></span>Supprimer
                    </a>
                </td>
            
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
                </tbody>
            </table>
                
                    <!-- BODY END-->
            --%>
        </div>
    </body>
</html>
