<%-- 
    Document   : listeMagasin
    Created on : 15 mars 2018, 08:47:19
    Author     : jules
--%>

<%@page import="Entites.Autre.Magasin"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des magasins</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="magasin" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <div class="jumbotron">
            <!-- BODY START -->
            <div>
                <h1>Liste des magasin</h1>
                <form method="POST" action=".....">
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Nom</th>
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
                        <% Collection<Magasin> _magasin = magasin;
                            for (Magasin m : _magasin) {%>
                        <tr><td><%=m.getNom()%></td>
                            <td><a href="Administrateur?action=versModifierMagasin&id=<%=m.getId()%>" class="btn btn-warning">
                                    <span class="glyphicon glyphicon-edit" title="Modifier un magasin"></span>Modifier
                                </a>
                                <a href="Administrateur?action=versCreerRayon&id=<%=m.getId()%>" class="btn btn-success">
                                    <span class="glyphicon glyphicon-plus" title="Créer un rayon"></span>Créer un rayon
                                </a>
                                <a href="Administrateur?action=afficherTousRayonsParMagasin&id=<%=m.getId()%>" class="btn btn-info">
                                    <span class="glyphicon glyphicon-th-list" title="Afficher les rayons"></span>Afficher les rayons
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
