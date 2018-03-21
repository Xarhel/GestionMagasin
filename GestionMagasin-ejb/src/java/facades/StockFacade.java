/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.LivraisonLot;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Autre.Stock;
import Entites.Enum.CategorieArticle;
import Entites.Vente.ArticleVente;
import java.util.Collection;
import java.util.List;
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
    public Collection<Stock> chercherRayonStockParLibelleArticle(String libelle, Rayon rayon) {
        Collection<Stock> result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock AS s join s.lArticle ar join s.leRayon r WHERE ar.libelle=:libelle AND s.leRayon=:rayon");
        req.setParameter("libelle", libelle);
        req.setParameter("rayon", rayon);
        
        result = req.getResultList();
        
        return result;
    }    
    @Override
       public Collection<Stock> rechercherLotRayonPerimeParDate(java.util.Date date, Rayon rayon) {
        
    Collection<Stock> result;
        CategorieArticle ca;
        ca=CategorieArticle.Alimentaire;
       Query req = getEntityManager().createQuery("SELECT s FROM Stock s join s.lArticle ar join ar.lots l Where l.dateDePeremption<:date and s.leRayon=:rayon and ar.Categorie =:ca");
       req.setParameter ("rayon", rayon);
       req.setParameter ("date", date);
       req.setParameter ("ca", ca);
       result = req.getResultList();   
       return result;
        
    }
    @Override
        public void retirerStockPerimeRayon (Collection<Stock> stockPerime){
            
        for (Stock s:stockPerime)
        {
            
            stockPerime.remove(s);
        }
        
        
        }
        
            @Override
    public Collection<Stock> chercherMagasinStockParLibelleArticle(String libelle, Magasin magasin) {
        Collection<Stock> result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock AS s join s.lArticle ar join s.leRayon r WHERE ar.libelle=:libelle AND  r.leMagasin=:magasin");
        req.setParameter("libelle", libelle);
        req.setParameter("magasin", magasin);
        
        result = req.getResultList();
        
        return result;
    }  
    
                @Override
    public Collection<Stock> chercherMagasinStockParReferenceArticle(int reference, Magasin magasin) {
        Collection<Stock> result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock AS s join s.lArticle ar join s.leRayon r WHERE ar.referenceArticle=:reference AND  r.leMagasin=:magasin");
        req.setParameter("reference", reference);
        req.setParameter("magasin", magasin);
        
        result = req.getResultList();
        
        return result;
    }   
    
    @Override
        public Collection<Stock> chercherStockMagasin(Magasin magasin) {
        Collection<Stock> result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock AS s join s.lArticle ar join s.leRayon r WHERE r.leMagasin=:magasin");
        req.setParameter("magasin", magasin);
        
        result = req.getResultList();
        
        return result;
    }  
    
    @Override
    public Collection<Stock> chercherStockRayon (Rayon rayon) {
        Collection<Stock> result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock AS s join s.lArticle ar join s.leRayon r WHERE s.leRayon=:rayon");
        req.setParameter("rayon", rayon);
        
        result = req.getResultList();
        
        return result;
    }      
    
        @Override
    public Stock chercherLotPourVente (Magasin magasin,int reference) {
        Stock result;
    
        Query req = getEntityManager().createQuery("SELECT s FROM Stock as s join s.lArticle ar join s.leRayon r where ar.referenceArticle=:reference AND r.leMagasin=:magasin");
        req.setParameter("magasin", magasin);
        req.setParameter("reference", reference);
        List<Stock> stocks = req.getResultList();
        
        result =stocks.get(0);
        
        return result;
    }     
    
    
    @Override
    public void retirerStockDuRayon(Stock S, int quantite)
    {
        int quantiteAvant=S.getQuantiteStock();
        
        int quantiteApresOperation= quantiteAvant-quantite;

        S.setQuantiteStock(quantiteApresOperation);
        
        
        
    }
    
    @Override
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
    
    @Override
    public void ajouterLotAuStock (LivraisonLot livraisonLot, Rayon rayon, Article article){
        
        int quantite = livraisonLot.getQuantiteAcceptee();
        Stock stock = new Stock();
        
        stock.setLaLivraisonLot(livraisonLot);
        stock.setLeRayon(rayon);
        stock.setlArticle(article);
        stock.setQuantiteStock(quantite);
        
        em.persist(quantite);
       
        
        }

    
    @Override
    public Collection <Stock> retirerStockVente(Collection<ArticleVente> av)
    {
        Collection <Stock> listeStock=null;
        for (ArticleVente a: av){
        int quantiteVendu=a.getQuantite();

        while (quantiteVendu!=0)
                {       Article article= a.getStock().getlArticle();
            Rayon rayon= a.getStock().getLeRayon();
            
     Query req = getEntityManager().createQuery("select s from Stock s WHERE s.lArticle=:article AND s.leRayon=:rayon");
     req.setParameter("article", article);
     req.setParameter("rayon", rayon);
     
     List <Stock> cs = req.getResultList();
     Stock s= cs.get(0);
        int quantiteStock = s.getQuantiteStock();
        if (quantiteVendu==quantiteStock){
        quantiteVendu=quantiteVendu-quantiteStock;
        em.remove(s);
        }
        else if(quantiteVendu<quantiteStock){
        quantiteStock=quantiteStock-quantiteVendu;
        s.setQuantiteStock(quantiteStock);
        em.merge(s);
        quantiteVendu=0;}
        else if (quantiteVendu>quantiteStock){
        if (quantiteVendu==quantiteStock){
        quantiteVendu=quantiteVendu-quantiteStock;
        em.remove(s);
                }
 }}}
        
        
        
        return listeStock;
    }
    
    @Override
    public Stock chercherStockParArticleEtRayon (Article article, Rayon rayon){
    
         Query req = getEntityManager().createQuery("select s from Stock s WHERE s.lArticle=:article AND s.leRayon=:rayon");
     req.setParameter("article", article);
     req.setParameter("rayon", rayon);
     
     List <Stock> cs = req.getResultList();
     Stock s= cs.get(0);
    return s;}
            
}


