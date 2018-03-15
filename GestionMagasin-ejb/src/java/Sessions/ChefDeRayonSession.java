/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.BonDeCommande;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import Entites.Lot.Lot;
import Entites.Personne.ChefDeRayon;
import Entites.Personne.Fournisseur;
import facades.ArticleFacadeLocal;
import facades.BonDeCommandeFacadeLocal;
import facades.ChefDeRayonFacadeLocal;
import facades.CommandeLotFacadeLocal;
import facades.FournisseurFacade;
import facades.FournisseurFacadeLocal;
import facades.LotFacadeLocal;
import facades.RayonArticleFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6137220
 */
@Stateless
public class ChefDeRayonSession implements ChefDeRayonSessionLocal {

    @EJB
    private ChefDeRayonFacadeLocal chefDeRayonFacade;

    @EJB
    private BonDeCommandeFacadeLocal bonDeCommandeFacade;

    @EJB
    private CommandeLotFacadeLocal commandeLotFacade;

    @EJB
    private LotFacadeLocal lotFacade;

    @EJB
    private RayonArticleFacadeLocal rayonArticleFacade;

    @EJB
    private ArticleFacadeLocal articleFacade;

    @EJB
    private FournisseurFacadeLocal fournisseurFacade;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
   public void ajouterFournisseur(String raisonSocial, String login, String password)
   {
       fournisseurFacade.creerFournisseur(raisonSocial, login, password);
   }
   
    @Override
   public void ajouterArticle(int referenceArticle, String libelle, int codeBarre, boolean promotion, float prixPromotion)
           
   {
      Article testExistant= articleFacade.rechercheArticleParReference(referenceArticle);
      if(testExistant.getReferenceArticle()==referenceArticle)
      {
          System.out.println("Erreur, article déjà existant");
      }
      else
      {
          articleFacade.creerArticle(referenceArticle, libelle, codeBarre, promotion, prixPromotion);
      }
   }
   
   // Faire un 
   
    @Override
   public void modifierPrixArticle(Rayon r, Article a, float prix)
   {
       if(a.isPromotion()==true)
       {
           System.out.println("Erreur, article en promotion");
       }
       else
       {
           RayonArticle ra= rayonArticleFacade.rechercherRayonArticle(r, a);
      
      rayonArticleFacade.modifierPrix(ra, prix);
       }
      
       
       
   }
   
   
    @Override
   public void creerCommandeLot(BonDeCommande commande, float prixAchat, Article lArticle, int quantite)
   {
       
       
       Lot lot= lotFacade.creerLot(lArticle, quantite);
       commandeLotFacade.creerCommandeLot(lot, commande, prixAchat);
       
       
       
   }
   
    @Override
    public void creerBonDeCommande(Date dateCommande, int idFournisseur, int idChefDeRayon) {
       Fournisseur fournisseur= fournisseurFacade.rechercherFournisseurParId(idChefDeRayon);
       ChefDeRayon cdr= chefDeRayonFacade.rechercherChefDeRayonParId(idChefDeRayon);
       bonDeCommandeFacade.creerBonDeCommande(cdr, dateCommande, fournisseur);
        
        
    }
           
           
           
}
