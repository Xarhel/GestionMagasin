/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
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
import facades.RayonArticleFacadeLocal;
import facades.RayonFacadeLocal;
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
    private RayonArticleFacadeLocal rayonArticleFacade;

    @EJB
    private RayonFacadeLocal rayonFacade;

    @EJB
    private ArticleFacadeLocal articleFacade1;

    @EJB
    private EmployeFacadeLocal employeFacade1;

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
    
    
    
    @Override
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
    
    
    @Override
    public void annulerPromotion(Article a)
    {
        if(a.isPromotion()==true)
        {
            articleFacade.annulerPromotion(a);
        }
    }
    
    @Override
    public Employe rechercherEmployeParId(int idEmploye)
    {
        Employe resutlat= employeFacade.chercherEmployeParId(idEmploye);
        return resutlat;
    }
    
    @Override
    public void affecterGerantMagasin(GerantMagasin gm, Magasin mag)
    {
       gerantMagasinFacade.affecterGerantMagasin(gm, mag);
    }
    
    @Override
    public void affecterChefDeRayon(ChefDeRayon cdr, Magasin mag, Rayon rayon)
    {
        chefDeRayonFacade.affecterChefDeRayon(cdr, mag, rayon);
    }
    
    @Override
    public void affecterEmployeDeCaisse(EmployeDeCaisse edc, Magasin mag)
    {
        employeDeCaisseFacade.affecterEmployeDeCaisse(edc, mag);
    }
    
    @Override
    public void affecterEmployeRayon(EmployeRayon er, Magasin mag,Rayon rayon)
    {
        employeRayonFacade.affecterEmployeDeRayon(er, mag, rayon);
    }
    
    @Override
    public void affecterAgentLivraison(AgentDeLivraison adl, Magasin magasin)
    {
        agentDeLivraisonFacade.affecterAgentDeLivraison(adl, magasin);
    }
    
    @Override
    public Collection<Article> afficherArticleParLibelle(String libelle)
    {
       Collection<Article> resultat= articleFacade.rechercherArticleParLibelle(libelle);
        
        return resultat;
    }
    
    @Override
    public Article afficherArticleParReference(int reference)
    {
        Article resultat= articleFacade.rechercheArticleParReference(reference);
        return resultat;
    }
    
    @Override
    public void demarrerUnePrommotion (int reference, float prixPromotion) {
    
        Article ar = articleFacade.rechercheArticleParReference(reference);
        articleFacade.modifierPrixArticle(ar, prixPromotion);
        Collection<RayonArticle> articleDansRayons =rayonArticleFacade.chercherRayonArticlesParReference(reference);
        rayonArticleFacade.commencerPromotion(articleDansRayons, prixPromotion);
    }
    
    @Override
    public void cloturerPromotion (int reference){
        Article ar = articleFacade.rechercheArticleParReference(reference);
        Collection<RayonArticle> articleDansRayons =rayonArticleFacade.chercherRayonArticlesParReference(reference);
        articleFacade.annulerPromotion(ar);
        rayonArticleFacade.cloturerPromotion(articleDansRayons);
    }
    
    @Override
    public Collection<Employe> rechercherEmployeParNom(String nom)
    {
        Collection<Employe> result= employeFacade.chercherEmployeParNom(nom);
    
    
        return result;      
        
    }
    
      @Override
    public Article rechercherArticleParId(int id)
    {
       Article result= articleFacade.rechercherArticleParId(id);
    
    
        return result;
        
        
        
        
    }
    
}
