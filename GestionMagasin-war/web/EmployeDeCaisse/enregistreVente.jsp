<%-- 
    Document   : enregistreVente
    Created on : 22 mars 2018, 14:44:48
    Author     : jules
--%>

<%@page import="java.util.Collection"%>
<%@page import="Entites.Autre.Article"%>
<%@page import="Entites.Autre.RayonArticle"%>
<%@page import="Entites.Vente.ArticleVente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Modifier prix</title>
        <jsp:useBean id="article" scope="request" type="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="articles" scope="request" type="Entites.Autre.Article"></jsp:useBean>
        <jsp:useBean id="rayonArticle" scope="request" type="Entites.Autre.RayonArticle"></jsp:useBean>
        <jsp:useBean id="rayonArticles" scope="request" type="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="articleVente" scope="request" type="Entites.Vente.ArticleVente"></jsp:useBean>
        <jsp:useBean id="articleVentes" scope="request" type="java.util.Collection"></jsp:useBean>
        <jsp:include page="include/header.jsp"/>

    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <div class="jumbotron"
                 <!-- BODY START -->
                 <h1>Enregistre une vente </h1>              
                <form method="POST" action="">
                    <input hidden type="text" name="action" value="enregistreVente"/>
                    <input hidden type="text" name="id" value="<%=articles.getId()%>"/>
                    <div class="form-group row">
                        <label class="col-md-2">Libelle ariticle<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="libelle" value="<%=articles.getLibelle()%>" readonly />
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Reference article<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="refArticle" value="<%=articles.getReferenceArticle()%>" readonly/>
                        </div>                        
                    </div>   
                    <div class="form-group row">
                        <label class="col-md-2">Prix<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="prix" value="<%=rayonArticle.getPrixVente()%>" readonly/>
                        </div>                        
                    </div>  
                    <div class="form-group row">
                        <label class="col-md-2">Quantité<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="quantite" required/>
                        </div>                        
                    </div>

                    <button type= "submit" class="btn btn-success">Ajouter </button>                     
                </form> 
            </div><br/><br/>
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
                <td><a href="EmployeDeCaise?action= &id=<%=a.getId()%>"  class="btn btn-warning">
                        <span class=" glyphicon glyphicon-remove" title="retirer dans le panier"></span>Supprimer
                    </a>
                </td>
                <%-- Un champ qui afficher la somme de prix des produits vendus --%>
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
                    </div>
                    </body>
                    </html>
