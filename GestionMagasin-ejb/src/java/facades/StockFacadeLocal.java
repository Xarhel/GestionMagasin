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
import Entites.Vente.ArticleVente;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface StockFacadeLocal {

    void create(Stock stock);

    void edit(Stock stock);

    void remove(Stock stock);

    Stock find(Object id);

    List<Stock> findAll();

    List<Stock> findRange(int[] range);

    int count();

    public Collection<Stock> chercherRayonStockParLibelleArticle(String libelle, Rayon rayon);

    public void retirerStockPerimeRayon(Collection<Stock> stockPerime);

    public Collection<Stock> rechercherLotRayonPerimeParDate(java.util.Date date, Rayon rayon);

    public Collection<Stock> chercherMagasinStockParLibelleArticle(String libelle, Magasin magasin);

    public Collection<Stock> chercherMagasinStockParReferenceArticle(int reference, Magasin magasin);

    public Collection<Stock> chercherStockRayon(Rayon rayon);

    public Stock chercherLotPourVente(Magasin magasin, int reference);

    public Stock rechercherStock(long idArticle, long idLot, long idRayon);

    public void retirerStockDuRayon(Stock S, int quantite);

    public Collection<Stock> chercherStockMagasin(Magasin magasin);

    public void ajouterLotAuStock(LivraisonLot livraisonLot, Rayon rayon, Article article);

    public Collection<Stock> retirerStockVente(Collection<ArticleVente> av);

    public Stock chercherStockParArticleEtRayon(Article article, Rayon rayon);

    Collection chercherMagasinStockParIdArticle(int idArticle, Magasin magasin);
    
}
