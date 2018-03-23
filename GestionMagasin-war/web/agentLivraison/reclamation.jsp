<%-- 
    Document   : reclamation
    Created on : 23 mars 2018, 09:06:05
    Author     : 5153218
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Faire une reclamation</title>
        <jsp:include page="include/header.jsp"/>
        <%@page import="java.util.Collection"%>
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp"/>
            <!-- BODY START -->
            <div>
                <h1>Faire une reclamation</h1>
                <jsp:useBean id="article" scope="request" type="Entites.Autre.Article"></jsp:useBean>
                <jsp:useBean id="ReclamationLot" scope="request" type="Entites.Autre.ReclamationLot"></jsp:useBean>
                    <form method="POST" action="">
                        <input hidden type="text" name="action" value="aricle"/>
                        <div class="form-group row">
                            <label class="col-md-2">Libelle ariticle<span class="requis">*</span></label>
                            <div class="col-md-4">
                                <input class="form-control" type="text" name="libelle" value="<%=article.getLibelle()%>" readonly />
                        </div>                        
                    </div>
                    <div class="form-group row">
                        <label class="col-md-2">Quantité<span class="requis">*</span></label>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="quantite" required/>
                        </div>                        
                    </div> 
                    <div class="form-group">
                        <label class="col-md-2">Motifs de reclamation</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" required></textarea>
                    </div>

                    <button type="submit" class="btn btn-success">Envoyer</button>                    
                </form> 
            </div>
            <!-- BODY END-->
        </div>
    </body>
</html>