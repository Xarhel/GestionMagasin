<%-- 
    Document   : modifierEmploye
    Created on : 14 mars 2018, 09:27:57
    Author     : 5153218
--%>

<%@page import="java.util.Collection"%>
<%@page import="Entites.Personne.Employe"%>
<%@page import="Entites.Autre.Rayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Assigner un rayon</title>
        <jsp:include page="header.jsp"/>
        <jsp:useBean id="employe" scope="request" type="Entites.Personne.Employe"></jsp:useBean>
        <jsp:useBean id="rayon" scope="request" type="java.util.Collection"></jsp:useBean>

        </head>
        <body>
            <div class="container">
                <jsp:include page="menu.jsp"/>
                <div class="jumbotron">
                     <!-- BODY START -->

                     <h1>Assigner un rayon</h1>
                <% Employe _employe = employe;%>                
                <form method="POST" action="Administrateur">

                    <input hidden type="text" name="action" value="assignerRayon"/>
                    <input hidden type="text" name="id" value="<%=_employe.getId()%>"/>

                    <div class="form-group row">
                        <label class="col-md-2">Nom</label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" value="<%=_employe.getNomPersonne()%>" disabled/>
                        </div>                        
                    </div>

                    <div class="form-group row">
                        <label class="col-md-2">Rayon<span class="requis">*</span></label>
                        <select name="rayon" class="col-md-3 form-control" required>
                            <% Collection<Rayon> rayonList = rayon;
                            for (Rayon r : rayonList) {%>
                            <option value="<%=r.getId()%>"><%=r.getRayonNom()%></option>
                            <%}%>
                        </select>
                    </div>
                    <button type="submit" class="col-md-3 btn btn-lg btn-success">Valider et retourner à la liste</button>
                </form>
            </div>
        </div>
    <!-- BODY END-->
</body>
</html>

