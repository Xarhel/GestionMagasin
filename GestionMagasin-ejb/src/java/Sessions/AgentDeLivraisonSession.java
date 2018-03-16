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
import Entites.Lot.Lot;
import Entites.Personne.ChefDeRayon;
import facades.CommandeLotFacadeLocal;
import facades.LivraisonFacadeLocal;
import facades.LivraisonLotFacadeLocal;
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
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private StockFacadeLocal stockFacade;

    @EJB
    private CommandeLotFacadeLocal commandeLotFacade;

    @EJB
    private LivraisonFacadeLocal livraisonFacade;
    
    @EJB
    private LivraisonLotFacadeLocal livraisonLotFacade;
    
    
    
    

    
    

    @Override
    public void enregistrerLivraison(Date dateReception, int idLivraison)
        
{
    
    Livraison livraison = livraisonFacade.rechercherLivraisonParId(idLivraison);
    
    livraisonFacade.recevoirLivraison(livraison, dateReception);
    
    // Methode pour les livraisons lots
    
}
    
    @Override
    public Collection <CommandeLot> AfficherCommandeLots(int idLivraison)
    {
        Livraison livraison= livraisonFacade.rechercherLivraisonParId(idLivraison);
        Collection <CommandeLot> toutLesCommandesLot= commandeLotFacade.rechercherCommandeLotParIdBonDeCommande(livraison.getLeBonDeCommande());
   
    
    // Methode d'ajouter au stock
    return toutLesCommandesLot;
    }
    
    
    @Override
    public void enregistrerLivraisonLots(int idLivraison, int idCommandeLot, int quantiteAcceptee, int quantiteExpediee, int quantiteLivree)
    {
                
        Livraison livraison=livraisonFacade.rechercherLivraisonParId(idLivraison);
        CommandeLot commandeLot= commandeLotFacade.rechercherCommandeLotParId(idLivraison);
        Lot lotLivre = commandeLot.getLeLot();
        Article article= lotLivre.getlArticle();
        BonDeCommande bdc = commandeLot.getLeBonDeCommande();
        ChefDeRayon cdr = bdc.getLeChefDeRayon();
        Rayon rayon = cdr.getLeRayon();
        
        LivraisonLot livraisonLot = livraisonLotFacade.creerLivraisonLot(lotLivre, livraison, quantiteExpediee, quantiteAcceptee, quantiteLivree);
        stockFacade.ajouterLotAuStock(livraisonLot, rayon, article);
        
    }
    
    @Override
    public Collection<Livraison> listerLivraisonEnCours (int idMagasin){
        
        
        
        Magasin m = magasinFacade.rechercherMagasinParId(idMagasin);
        Collection<Livraison> result=livraisonFacade.afficherLivraisonsEnCours(m);
        return result;
    }

}
    
    

