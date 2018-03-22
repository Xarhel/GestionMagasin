<%-- 
    Document   : modifierEmploye
    Created on : 14 mars 2018, 09:27:57
    Author     : 5153218
--%>

<%@page import="java.util.Collection"%>
<%@page import="Entites.Personne.Employe"%>
<%@page import="Entites.Autre.Magasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Modifier un employée</title>
        <jsp:include page="header.jsp"/>
        <jsp:useBean id="employe" scope="request" type="Entites.Personne.Employe"></jsp:useBean>
        <jsp:useBean id="magasin" scope="request" type="java.util.Collection"></jsp:useBean>
        <jsp
        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Assigner un magasin</h1>
                <% Employe _employe = employe;%>                
                <form method="POST" action="Administrateur">
                    
                    <input hidden type="text" name="action" value="assignerMagasin"/>
                    <input hidden type="text" name="id" value="<%=_employe.getId()%>"/>
                    
                    <div class="form-group row">
                        <label class="col-md-2">Nom</label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" value="<%=_employe.getNomPersonne()%>" disabled/>
                        </div>                        
                    </div>
                    
                    <div class="form-group row">
                            <label class="col-md-2">Magasin<span class="requis">*</span></label>
                            <select name="magasin" class="col-md-3 form-control" required>
                                <% Collection<Magasin> magasinList = magasin;
                                for(Magasin m : magasinList )
                                {%>
                                <option value="<%=m.getId()%>"><%=m.getNom()%></option>
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

