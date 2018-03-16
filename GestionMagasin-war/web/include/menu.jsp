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
                <li><a href="index.jsp">Accueil</a></li>                 
                <li class="dropdown <%=display%>">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administrateur<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="creerEmploye.jsp" class="">Créer un employé</a></li>
                        <li><a href="creerMagasin.jsp" class="">Créer un magasin</a></li>
                        <li><a href="Administrateur?action=afficherTousMagasins" class="">Liste des magasins</a></li>
                        <li><a href="rechercherMagasinParId.jsp" class="">Liste des magasins par Id</a></li>
                        <li><a href="rechercherMagasinParNom.jsp" class="">Liste des magasins par nom</a></li>
                        <li><a href="creerRayon.jsp" class="">Créer un rayon</a></li>
                        <li><a href="Menu?action=rayons" class="">Créer un employé</a></li>
                        <li><a href="chercherRayonParNomParMagasin.jsp" class="">Liste des rayons par nom</a></li>
                        <li><a href="listeDeRayonParMagasin.jsp" class="">Liste des rayons par magasin</a></li>
                        <li><a href="supprimerUtilisateur.jsp" class="">Supprimer un utilisateur</a></li>
                        <li><a href="Administrateur?action=afficherTousEmployes" class="">Afficher tous les employés</a></li>
                    </ul>
                </li> 
                
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu?action=logout">Bonjour! <%=nom%>, Déconexion <span class="glyphicon glyphicon-log-out"></span></a></li>                    
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>