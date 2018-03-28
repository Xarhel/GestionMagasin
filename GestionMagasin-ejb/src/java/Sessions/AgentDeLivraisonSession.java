/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.BonDeCommande;
import Entites.Autre.CommandeLot;
import Entites.Autre.Livraison;
import Entites.Autre.LivraisonLot;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.CategorieArticle;
import Entites.Lot.Lot;
import Entites.Personne.ChefDeRayon;
import facades.BonDeCommandeFacadeLocal;
import facades.CommandeLotFacadeLocal;
import facades.LivraisonFacadeLocal;
import facades.LivraisonLotFacadeLocal;
import facades.LotFacadeLocal;
import facades.MagasinFacadeLocal;
import facades.StockFacadeLocal;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6137220
 */
@Stateless
public class AgentDeLivraisonSession implements AgentDeLivraisonSessionLocal {

    @EJB
    private LotFacadeLocal lotFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private StockFacadeLocal stockFacade;

    @EJB
    private CommandeLotFacadeLocal commandeLotFacade;

    @EJB
    private LivraisonFacadeLocal livraisonFacade;
    
    @EJB
    private LivraisonLotFacadeLocal livraisonLotFacade;
    
    
    @EJB
    private BonDeCommandeFacadeLocal bonDeCommandeFacade;    
    
    
    

    
    

    @Override
    public void enregistrerLivraison(int idLivraison)
        
{
    Date dateReception = new Date();
    Livraison livraison = livraisonFacade.rechercherLivraisonParId(idLivraison);
    
    livraisonFacade.recevoirLivraison(livraison, dateReception);
    
    // Methode pour les livraisons lots
    
}
    
    /**
     *
     * @param idCommande
     * @return
     */
    @Override
    public Collection <CommandeLot> AfficherCommandeLotsParIdCommande(int idCommande){
         
            BonDeCommande bc = bonDeCommandeFacade.rechercherBonDeCommandeParId(idCommande);
        Collection <CommandeLot> cl= commandeLotFacade.rechercherCommandeLotParIdBonDeCommande(bc);
        return cl; }
    
    @Override
    public Collection <CommandeLot> AfficherCommandeLots(int idLivraison)
    {
        Livraison livraison= livraisonFacade.rechercherLivraisonParId(idLivraison);
        Collection <CommandeLot> toutLesCommandesLot= commandeLotFacade.rechercherCommandeLotParIdBonDeCommande(livraison.getLeBonDeCommande());
   
    
    // Methode d'ajouter au stock
    return toutLesCommandesLot;
    }
    
    
    @Override
    public void enregistrerLivraisonLots(int idLivraison, int idCommandeLot, int quantiteAcceptee, int quantiteExpediee, int quantiteLivree, Date date, String taille, int duree)
    {
                
        Livraison livraison=livraisonFacade.rechercherLivraisonParId(idLivraison);
        CommandeLot commandeLot= commandeLotFacade.rechercherCommandeLotParId(idCommandeLot);
        Lot lotLivre = commandeLot.getLeLot();
        Article article= lotLivre.getlArticle();
        BonDeCommande bdc = commandeLot.getLeBonDeCommande();
        ChefDeRayon cdr = bdc.getLeChefDeRayon();
        Rayon rayon = cdr.getLeRayon();
        LivraisonLot livraisonLot = new LivraisonLot();
        
        if (article.getCategorie()==CategorieArticle.Général)
                {livraisonLot = livraisonLotFacade.creerLivraisonLot(lotLivre, livraison, quantiteExpediee, quantiteAcceptee, quantiteLivree);}
        if (article.getCategorie()==CategorieArticle.Alimentaire)
                {livraisonLot = livraisonLotFacade.creerLivraisonLot(lotLivre, livraison, quantiteExpediee, quantiteAcceptee, quantiteLivree);
                lotFacade.ajouterDatePeremption(lotLivre, date);}
        if (article.getCategorie()==CategorieArticle.Vêtements)
                {livraisonLot = livraisonLotFacade.creerLivraisonLot(lotLivre, livraison, quantiteExpediee, quantiteAcceptee, quantiteLivree);
                lotFacade.ajouterTaille(lotLivre, taille);}
        if (article.getCategorie()==CategorieArticle.Electroménager)
                {livraisonLot = livraisonLotFacade.creerLivraisonLot(lotLivre, livraison, quantiteExpediee, quantiteAcceptee, quantiteLivree);
                lotFacade.ajouterDureeGarantie(lotLivre, duree);}        
        stockFacade.ajouterLotAuStock(livraisonLot, rayon, article);
        
    }
    
    @Override
    public Collection<Livraison> listerLivraisonEnCours (long idMagasin){
        
        
        
        Magasin m = magasinFacade.rechercherMagasinParId(idMagasin);
        Collection<Livraison> result=livraisonFacade.afficherLivraisonsEnCours(m);
        return result;
    }

}
    
    

