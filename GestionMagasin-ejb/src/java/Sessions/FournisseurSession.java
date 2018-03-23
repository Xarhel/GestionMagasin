/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.BonDeCommande;
import Entites.Autre.Livraison;
import Entites.Personne.AgentDeLivraison;
import Entites.Personne.ChefDeRayon;
import Entites.Personne.Fournisseur;
import facades.AgentDeLivraisonFacadeLocal;
import facades.BonDeCommandeFacadeLocal;
import facades.ChefDeRayonFacadeLocal;
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
    private ChefDeRayonFacadeLocal chefDeRayonFacade;

    @EJB
    private FournisseurFacadeLocal fournisseurFacade;

    @EJB
    private LivraisonFacadeLocal livraisonFacade;

    @EJB
    private BonDeCommandeFacadeLocal bonDeCommandeFacade;

    @EJB
    private AgentDeLivraisonFacadeLocal agentDeLivraisonFacade;

    
   
    
    @Override
    public Livraison creerLivraison(int idBonDeCommande, Date dateDebutLivraison)
    {
        
        BonDeCommande bdc= bonDeCommandeFacade.rechercherBonDeCommandeParId(idBonDeCommande);
        
      Livraison l=  livraisonFacade.creerLivraison(bdc, dateDebutLivraison);
        
      return l;
        
    }
    
    @Override
    public Collection <BonDeCommande> consulterBonDeCommande(long idFournisseur)
    {
        Fournisseur four=fournisseurFacade.rechercherFournisseurParId(idFournisseur);
        Collection <BonDeCommande> resultat= bonDeCommandeFacade.rechercherBonDeCommandeParFournisseur(four);
        return resultat;
        
        
    } 
            
    
    @Override
    public BonDeCommande RechercherBonDeCommandeParDateChefEtFournisseur(int idChefDeRayon, Date dateCreation, int idFournisseur)
    {
        Fournisseur fournisseur= fournisseurFacade.rechercherFournisseurParId(idFournisseur);
        ChefDeRayon cdr= chefDeRayonFacade.rechercherChefDeRayonParId(idFournisseur);
        
        
        BonDeCommande bdc=bonDeCommandeFacade.rechercherBonDeCommandeParFournisseurDateEtChef(fournisseur, dateCreation, cdr);
        return bdc;
    }
            
    
    @Override
    public Collection <Livraison> afficherLivraisonsEnCours (long idF)
    {
        Fournisseur f=fournisseurFacade.rechercherFournisseurParId(idF);
        Collection <Livraison> result = livraisonFacade.afficherLivraisonsEnCours(f);
        
        return result;
        
        
    }
            
            
}
