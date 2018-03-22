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
        <div class="container-fluid">
            <!-- BODY START -->
            <div>    
                <form method="POST" action="Administrateur">
                    <div class="recherche">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" name="nom" placeholder="Nom" class="form-control left-rounded">
                                    <input type="hidden" name="action" value="rechercherEmploye">
                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-success right-rounded">Rechercher</button>
                                    </div> 
                                </div> <br/>
                                <div class="image">
                                    <img src="images/Magasin_Aarhus.jpg"  alt="Magasin" class="img-responsive">
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

