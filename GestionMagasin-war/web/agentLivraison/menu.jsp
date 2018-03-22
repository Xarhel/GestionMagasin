<%-- 
    Document   : menuChefRayon
    Created on : 20 mars 2018, 17:10:42
    Author     : jules
--%>


<% String id = (String) session.getAttribute("id");%>
<% String nom = (String) session.getAttribute("nom");%>
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
                <li class="dropdown <%=display%>">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Direction<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="creerLivraison.jsp" class="">Créer livraison</a></li>
                        <li><a href="AgentLivraison?action=versListeLivraison">Liste livraison</a></li>
                        <li><a href=".jsp" class=""></a></li>

                    </ul>
                </li> 
                
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu?action=logout">Bonjour! <%=nom%>, Déconnexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>