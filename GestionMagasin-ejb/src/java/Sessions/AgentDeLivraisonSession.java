/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.CommandeLot;
import Entites.Autre.Livraison;
import facades.CommandeLotFacadeLocal;
import facades.LivraisonFacadeLocal;
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
    private CommandeLotFacadeLocal commandeLotFacade;

    @EJB
    private LivraisonFacadeLocal livraisonFacade;

    

    @Override
    public void enregistrerLivraison(Date dateReception, int idLivraison)
        
{
    
    Livraison livraison = livraisonFacade.rechercherLivraisonParId(idLivraison);
    
    livraisonFacade.recevoirLivraison(livraison, dateReception);
    
    // Methode pour les livraisons lots
   Collection <CommandeLot> toutLesCommandesLot= commandeLotFacade.rechercherCommandeLotParIdBonDeCommande(livraison.getLeBonDeCommande());
   
    
    // Methode d'ajouter au stock
    
    
    
}
    
    
    
}
