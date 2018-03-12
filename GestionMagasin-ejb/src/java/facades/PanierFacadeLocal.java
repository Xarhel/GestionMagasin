/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Vente.Panier;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface PanierFacadeLocal {

    void create(Panier panier);

    void edit(Panier panier);

    void remove(Panier panier);

    Panier find(Object id);

    List<Panier> findAll();

    List<Panier> findRange(int[] range);

    int count();
    
}
