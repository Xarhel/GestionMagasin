/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.Rayon;
import Entites.Autre.Stock;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 3137574
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> implements StockFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }
    @Override
    public Article chercherRayonStockParLibelleArticle(String libelle, Rayon rayon) {
        Stock result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock s join as article WHERE   r.=: libelle AND ra.lesRayons =: rayon");
        req.setParameter("libelle", libelle);
        req.setParameter("rayon", rayon);
        
        result = (Stock) req.getSingleResult();
        
        return result;
    }    
}
