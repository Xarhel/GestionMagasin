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
import javax.persistence.Query;

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
    
    
    
    
    
    
    public void ajouterStockRetrait(StockRetrait sr,int quantite)
    {
        sr.setQuantiteRetrait(quantite+sr.getQuantiteRetrait());
    }
    
    public StockRetrait rechercherStockRetraitParIdStock(long idStock)
    {
        StockRetrait result;
    
        Query req = getEntityManager().createQuery("SELECT sr FROM StockRetrait AS sr WHERE sr.stock.id=:idStock ");
        req.setParameter("idStock", idStock);
        
        
        result =(StockRetrait) req.getSingleResult();
        
        return result;
    }
    
}
