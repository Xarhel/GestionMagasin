<%-- 
    Document   : creerRayon
    Created on : 14 mars 2018, 15:30:15
    Author     : 5153218
--%>

<%@page import="java.util.Collection"%>
<%@page import="Entites.Autre.Magasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un rayon</title>
        <jsp:include page="header.jsp"/>
        <jsp:useBean id="magasin" scope="request" type="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="magasins" scope="request" type="Entites.Autre.Magasin"></jsp:useBean>

        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <div class="jumbotron">
                <h1>Créer un rayon</h1>
                
                <form method="POST" action="Administrateur">
                    <input hidden type="text" name="action" value="creerRayon"/>
                    <input hidden type="text" name="id" value="<%=magasins.getId()%>" />
                    
                    <div class="form-group row">
                        <label class="col-md-1">Nom du magasin<span class="requis">*</span></label>
                        <select name="magasin" class="col-md-3 form-control" required>
                            <option></option>
                            <% Collection<Magasin> _magasin = magasin;
                                for (Magasin m : _magasin) {%>
                                <option value="<%=m.getId()%>"><%=m.getNom()%></option>
                            <%}%>
                        </select>
                    </div> 
                    <div class="form-group row">
                        <label class="col-md-2">Nom du rayon<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" required/>
                        </div>                        
                    </div>                     
                    <button type="submit" class="btn btn-success">Enregistrer</button>                    
                </form> 
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
