/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Livraison;
import Entites.Autre.LivraisonLot;
import Entites.Lot.Lot;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class LivraisonLotFacade extends AbstractFacade<LivraisonLot> implements LivraisonLotFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivraisonLotFacade() {
        super(LivraisonLot.class);
    }
    
    
   /* 
    @Override
    public void creerLivraisonLots(Collection <CommandeLot> listeCommandeLot, Livraison livraison)
    {
        
        
         // Non terminé, A voir comment on s'organise (Max)
        Iterator it=listeCommandeLot.iterator();
        
        livraison.getId();
        
        while(it.hasNext())
        {
            CommandeLot lotActuel=(CommandeLot)it.next();
            Lot lotAAssocier= lotActuel.getLeLot();
            int quantiteExpedie=lotActuel.getQuantite();
            
            LivraisonLot livraisonlots=new LivraisonLot();
            
            livraisonlots.setLaLivraison(livraison);
            livraisonlots.setLeLot(lotAAssocier);
            livraisonlots.setQuantiteAcceptee(quantiteExpedie);
            livraisonlots.setQuantiteExpediee(quantiteExpedie);
            livraisonlots.setQuantiteLivree(quantiteExpedie);
            
            em.persist(livraisonlots);
            
            
        } }
*/            
        
        
    @Override
        public LivraisonLot creerLivraisonLot(Lot lot, Livraison livraison, int quantiteExpediee, int quantiteAcceptee, int quantiteLivree)
        {
            LivraisonLot livraisonLot= new LivraisonLot();
            
            livraisonLot.setLaLivraison(livraison);
            livraisonLot.setQuantiteAcceptee(quantiteAcceptee);
            livraisonLot.setLeLot(lot);
            livraisonLot.setQuantiteExpediee(quantiteExpediee);
            livraisonLot.setQuantiteLivree(quantiteLivree);
            
            
            em.persist(livraisonLot);
            return livraisonLot;
            
            
        }
        
        
    }

