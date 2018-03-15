<%-- 
    Document   : creerRayon
    Created on : 14 mars 2018, 15:30:15
    Author     : 5153218
--%>

<%@page import="Entites.Autre.Magasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un rayon</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="Magasin" scope="request" type="Entites.Autre.Magasin"></jsp:useBean>

        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Créer un rayon</h1>
                <form method="POST" action="Menu">
                    <input hidden type="text" name="action" value="creerEmploye"/>
                    <div class="form-group row">
                        <label class="col-md-2">Nom du rayon<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" rayonNom="nom" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                        <select name="nom" class="col-md-3 form-control" required>
                            <option></option>
                            <% Collection<Magasin> _magasins = magasins;
                            for (magasin m : _magasins) {%>
                            <option value="<%=m.getId()%>"><%=m.getNom()%></option>
                            <%}%>
                        </select>  

                    </div>                      

                    <button type="submit" class="btn btn-success">Enregistre</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>