<%-- 
    Document   : rechercherEmploye
    Created on : 20 mars 2018, 10:50:09
    Author     : jules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rechercher un employé</title>
        <jsp:include page="header.jsp"/>  
        <jsp:include page="menuDirection.jsp"/>
        <script src="js/script.js" type="text/javascript"></script>
        </head>
        <body>
            <div class="container">
            <!-- BODY START -->
            <div>    
                <form method="POST" action="Administrateur">
                    <div class="recherche">
                        <div class="col-md-4">
                            <input type="text" name="nom" placeholder="Nom"/>
                            <input type="hidden" name="action" value="rechercherEmploye">
                            <button type="submit">Rechercher</button>
                        </div>
                    </div>
                </form>
            </div>
            </div>
        </body>
</html>

