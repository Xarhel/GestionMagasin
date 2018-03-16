/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.BonDeCommande;
import Entites.Autre.Livraison;
import Entites.Personne.AgentDeLivraison;
import Entites.Personne.Fournisseur;
import facades.AgentDeLivraisonFacadeLocal;
import facades.BonDeCommandeFacadeLocal;
import facades.FournisseurFacadeLocal;
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
public class FournisseurSession implements FournisseurSessionLocal {

    @EJB
    private FournisseurFacadeLocal fournisseurFacade;

    @EJB
    private LivraisonFacadeLocal livraisonFacade;

    @EJB
    private BonDeCommandeFacadeLocal bonDeCommandeFacade;

    @EJB
    private AgentDeLivraisonFacadeLocal agentDeLivraisonFacade;

    
   
    
    @Override
    public void creerLivraison(int idAgentDeLivraison, int idBonDeCommande, Date dateDebutLivraison)
    {
        AgentDeLivraison adl= agentDeLivraisonFacade.rechercherAgentParIdEmploye(idAgentDeLivraison);
        BonDeCommande bdc= bonDeCommandeFacade.rechercherBonDeCommandeParId(idBonDeCommande);
        
        livraisonFacade.creerLivraison(bdc, adl, dateDebutLivraison);
        
        
    }
    
    @Override
    public Collection <BonDeCommande> consulterBonDeCommande(int idFournisseur)
    {
        Fournisseur four=fournisseurFacade.rechercherFournisseurParId(idFournisseur);
        Collection <BonDeCommande> resultat= bonDeCommandeFacade.rechercherBonDeCommandeParFournisseur(four);
        return resultat;
        
        
    } 
            
            
            
            
}
