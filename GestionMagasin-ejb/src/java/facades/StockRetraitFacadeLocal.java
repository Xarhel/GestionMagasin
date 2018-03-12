/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.StockRetrait;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface StockRetraitFacadeLocal {

    void create(StockRetrait stockRetrait);

    void edit(StockRetrait stockRetrait);

    void remove(StockRetrait stockRetrait);

    StockRetrait find(Object id);

    List<StockRetrait> findAll();

    List<StockRetrait> findRange(int[] range);

    int count();
    
}