<%-- 
    Document   : annulerPromotion
    Created on : 15 mars 2018, 14:34:12
    Author     : jules
--%>

<%@page import="Entites.Autre.Article"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Promotion</title>
        
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="article" scope="request" type="Entites.Autre.Article"></jsp:useBean>

        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Annuler une promotion</h1>
                <% Article _article = article;%>
                <form method="POST" action=".....">
                    <input hidden type="text" name="action" value="ajouterPromotion"/> 
                    <div class="form-group row">
                        <label class="col-md-2">Libelle<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="prenom" value="<%=_article.getLibelle()%>" readonly/>
                        </div>                        
                    </div>
                    
                    <div class="form-group row">
                        <label class="col-md-2">Prix<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="promotion" value=" <%=_article.getPrixPromotion()%>" readonly/>
                        </div>                        
                    </div>
                    <button type="submit" class="btn btn-success">Annuler</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
