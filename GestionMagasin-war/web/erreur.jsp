<%-- 
    Document   : erreur
    Created on : 23 mars 2018, 09:33:12
    Author     : 5153218
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <head>        
        <title>Erreur</title>
        <jsp:include page="header.jsp"/>        
        <script src="js/script.js" type="text/javascript"></script>
    </head>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container"> 
        <div class="alert alert-danger">
            <strong>Danger!</strong> Vous avez fait une erreur!
        </div>
    </div>

</body>
</html>