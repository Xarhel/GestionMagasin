/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Vente.Panier;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author 3137574
 */
@Stateless
public class PanierFacade extends AbstractFacade<Panier> implements PanierFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PanierFacade() {
        super(Panier.class);
    }

 
    
}
