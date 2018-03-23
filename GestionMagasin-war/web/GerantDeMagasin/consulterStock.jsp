<%-- 
    Document   : consulterStock
    Created on : 23 mars 2018, 15:25:29
    Author     : 5153218
--%>

<%@page import="Entites.Autre.Stock"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Stock au magasin</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="stock" scope="request" class="Entites.Autre.Stock"></jsp:useBean>
        <jsp:useBean id="stocks" scope="request" class="java.util.Collection"></jsp:useBean>
        </head>
        <body>
            <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <div class="jumbotron">
                <h1>Stock au magasin</h1>
                <form method="POST" action=".....">
                    <input hidden type="text" name="id" value="<%=stock.getId()%>" />
                    <table id="example" class="table table-striped table-bordered" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Libelle article</th>
                                
                                <th>Quantité stock</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <% Collection<Stock> _stock = stocks;
                            for (Stock s : _stock) {%>
                            <tr>
                                <td><%=s.getlArticle().getLibelle() %></td>
                                <td><%=s.getQuantiteStock() %></td>
                                

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
