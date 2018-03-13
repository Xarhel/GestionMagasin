/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Enum.TypeLivraison;
import Entites.Vente.PanierInternet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class PanierInternetFacade extends AbstractFacade<PanierInternet> implements PanierInternetFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PanierInternetFacade() {
        super(PanierInternet.class);
    }

    @Override
    public void creerPanierInternet(TypeLivraison TypeLivraison) {
        PanierInternet pi= new PanierInternet();
        pi.setTypeLivraison(TypeLivraison);
        em.persist(pi);
        
    }
    
}
