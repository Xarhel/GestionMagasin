<%-- 
    Document   : employe
    Created on : 14 mars 2018, 10:21:30
    Author     : 5153218
--%>

<%@page import="Entites.Personne.Employe"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des employées</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="employe" scope="request" class="java.util.Collection"></jsp:useBean>
       
        </head>
        <body>
            <div class="container">
            <jsp:include page="menuDirection.jsp"/>
            <div class="jumbotron">
            <!-- BODY START -->
            <div>
                <h1>Liste des employées</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Date de création du compte</th>
                            <th>Type de Compte</th>
                            <th>Magasin</th>
                            <th>Rayon</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Date de création du compte</th>
                            <th>Type de Compte</th>
                            <th>Magasin</th>
                            <th>Rayon</th>
                            <th>Actions</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Employe> _employe = employe;
                            for (Employe e : _employe) {%>
                        <tr><td><%=e.getNomPersonne()%></td>
                            <td><%=e.getPrenomPersonne()%></td>
                            <td><%=e.getDateCreationCompte()%></td>    
                            <td><%=e.getTypeCompte()%></td>   
                            
                            <td><% if(e.getLeMagasin()!=null){%>                                
                                <%=e.getLeMagasin().getNom()%>
                                <%} else {%> Aucun <%}%> 
                            </td>
                            
                            <td><% if(e.getLeRayon()!=null){%>                                
                                <%=e.getLeRayon().getRayonNom()%>
                                <%} else {%> Aucun <%}%> 
                            </td>
                            
                            <td><% if(e.getTypeCompte().toString() != "direction" && e.getTypeCompte().toString() != "administrateur" )
                                {%>
                                <a href="Administrateur?action=versAssignerMagasinDirection&id=<%=e.getId()%>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-edit"></span>Assigner un magasin
                                </a>
                                <%}%>
                                <% if(e.getTypeCompte().toString() != "direction" &&
                                        e.getTypeCompte().toString() != "administrateur" &&
                                        e.getTypeCompte().toString() != "agentDeLivraison" &&
                                        e.getTypeCompte().toString() != "employeDeCaisse" &&
                                        e.getTypeCompte().toString() != "gerantMagasin" &&
                                        e.getLeMagasin()!=null)
                                {%>
                                <a href="Administrateur?action=versAssignerRayonDirection&id=<%=e.getId()%>" class="btn btn-info btn-md">
                                    <span class="glyphicon glyphicon-edit"></span>Assigner un rayon
                                </a>
                                <%}%>
                            </td>
                        </tr><%}%>
                    </tbody>
                </table>
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
