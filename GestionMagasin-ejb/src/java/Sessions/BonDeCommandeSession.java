/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.BonDeCommande;
import facades.BonDeCommandeFacadeLocal;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 5153218
 */
@Stateless
public class BonDeCommandeSession implements BonDeCommandeSessionLocal {

    @EJB
    private BonDeCommandeFacadeLocal bonDeCommandeFacade;
    
    
    @Override
    public void creerBonDeCommande(Date dateCommande, int idFournisseur, int idArticle) {
        bonDeCommandeFacade.creerBonDeCommande(dateCommande);
    }
    
    
    @Override
    public Collection<BonDeCommande> RechercherBonDeCommande(Date dateCommande, int idFournisseur, int idArticle) 
    {
        Collection<BonDeCommande> resultat=bonDeCommandeFacade.rechercherCommande(dateCommande, idFournisseur, idArticle);
        return resultat;
    }
    
    @Override
    public Collection<BonDeCommande> rechercherCommandeParArticle (int idArticle) 
    {
        Collection<BonDeCommande> resultat=bonDeCommandeFacade.rechercherCommandeParArticle(idArticle);
        return resultat;
    }
    @Override
    public Collection<BonDeCommande> AfficherCommande () 
    {
        Collection<BonDeCommande> resultat=bonDeCommandeFacade.getBonDeCommandes();
        return resultat;
    }
   
}
