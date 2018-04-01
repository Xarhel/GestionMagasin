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
            <a class="navbar-brand" href="http://localhost:8080/GestionMagasin-war/AgentLivraison"/>Agent de livraison</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="http://localhost:8080/GestionMagasin-war/AgentLivraison">Accueil</a></li>                 
                <li class="dropdown <%=display%>">
                        <li><a href="AgentLivraison?action=versListeLivraison">Liste livraison</a></li>
                        <li><a href=".jsp" class=""></a></li>

                    
                </li> 
                </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="AgentLivraison?action=logout">Bonjour! <%=user.getNomPersonne()%>, Déconnexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
