/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Personne.AgentDeLivraison;
import Entites.Personne.ChefDeRayon;
import Entites.Personne.Employe;
import Entites.Personne.EmployeDeCaisse;
import Entites.Personne.EmployeRayon;
import Entites.Personne.GerantMagasin;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface DirectionLocal {

    public void ajouterPromotion(Article a, float prix);

    public void annulerPromotion(Article a);

    public Employe rechercherEmployeParId(int idEmploye);

    public void affecterGerantMagasin(GerantMagasin gm, Magasin mag);



    public void affecterEmployeDeCaisse(EmployeDeCaisse edc, Magasin mag);

   

    public void affecterAgentLivraison(AgentDeLivraison adl, Magasin magasin);

    public Collection<Article> afficherArticleParLibelle(String libelle);

    public Article afficherArticleParReference(int reference);
    
     
      
      public void demarrerUnePrommotion (int reference, float prixPromotion);
      
      public void cloturerPromotion (int reference);

    public Collection<Employe> rechercherEmployeParNom(String nom);

    public Article rechercherArticleParId(int id);
}


