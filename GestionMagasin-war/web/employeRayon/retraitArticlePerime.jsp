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
            
        <title>Liste de stock perimé</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
        <jsp:useBean id="stock" scope="request" class="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="stockRetrait" scope="request" class="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="date" scope="request" class="java.util.Date"></jsp:useBean>
        
        
        <body>
            <div class="container">
            <jsp:include page="menuEmployeRayon.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Liste de stock perimé</h1>
                <form method="post" action="EmployeRayon">
                    <input hidden type="text" name="action" value="supprimerProduitPerime"/>
                <button type="submit" class="btn-success"> retirer </button>
                </form>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
                    
                    
                    
                    <thead>
                        
                        <tr>
                            <th>Libelle article</th>
                            <th>Quantité stock</th>
                            <th>Quantite à retirer</th>
                            <th>Date retrait</th>
                            


                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Libelle article</th>
                            <th>Quantité stock</th>
                            <th>Quantité à retirer</th>
                            <th>Date retrait</th>


                        </tr>
                    </tfoot>
                    <tbody>
                         
                        <% Collection<Stock> _stock = stock;
                            for (Stock s : _stock) {%>
                        <tr><td><%=s.getlArticle().getLibelle() %></td>
                            <td><%=s.getQuantiteStock()%></td>
                            <td><%=s.getLeStockRetrait().getQuantiteRetrait() %></td>
                           
                            
                             <% Collection<StockRetrait> _stockRetrait = stockRetrait;
                             for (StockRetrait sr : _stockRetrait) {%>
                             <td><%=sr.getDateRetrait() %></td> 
                             
                             
                             
                            
                       
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