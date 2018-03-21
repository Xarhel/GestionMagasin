<%-- 
    Document   : menuDirection
    Created on : 16 mars 2018, 13:02:10
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
            <a class="navbar-brand" href="http://localhost:8080/GestionMagasin-war/Administrateur?action=redirigerMenuDirection">Direction</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="http://localhost:8080/GestionMagasin-war/Administrateur?action=redirigerMenuDirection">Accueil</a></li>                 
                <li class="dropdown <%=display%>">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Direction<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="Administrateur?action=afficherTousEmployesDirection">Liste des employés</a></li>
                        <li><a href="Administrateur?action=versRechercheEmploye">Rechercher un employé</a></li>
                        <li><a href="Administrateur?action=versRechercheArticleParNom" class="">Rechercher un article</a></li>                     
                    </ul>
                </li> 
                
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu?action=logout">Bonjour! <%=user.getNomPersonne()%>, Déconexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
