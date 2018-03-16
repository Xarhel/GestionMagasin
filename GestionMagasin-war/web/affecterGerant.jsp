<%-- 
    Document   : affecterGerant
    Created on : 16 mars 2018, 14:56:00
    Author     : 5153218
--%>

<<%@page import="entites.Magasin"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Affecter des gérants</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="magasin" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menuDrection.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Selectionner  le gérant à affecter</h1>
                <form method="POST" action="Menu">
                    <input hidden type="text" name="action" value="affecterGerant"/>
                    <div class="form-group row">
                        <label class="col-md-2">ID<span class="requis">*</span></label>                        
                        <select name="gerant" class=" col-md-4 form-control" required>
                            <option></option>
                            <% Collection<Gerant> _gerant = gerant;
                                for (Gerant g : _gerant) {%>
                                <option value="<%=g.getId()%>"><%=g.Id()%></option>
                            <%}%>
                        </select>
                    </div>
                        <div class="form-group row">
                        <label class="col-md-2">ID<span class="requis">*</span></label>                        
                        <select name="gerant" class=" col-md-4 form-control" required>
                            <option></option>
                            <% Collection<Gerant> _gerant = gerant;
                                for (Gerant g : _gerant) {%>
                                <option value="<%=g.getId()%>"><%=g.Id()%></option>
                            <%}%>
                        </select>
                    </div>
                            <%-- <div class="form-group row">
                        <label class="col-md-2">Abonné<span class="requis">*</span></label>
                        <select name="abonne" class="col-md-4 form-control" required>
                            <option></option>
                            <% Collection<Abonne> _abonnes = abonnes;
                                for (Abonne f : _abonnes) {%>
                                <option value="<%=f.getId()%>"><%=f.getPrenom()%> <%=f.getNom()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Date de reservation<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="date" name="dateReservation" required/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success">Enregistre</button>
                    <button type="reset" class="btn btn-success">Remettre à zéro" </button>
                </form> --%>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>>
