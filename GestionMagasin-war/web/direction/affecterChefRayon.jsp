<%-- 
    Document   : affecterChefRayon
    Created on : 19 mars 2018, 09:28:15
    Author     : jules
--%>

<%@page import="Entites.Personne.ChefDeRayon"%>
<%@page import="Entites.Autre.Rayon"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Affecter chef de rayon</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="rayon" scope="request" class="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="chefRayon" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menuDrection.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Selectionner  le chef de rayon à affecter</h1>
                <form method="POST" action="">
                    <input hidden type="text" name="action" value="affecterChefRayon"/>
                    <div class="form-group row">
                        <label class="col-md-2">Chef de rayon<span class="requis">*</span></label>                        
                        <select name="chefRayon" class=" col-md-4 form-control" required>
                            <option></option>
                            <% Collection<ChefDeRayon> _chefRayon = chefRayon;
                                for (ChefDeRayon cr : _chefRayon) {%>
                                <option value="<%=cr.getId()%>"><%=cr.getId()%></option>
                                <option value="<%=cr.getId()%>"><%=cr.getNomPersonne()%></option>
                                <option value="<%=cr.getId()%>"><%=cr.getPrenomPersonne()%></option>
                            <%}%>
                        </select>
                    </div>
                        <h1>Selectionner  le rayon</h1>
                        <div class="form-group row">
                        <label class="col-md-2">Rayon<span class="requis">*</span></label>                        
                        <select name="rayon" class=" col-md-4 form-control" required>
                            <option></option>
                            <% Collection<Rayon> _rayon = rayon;
                                for (Rayon r : _rayon) {%>
                                <option value="<%=r.getId()%>"><%=r.getId()%></option>
                                <option value="<%=r.getId()%>"><%=r.getRayonNom()%></option>
                                <option value="<%=r.getId()%>"><%=r.getLeMagasin()%></option>
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
