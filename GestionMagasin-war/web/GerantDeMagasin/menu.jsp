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
            <a class="navbar-brand" href="http://localhost:8080/GestionMagasin-war/GerantMagasin"/>Gérant de magasin</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="http://localhost:8080/GestionMagasin-war/GerantMagasin">Accueil</a></li>                 
                <li class="dropdown <%=display%>"></li>
                    
                    
                        <li><a href="creerRayon.jsp" class="">Créer rayon</a></li>
                        <li><a href="listeCommande.jsp">Liste des commandes</a></li>
                        <li><a href="listeLivraison.jsp" class="">Liste des livraisons</a></li>
                        <li><a href="rechercherCommande.jsp">Recherher de commandes</a></li>
                        <li><a href="rechercherLivraison.jsp" class="">Rechercher de livraisons</a></li>
                   
          
                
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu?action=logout">Bonjour! <%=user.getNomPersonne()%>, Déconexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
