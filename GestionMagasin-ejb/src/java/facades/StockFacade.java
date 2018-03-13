/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.Rayon;
import Entites.Autre.Stock;
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
    public Stock chercherRayonStockParLibelleArticle(String libelle, Rayon rayon) {
        Stock result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock AS s join s.lArticle join s.leRayon WHERE s.lArticle:= libelle AND s.leRayon := rayon");
        req.setParameter("libelle", libelle);
        req.setParameter("rayon", rayon);
        
        result = (Stock) req.getSingleResult();
        
        return result;
    }    
        public Collection<Stock> rechercherLotRayonPerimeParDate(java.util.Date date) {
        
    Collection<Stock> result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock s inner join s.lArticle.lots. WHERE ");
        req.setParameter("libelle", libelle);
        
        result = req.getResultList();
        
        return result;
        
    }
        public retirerStockPerimeRayon (Collection<Stock> stockPerime){
            
        for (int i=0 ; i< stockPerime.size(); i++)
        {
            
            em.remove();
        }
        }
    
}
