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
import facades.AgentDeLivraisonFacadeLocal;
import facades.ArticleFacadeLocal;
import facades.ChefDeRayonFacadeLocal;
import facades.EmployeDeCaisseFacadeLocal;
import facades.EmployeFacadeLocal;
import facades.EmployeRayonFacadeLocal;
import facades.GerantMagasinFacadeLocal;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6137220
 */
@Stateless
public class Direction implements DirectionLocal {

    @EJB
    private AgentDeLivraisonFacadeLocal agentDeLivraisonFacade;

    @EJB
    private EmployeRayonFacadeLocal employeRayonFacade;

    @EJB
    private EmployeDeCaisseFacadeLocal employeDeCaisseFacade;

    @EJB
    private ChefDeRayonFacadeLocal chefDeRayonFacade;

    @EJB
    private GerantMagasinFacadeLocal gerantMagasinFacade;

    @EJB
    private EmployeFacadeLocal employeFacade;

    @EJB
    private ArticleFacadeLocal articleFacade;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
    public void ajouterPromotion(Article a, float prix)
    {
        if(a.isPromotion()==true && a.getPrixPromotion()==prix)
        {
            System.out.println("Erreur, promotion déjà en cours");
            
        }
        else
        {
            articleFacade.modifierPrixArticle(a, prix);
            
        }
        
    }
    
    
    public void annulerPromotion(Article a)
    {
        if(a.isPromotion()==true)
        {
            articleFacade.annulerPromotion(a);
        }
    }
    
    public Employe rechercherEmployeParId(int idEmploye)
    {
        Employe resutlat= employeFacade.chercherEmployeParId(idEmploye);
        return resutlat;
    }
    
    public void affecterGerantMagasin(GerantMagasin gm, Magasin mag)
    {
       gerantMagasinFacade.affecterGerantMagasin(gm, mag);
    }
    
    public void affecterChefDeRayon(ChefDeRayon cdr, Magasin mag, Rayon rayon)
    {
        chefDeRayonFacade.affecterChefDeRayon(cdr, mag, rayon);
    }
    
    public void affecterEmployeDeCaisse(EmployeDeCaisse edc, Magasin mag)
    {
        employeDeCaisseFacade.affecterEmployeDeCaisse(edc, mag);
    }
    
    public void affecterEmployeRayon(EmployeRayon er, Magasin mag,Rayon rayon)
    {
        employeRayonFacade.affecterEmployeDeRayon(er, mag, rayon);
    }
    
    public void affecterAgentLivraison(AgentDeLivraison adl, Magasin magasin)
    {
        agentDeLivraisonFacade.affecterAgentDeLivraison(adl, magasin);
    }
    
    public Collection<Article> afficherArticleParLibelle(String libelle)
    {
       Collection<Article> resultat= articleFacade.rechercherArticleParLibelle(libelle);
        
        return resultat;
    }
    
    public Article afficherArticleParReference(int reference)
    {
        Article resultat= articleFacade.rechercheArticleParReference(reference);
        return resultat;
    }
    
}
