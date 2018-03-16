<%-- 
    Document   : bingoPaga
    Created on : 16 mars 2018, 13:10:53
    Author     : 3137574
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<p> <%String attribut = (String) request.getAttribute("message");
out.println( attribut ); %> </p>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
