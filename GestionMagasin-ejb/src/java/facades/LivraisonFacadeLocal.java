/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Livraison;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface LivraisonFacadeLocal {

    void create(Livraison livraison);

    void edit(Livraison livraison);

    void remove(Livraison livraison);

    Livraison find(Object id);

    List<Livraison> findAll();

    List<Livraison> findRange(int[] range);

    int count();
    
}
