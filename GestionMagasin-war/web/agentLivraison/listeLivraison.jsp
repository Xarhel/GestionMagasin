<%-- 
    Document   : listeLivraison
    Created on : 21 mars 2018, 09:33:17
    Author     : 5153218
--%>

<%@page import="Entites.Autre.Livraison"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des livraisons</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="livraison" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <div class="jumbotron">
            <!-- BODY START -->
            <div>
                <h1>Liste des livraisons</h1>
                <form method="POST" action="AgentLivraison">
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Numéro de Livraison</th>
                            <th>Rayon</th>
                          
                            <th>Actions</th>
                            
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Numéro de Commande</th>
                            <th>Rayon</th>
                          
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Livraison> _livraison = livraison;
                            for (Livraison l : _livraison) {%>
                        <tr>
                            <td><%=l.getLeBonDeCommande().getId()%></td>
                            <td><%=l.getLeBonDeCommande().getLeChefDeRayon().getLeRayon().getRayonNom()%></td>
                          
                       <td>     <a href="AgentLivraison?action=versEnregistrerLivraison&id=<%=l.getId()%>" class="btn btn-info btn-md">
                               <span class="glyphicon glyphicon-edit" title="enregistrerLivraison"></span> EnregistrerLivraison 
                                </a></td>
                         <td><a href="AgentLivraison?action=versCreerReclamation&id=<%=l.getId()%>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-edit" title="Reclamer"></span>Reclamation
                                </a>
                                <a href="AgentLivraison?action=RetourProduit&id=<%=l.getId()%>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-edit" title="Retour"></span>Retourner
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
