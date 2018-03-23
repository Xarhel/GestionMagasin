<%-- 
    Document   : retraitArticlePerimer
    Created on : 20 mars 2018, 08:39:35
    Author     : jules
--%>

<%@page import="Entites.Autre.Stock"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            
        <title>Liste de stock perimé</title>
        <jsp:include page="header.jsp"/>
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="stock" scope="request" class="java.util.Collection"></jsp:useBean>         
        <body>
            <div class="container">
                <jsp:include page="menuEmployeRayon.jsp"/>
                
            <!-- BODY START -->
            <div>
                <div class="jumbotron">
                <h1>Liste de stock perimé</h1>
                <form method="post" action="EmployeRayon">
                    <input hidden type="text" name="action" value="retraitArticlePerime"/>
                <button type="submit" class="btn-success"> retirer </button>
                </form>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    
                    
                    
                    <thead>
                        
                        <tr>
                            <th>Libelle article</th>
                            <th>Quantité stock</th>

                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Libelle article</th>
                            <th>Quantité stock</th>

                        </tr>
                    </tfoot>
                    
                    <tbody>
                         
                        <% Collection<Stock> _stock = stock;
                            for (Stock s : _stock) {%>
                        <tr><td><%=s.getlArticle().getLibelle() %></td>
                            <td><%=s.getQuantiteStock()%></td>                                                   
                        </tr><%}%>
                    <td>
                    </td>
                    
                   
                    </tbody>
                    
                </table>
            </div>
                </div>
            <!-- BODY END--> 
            
        </div>
    </body>
</html>