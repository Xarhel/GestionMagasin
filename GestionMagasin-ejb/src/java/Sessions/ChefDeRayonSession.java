/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.BonDeCommande;
import Entites.Autre.CommandeLot;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import Entites.Enum.CategorieArticle;
import Entites.Lot.Lot;
import Entites.Personne.ChefDeRayon;
import Entites.Personne.Fournisseur;
import facades.ArticleFacadeLocal;
import facades.BonDeCommandeFacadeLocal;
import facades.ChefDeRayonFacadeLocal;
import facades.CommandeLotFacadeLocal;
import facades.FournisseurFacadeLocal;
import facades.LotFacadeLocal;
import facades.RayonArticleFacadeLocal;
import facades.RayonFacadeLocal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
    
        @EJB
    private RayonFacadeLocal rayonFacade;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
        public void ajouterArticleAuRayon (Article a, Rayon r, float prix){

             rayonArticleFacade.ajouterArticleARayon(r, a, prix);}
   
        
        
        @Override
   public void ajouterFournisseur(String raisonSocial, String login, String password, String nom, String prenom)
   {
       
       fournisseurFacade.creerFournisseur(raisonSocial, login, password, nom, prenom);
   }
   
    @Override
   public void ajouterArticle(int referenceArticle, String libelle, CategorieArticle categorie)
           
   {

          articleFacade.creerArticle(referenceArticle, libelle, categorie);
   
   }
   
    @Override
   public Collection<Article> afficherTousLesArticles(){
       Collection<Article> articles;
       articles = articleFacade.afficherTousLesArticles();
       return articles;
   }
   
   // Faire un 
   
    @Override
   public void modifierPrixArticle(RayonArticle ra, float prix)
   {
       if(ra.getLesArticles().isPromotion()==true)
       {
           System.out.println("Erreur, article en promotion");
       }
       else
       {
      
      rayonArticleFacade.modifierPrixRayonArticle(ra, prix);
       }
      
       
       
   }
   
   
    @Override
   public void creerCommandeLot(BonDeCommande commande, float prixAchat, Article lArticle, int quantite)
   {
       
       Lot lot= lotFacade.creerLotGeneral(lArticle, quantite);
    
       commandeLotFacade.creerCommandeLot(lot, commande, prixAchat);
       
       
       
   }
   
    @Override
    public BonDeCommande creerBonDeCommande(int idFournisseur, long idChefDeRayon) {
        Date d = new Date();
       Fournisseur fournisseur= fournisseurFacade.rechercherFournisseurParId(idFournisseur);
       ChefDeRayon cdr= chefDeRayonFacade.rechercherChefDeRayonParId(idChefDeRayon);
       BonDeCommande bdc = bonDeCommandeFacade.creerBonDeCommande(cdr, d, fournisseur);
         return bdc;
        
    }
    
    @Override
    public BonDeCommande chercherBonDeCommandeParId(int id){
    BonDeCommande bdc = bonDeCommandeFacade.rechercherBonDeCommandeParId(id);
    return bdc;}
    
    @Override
        public Article rechercherArticleParId(int id)
    {
       Article result= articleFacade.rechercherArticleParId(id);
    
    
        return result;
        
        
        
        
    }
    @Override
              public Rayon rechercherRayonParId(long id)
    {
       Rayon result= rayonFacade.rechercherRayonParId(id) ;
    
    
        return result;
        
        
        
        
    }
              
    @Override
              public RayonArticle chercherRayonArticleParId(int id){
              RayonArticle ra = rayonArticleFacade.chercherRayonArticleParId(id);
              return ra;}
   
    @Override
    public Collection <RayonArticle> listerRayonArticleParRayon(Rayon r){
    Collection <RayonArticle> ra = rayonArticleFacade.listerRayonArticleParRayon(r);
    return ra;}
    
    @Override
    public Collection<Fournisseur> listerFournisseur (){
    
    Collection<Fournisseur> result;
    result = fournisseurFacade.listerLesFournisseurs();
    return result;}
    
    @Override
    public Collection <BonDeCommande> listerCommandesParRayon (Rayon r){
    Collection<BonDeCommande> commande;
    commande = bonDeCommandeFacade.listerCommandesParRayon(r);
    return commande;}
    
    @Override
    public Fournisseur rechercherFournisseurParId(int id){
    Fournisseur f =fournisseurFacade.rechercherFournisseurParId(id);
    return f;}
    
    
    @Override
        public Collection <CommandeLot> rechercherCommandeLotParIdBonDeCommande (int id){
        
        BonDeCommande bdc = bonDeCommandeFacade.rechercherBonDeCommandeParId(id);
        Collection <CommandeLot> cl=commandeLotFacade.rechercherCommandeLotParIdBonDeCommande(bdc);
        return cl;
        }
        
           
           
}
