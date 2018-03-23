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
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="rayon" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <div class="jumbotron">
            <!-- BODY START -->
            <div>
                <h1>Liste des rayons</h1>
                <form method="POST" action="../Administrateur">
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
                        <% Collection<Rayon> _rayon = rayon;
                            for (Rayon r : _rayon) {%>
                        <tr><td><%=r.getRayonNom()%></td>
                            <td><a href="Administrateur?action=versModifierRayon&id=<%=r.getId()%>" class="btn btn-warning">
                                    <span class="glyphicon glyphicon-edit" title="Modifier un rayon"></span>Modifier
                                </a>
                            </td>
                        </tr><%}%>
                    </tbody>
                </table>
                </form>
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>