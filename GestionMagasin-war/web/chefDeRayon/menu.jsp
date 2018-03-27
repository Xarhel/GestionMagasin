<%-- 
    Document   : menuChefRayon
    Created on : 20 mars 2018, 17:10:42
    Author     : jules
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
            <a class="navbar-brand" href="http://localhost:8080/GestionMagasin-war/ChefDeRayon">Chef de rayon</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="http://localhost:8080/GestionMagasin-war/ChefDeRayon">Accueil</a></li>                 
                <li class="dropdown <%=display%>"></li> 
                    
                    
                <li class="dropdown"><a class="dropdown-toggle" data-toggle ="dropdown" href="#">Gestion des Article
                        <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                        <li><a href="ChefDeRayon?action=afficherTousLesArticles" class="">Liste des articles</a></li>                        
                        <li><a href="ChefDeRayon?action=listerLesRayonArticle">Liste des Articles du rayon</a></li> </ul></li>
                        <li><a href="ChefDeRayon?action=listerFournisseur" class="">Gestion des fournisseurs</a></li>
                        <li><a href="ChefDeRayon?action=listerCommande" class="">Gestion des Commandes</a></li>
                        
                    </ul>
                
                
            <ul class="nav navbar-nav navbar-right">
                <li><a href="ChefDeRayon?action=logout">Bonjour! <%=user.getNomPersonne()%>, Déconexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
