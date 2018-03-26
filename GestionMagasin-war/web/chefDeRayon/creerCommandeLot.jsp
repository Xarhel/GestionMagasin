<%-- 
    Document   : creerCommandeLot
    Created on : 20 mars 2018, 14:06:07
    Author     : jules
--%>

<%@page import="java.util.Collection"%>
<%@page import="Entites.Autre.RayonArticle"%>
<%@page import="Entites.Autre.BonDeCommande"%>
<%@page import="Entites.Autre.CommandeLot"%>
<%@page import="Entites.Autre.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer une commande</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <jsp:useBean id="article" scope="request" class="java.util.Collection"></jsp:useBean>
            <jsp:useBean id="lots" scope="request" class="java.util.Collection"></jsp:useBean>
            <jsp:useBean id="bon" scope="request" class="String"></jsp:useBean>
                <!-- BODY START -->
                <div>
                    <h2>Ajouter un lot à la commande</h2>
                    <form method="POST" action="ChefDeRayon">
                        <input hidden type="text" name="action" value="creerCommandeLot"/>
                        <input hidden type="text" name="bon" value="<%=bon%>"/>
                        
                        <div class="form-group row">
                            <label class="col-md-2">article<span class="requis">*</span></label>
                            <select name="libelle" class="col-md-3 form-control" required>
                            <% Collection<RayonArticle> _article = article;
                            for (RayonArticle a : _article) {%>
                            <option value="<%=a.getLesArticles().getId()%>"><%=a.getLesArticles().getLibelle()%></option>
                            
                            <%}%>
                        </select>  
                    </div>
                        
                            <div class="form-group row">
                        
                        <label class="col-md-2">Quantité<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="quantite" required/>
                        </div>                        
                           </div>
                        
                        <div class="form-group row">
                        
                        <label class="col-md-2">Prix d'achat<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="prix" required/>
                        </div> 
                        </div>

                    <button type="submit" class="btn btn-success">Ajouter</button>                    
                </form> 
                                        <div class="jumbotron">
                <h1>Liste des articles</h1>

                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    
                    <thead>
                        <tr>
                            <th>Article</th>
                            <th>Quantité</th>
                            <th>Prix unitaire</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Article</th>
                            <th>Quantité</th>
                            <th>Prix unitaire</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<CommandeLot> _lot = lots;
                            for (CommandeLot a : _lot) {%>
                        <tr><td><%=a.getLeLot().getlArticle().getLibelle()%></td>
                            <td><%=a.getQuantite()%></td>
                            <td><%=a.getPrixAchat()%></td>
                           
                        </tr><%}%>
                    </tbody>
                </table>
                     
            </div>
            <a style="float: right; " class="btn btn-success" href="ChefDeRayon?action=listerCommande">Passer La Commande</a>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>