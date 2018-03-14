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
            <a class="navbar-brand" href="Menu">GM</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="Menu">Accueil</a></li>                 
                <li class="dropdown <%=display%>">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administrateur<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="creerEmploye.jsp" class="">Cr�er un employ�</a></li>
                        <li><a href="Menu?action=employes">Tous les employes</a></li>
                        <li><a href="creerMagazin.jsp" class="">Cr�er un magasin</a></li>
                        <li><a href="modifierMagasin.jsp" class="">Modifier un magasin</a></li>
                        <li><a href=".jsp" class="">Cr�er un employ�</a></li>
                        <li><a href=".jsp" class="">Cr�er un employ�</a></li> 
                    </ul>
                </li> 
                
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu?action=logout">Bonjour! <%=nom%>, D�conexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>