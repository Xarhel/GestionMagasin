<%-- 
    Document   : modifierRayon
    Created on : 14 mars 2018, 15:51:36
    Author     : 5153218
--%>

<%@page import="Entites.Autre.Adresse"%>
<%@page import="Entites.Autre.Rayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Modifier un rayon</title>
        <jsp:useBean id="rayon" scope="request" type="Entites.Autre.Rayon"></jsp:useBean>
        <jsp:include page="include/header.jsp"/>

    </head>
    <body>
        <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <h1>Modifier un rayon</h1>    
            <% Rayon _rayon = rayon;%>                
            <form method="POST" action="Menu">
                <input hidden type="text" name="action" value="modifierMagasin"/>
                <input hidden type="text" name="id" value="<%=_rayon.getId()%>"/>
                <div class="form-group row">
                    <label class="col-md-2">Nom du rayon<span class="requis">*</span></label>
                    <div class="col-md-4">
                        <input class="form-control" type="text" name="nom" value="<%=_rayon.getRayonNom()%>" required/>
                    </div>                        
                </div>
                <div class="form-group row">
                    <% Collection<Magasin> _magasin = magasin;
          for (Magasin m : _magasin) {%>
                    <tr>
                        <td><%=m.getId()%></td>
                        <td><%=m.getNom()%></td>
                    </tr><%}%>
                </div>                        

                <button type="submit" class="btn btn-success">Enregistre</button>                    
            </form> 
        </div>
        <!-- BODY END-->
    </div>
</body>
</html>