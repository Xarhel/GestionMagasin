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
            <a class="navbar-brand" href="Menu">GM</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Accueil</a></li>                 
                <li class="dropdown <%=display%>"></li> 
                    
                    
                        <li><a href="ChefDeRayon?action=versAjouterArticle" class="">Ajouter article</a></li>
                        <li><a href="ChefDeRayon?action=listerLesRayonArticle">Liste des Articles du rayon</a></li>
                        <li><a href="ChefDeRayon?action=listerFournisseur" class="">Gestion des fournisseurs</a></li>
                        <li><a href="ChefDeRayon?action=listerCommande" class="">Créer commande</a></li>
                        <li><a href="ChefDeRayon?action=afficherTousLesArticles" class="">Liste des articles</a></li>
                        <li><a href="modifierPrix.jsp" class="">Modifier le prix</a></li>
                        
                    </ul>
                
                
            <ul class="nav navbar-nav navbar-right">
                <li><a href="ChefDeRayon?action=logout">Bonjour! <%=user.getNomPersonne()%>, Déconexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
