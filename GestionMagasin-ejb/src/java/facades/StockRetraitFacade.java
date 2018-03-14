/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Stock;
import Entites.Autre.StockRetrait;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class StockRetraitFacade extends AbstractFacade<StockRetrait> implements StockRetraitFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockRetraitFacade() {
        super(StockRetrait.class);
    }

    @Override
    public void retirerLot(Collection<Stock> stockARetirer, int quantiteRetiree, java.sql.Date dateRetrait) {
        
        for (Stock s: stockARetirer) {
        StockRetrait sr = new StockRetrait();
        sr.setStock(s);
        sr.setDateRetrait(dateRetrait);
        sr.setQuantiteRetrait(quantiteRetiree);
        em.persist(sr);
        }
        
    }
    
    
    
    
    
    
}
