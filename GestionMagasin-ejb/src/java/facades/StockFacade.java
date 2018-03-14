/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


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
    
    
    public void retirerStockDuRayon(Stock S, int quantite)
    {
        int quantiteAvant=S.getQuantiteStock();
        
        int quantiteApresOperation= quantiteAvant-quantite;

        S.setQuantiteStock(quantiteApresOperation);
        
        
        
    }
    
    public Stock rechercherStock(long idArticle, long idLot, long idRayon)
    {
        Stock result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock AS s WHERE s.lArticleVente.id=:idArticle AND s.laLivraisonLot.id=:idLot AND s.leRayon.id=:idRayon ");
        req.setParameter("idArticle", idArticle);
        req.setParameter("idLot", idLot);
        req.setParameter("idRayon", idRayon);
        
        result =(Stock) req.getSingleResult();
        
        return result;
    }
}


