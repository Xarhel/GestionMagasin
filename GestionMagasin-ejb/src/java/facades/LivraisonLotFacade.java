/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.CommandeLot;
import Entites.Autre.Livraison;
import Entites.Autre.LivraisonLot;
import Entites.Lot.Lot;
import java.util.Collection;
import java.util.Iterator;
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
    
    
    
    public void creerLivraisonLots(Collection <CommandeLot> listeCommandeLot, Livraison livraison)
    {
        
        
        // Non terminé, A voir comment on s'organise (Max)
        Iterator it=listeCommandeLot.iterator();
        
        livraison.getId();
        
        while(it.hasNext())
        {
            CommandeLot lotActuel=(CommandeLot)it.next();
            Lot lotAAssocier= lotActuel.getLeLot();
            
            
            
            
            
            
        }
        
        
        
        
    }
}
