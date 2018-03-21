<%-- 
    Document   : affecterGerant
    Created on : 16 mars 2018, 14:56:00
    Author     : 5153218
--%>

<%@page import="Entites.Personne.GerantMagasin"%>
<%@page import="Entites.Autre.Magasin"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Affecter des gérants</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="magasin" scope="request" class="Entites.Autre.Magasin"></jsp:useBean>
        <jsp:useBean id="gerant" scope="request" class="Entites.Personne.GerantMagasin"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menuDrection.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Selectionner  le gérant à affecter</h1>
                <form method="POST" action="">
                    <input hidden type="text" name="action" value="affecterGerant"/>
                    <div class="form-group row">
                        <label class="col-md-2">Gerant du magasin<span class="requis">*</span></label>                        
                        <select name="gerant" class=" col-md-4 form-control" required>
                            <option></option>
                            <% Collection<GerantMagasin> _gerant = gerant;
                                for (GerantMagasin g : _gerant) {%>
                                <option value="<%=g.getId()%>"><%=g.getId()%></option>
                                <option value="<%=g.getId()%>"><%=g.getNomPersonne()%></option>
                                <option value="<%=g.getId()%>"><%=g.getPrenomPersonne()%></option>
                            <%}%>
                        </select>
                    </div>
                        <h1>Selectionner le magasin</h1>
                        <div class="form-group row">
                        <label class="col-md-2">Magasin<span class="requis">*</span></label>                        
                        <select name="gerant" class=" col-md-4 form-control" required>
                            <option></option>
                            <% Collection<Magasin> _magasin = magasin;
                                for (Magasin g : _magasin) {%>
                                <option value="<%=g.getId()%>"><%=g.getId()%></option>
                                <option value="<%=g.getId()%>"><%=g.getNom()%></option>
                                <option value="<%=g.getId()%>"><%=g.getAdresse()%></option>
                            <%}%>
                        </select>
                    </div>
                           
                    <button type="submit" class="btn btn-success">Affecter</button>
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>>
