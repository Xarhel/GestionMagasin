/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Rayon;
import Entites.Autre.Stock;
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

    public Stock chercherRayonStockParLibelleArticle(String libelle, Rayon rayon);
    
}
