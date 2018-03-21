<%-- 
    Document   : retraitArticlePerimer
    Created on : 20 mars 2018, 08:39:35
    Author     : jules
--%>

<%@page import="Entites.Autre.Stock"%>
<%@page import="Entites.Autre.StockRetrait"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Liste de stock perimé</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="stock" scope="request" class="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="stockRetrait" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menuEmployeRayon.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste de stock perimé</h1>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Quantité stock</th>
                            <th>Quantinte à rtrait</th>
                            <th>Date retrait</th>
                            <th>Actions</th>


                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Libelle article</th>
                            <th>Quantité stock</th>
                            <th>Quantinte à rtrait</th>
                            <th>Date retrait</th>


                        </tr>
                    </tfoot>
                    <tbody>
                        <% Collection<Stock> _stock = stock;
                            for (Stock s : _stock) {%>
                        <tr><td><%=s.getlArticle()%></td>
                            <td><%=s.getQuantiteStock()%></td>
                            <td><%=s.getLeStockRetrait()%></td>
                            <a href="EmployeRayon?action=retraitProduit&id=<%=s.getId()%>" class="btn btn-info btn-md">
                            <span class="glyphicon glyphicon-edit" title="Supprimer un employe"></span>Retrait
                        </a>
                        </tr><%}%>
                    <td>
                    </td>
                    </tbody>
                </table>
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>