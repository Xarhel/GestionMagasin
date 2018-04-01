<%-- 
    Document   : listeLivraison
    Created on : 21 mars 2018, 09:33:17
    Author     : 5153218
--%>

<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType"%>
<%@page import="Entites.Enum.CategorieArticle"%>
<%@page import="Entites.Autre.CommandeLot"%>
<%@page import="Entites.Autre.Livraison"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste des livraisons</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="cl" scope="request" class="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="id" scope="request" class="String"></jsp:useBean>

        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div class ="jumbotron">
            <div>
                
                <h1>Enregistrer la Livraison</h1>
                <form method="POST" action="AgentLivraison">
                    <input hidden type="text" name="action" value="enregistrerCommandeLot"/>
                    <input hidden type="text" name="id" value="<%=id%>"/>
                    
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Article</th>
                            <th>Quantité Demandée</th>
                            <th>Quantité Livrée</th>
                            <th>Quantité Reçue</th>
                            <th>Quantité Acceptée</th>
                            <th></th>

                       
                            
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Article</th>
                            <th>Quantité Demandée</th>
                            <th>Quantité Livrée</th>
                            <th>Quantité Reçue</th>
                            <th>Quantité Acceptée</th>
                            <th></th>
                          

                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<CommandeLot> _livraison = cl;
                        int s=0;
                            for (CommandeLot l : _livraison) {
                        
                        s=s+1;
                        String a = Integer.toString(s);%>
                        <tr>
                            <td><%=l.getLeLot().getlArticle().getLibelle()%></td>
                            <td><%=l.getLeLot().getQuantite()%></td>
                          
                            <td><input class="form-control" type="text" name="<%="qlivree"+a%>" required/></td>
                            <td><input class="form-control" type="text" name="<%="qrecue"+a%>" required/></td>
                            <td><input class="form-control" type="text" name="<%="qacceptee"+a%>" required/><input hidden type="text" name="<%="idCommandeLot"+a%>" value="<%=l.getId()%>"></td>
                            <% if (l.getLeLot().getlArticle().getCategorie()== CategorieArticle.Vêtements){%>
                            <td><input placeholder="Taille" class="form-control" type="text" name="<%="taille"+a%>" required/></td> <%}%>
                            <% if (l.getLeLot().getlArticle().getCategorie()== CategorieArticle.Alimentaire){%>
                            <td><input placeholder="Date de péremption" class="form-control" type="date" name="<%="dateperemption"+a%>" required/></td><%}%>
                            <% if (l.getLeLot().getlArticle().getCategorie()== CategorieArticle.Electroménager){%>
                            <td><input placeholder="Durée de Garantie" class="form-control" type="text" name="<%="garantie"+a%>" required/></td><%}%>

   <!--                         <td>     <a href="AgentLivraison?action=enregistrerCommandeLot&id=<%=l.getId()%>&idCommande=<%=l.getLeBonDeCommande().getId()%>&idLivraison=<%=id%>" class="btn btn-info btn-md">
                               <span class="glyphicon glyphicon-edit" title="enregistrerLivraison"></span> Valider
                                </a>
                                <a href="AgentLivraison?action=versEnregistrerReclamation&id=<%=l.getId()%>" class="btn btn-info btn-md">
                               <span class="glyphicon glyphicon-edit" title="enregistrerLivraison"></span> Reclamation 
                                </a>
                       </td>      -->
                        </tr><%}%>
                    </tbody>
                </table>
                <button type="submit" class="btn btn-success">Valider</button>    
                </form>
                    
            </div>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>
