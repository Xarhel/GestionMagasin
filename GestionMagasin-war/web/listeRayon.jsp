<%-- 
    Document   : listeRayon
    Created on : 15 mars 2018, 08:58:06
    Author     : jules
--%>

<%@page import="Entites.Autre.Rayon"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des rayons</title>
        <jsp:include page="include/header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="rayon" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="include/menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste des rayons</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Nom du rayon</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Nom</th>
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Rayon> _rayons = rayon;
                            for (Rayon r : _rayons) {%>
                        <tr><td><%=e.getRayonNom()%></td>
                            <td><a href="Menu?action=pageModifierRayon&id=<%=r.getId()%>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-edit" title="Modifier un rayon"></span>Modifier
                                </a>
                            </td>
                        </tr><%}%>
                    </tbody>
                </table>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>