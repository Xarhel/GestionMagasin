<%-- 
    Document   : menuEmployeRayon
    Created on : 21 mars 2018, 08:46:28
    Author     : 5153218
--%>
<jsp:useBean id="user" scope="session" class="Entites.Personne.Personne"></jsp:useBean>
    
<% String id = (String) session.getAttribute(user.getId().toString());%>
<% String nom = (String) session.getAttribute(user.getNomPersonne());%>
<% String display = (String) session.getAttribute("display");%>
<!-- Static navbar -->

<nav class="navbar navbar-default">
    <div class="container-fluid menu">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=<img src="/images/Mg.jpg" alt="MG"/></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Accueil</a></li>                 
                <li class="dropdown <%=display%>"> </li>      
                        <li><a href="EmployeRayon?action=versConsulterCommande" class="">Consulter commande</a></li>
                        <li><a href="EmployeRayon?action=versConsulterLivraison">Consulter livraison</a></li>
                        <li><a href="EmployeRayon?action=versRetraitArticlePerime" class="">Retrait article</a></li>
                    </ul>
               
                
            <ul class="nav navbar-nav navbar-right">
                <li><a href="EmployeRayon?action=logout">Bonjour! <%=user.getNomPersonne()%>, Déconnexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
<!--/ EmployeRayon  Administrateur?action=versCreerUtilisateur --- >
