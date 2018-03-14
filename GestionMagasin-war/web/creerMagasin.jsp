<%-- 
    Document   : creerMagasin
    Created on : 14 mars 2018, 10:46:36
    Author     : 5153218
--%>
<%@page import="Entites.Autre.Adresse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Créer un magasin</title>
        <jsp:include page="include/header.jsp"/>
        <jsp:useBean id="Adresse" scope="request" type="Entites.Autre.Adresse"></jsp:useBean>

        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Créer un magasin</h1>
                <form method="POST" action="Menu">
                    <input hidden type="text" name="action" value="creerEmploye"/>
                    <div class="form-group row">
                        <label class="col-md-2">Nom du magasin<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="nom" required/>
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <% Collection<Adresse> _adresse = adresse;
          for (adresse a : _adresse) {%>
                        <tr>
                            <td><%=a.getId()%></td>
                            <td><%=a.getlibelleAdresse()%></td>
                            <td><%=a.getrueNom()%></td>
                            <td><%=a.getrueComplement()%></td>
                            <td><%=a.getcodePostal()%></td>
                            <td><%=a.getville()%></td>
                        </tr><%}%>
                    </div>                        

                    <button type="submit" class="btn btn-success">Enregistre</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>