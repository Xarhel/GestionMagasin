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
        <jsp:useBean id="article" scope="request" type="java.util.Collection"></jsp:useBean>

        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Annuler une promotion</h1>
                <form method="POST" action=".....">
                    <input hidden type="text" name="action" value="ajouterPromotion"/> 
                    <div class="form-group row">
                        <label class="col-md-2">Nom de l'article<span class="requis">*</span></label>
                        <select name="libelle" class="col-md-3 form-control" readonly>
                            <option></option>
                            <% Collection<Article> _article= article;
                            for (Article a : _article) {%>
                            <option value="<%=a.getId()%>"><%=a.getLibelle()%></option>
                            <%}%>
                        </select>
                    </div>                      
                    <div class="form-group row">
                        <label class="col-md-2">Prix<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" promtion="promotion" readonly/>
                        </div>                        
                    </div>
                    <button type="submit" class="btn btn-success">Annuler</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
