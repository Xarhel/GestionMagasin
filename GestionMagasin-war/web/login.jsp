<%-- 
    Document   : index
    Created on : 18 janv. 2018, 00:22:08
    Author     : jules
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Login Page</title>
        <jsp:include page="include/header.jsp"/>
        <style>
            .wrapper {    
                margin-top: 80px;
                margin-bottom: 20px;
            }

            .form-signin {
                max-width: 420px;
                padding: 30px 38px 66px;
                margin: 0 auto;
                background-color: #eee;
                border: 3px dotted rgba(0,0,0,0.1);  
            }

            .form-signin-heading {
                text-align:center;
                margin-bottom: 30px;
            }

            .form-control {
                position: relative;
                font-size: 16px;
                height: auto;
                padding: 10px;
            }

            input[type="text"] {
                margin-bottom: 0px;
                border-bottom-left-radius: 0;
                border-bottom-right-radius: 0;
            }

            input[type="password"] {
                margin-bottom: 20px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }

            .colorgraph {
                height: 7px;
                border-top: 0;
                background: #c4e17f;
                border-radius: 5px;
                background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
                background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
                background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
                background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <!-- BODY START -->            
            <div class = "container">
                <div class="wrapper">
                    <form action="Authentication" method="post" name="Login_Form" class="form-signin">                               
                        <h3 class="form-signin-heading">Connectez-vous</h3>
                        <hr class="colorgraph"><br>
                        <input type="text" name="action" value="connexion" hidden/>
                        <input type="text" class="form-control" name="userName" placeholder="Entre votre Login" required="" autofocus="" />
                        <input type="password" class="form-control" name="mdp" placeholder="Votre mot de passe" required=""/>     		  

                        <button class="btn btn-lg btn-primary btn-block"  name="Submit" type="Submit">Connexion</button>  			
                    </form>			
                </div>
            </div>            
            <!-- BODY END-->
        </div>
    </body>
</html>