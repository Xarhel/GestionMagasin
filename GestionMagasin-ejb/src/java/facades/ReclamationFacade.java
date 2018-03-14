/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Livraison;
import Entites.Autre.Reclamation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class ReclamationFacade extends AbstractFacade<Reclamation> implements ReclamationFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReclamationFacade() {
        super(Reclamation.class);
    }
    
    
    
    @Override
    public void creerReclamation(Livraison l, String motif)
    {
       Reclamation r=new Reclamation();
       r.setLivraison(l);
       r.setMotifReclamationGeneral(motif);
       em.persist(r);
       
       
        
    }
}
