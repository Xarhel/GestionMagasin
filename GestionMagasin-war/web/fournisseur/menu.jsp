<%-- 
    Document   : menuEmployeRayon
    Created on : 21 mars 2018, 08:46:28
    Author     : 5153218
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
                <li class="dropdown <%=display%>"></li>
                    
                    
                        <li><a href="FournisseurServlet?action=versSaisirLivraison" class="saisir">Saisir Livraison</a></li>
                        <li><a href="FournisseurServlet?action=versListeLivraison">Liste des livraisons</a></li>
                        <li><a href=".jsp" class=""></a></li>
                    </ul>
                 
                
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Fournisseur?action=logout">Bonjour! <%=nom%>, Déconexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
