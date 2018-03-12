/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Vente.PanierCaisse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface PanierCaisseFacadeLocal {

    void create(PanierCaisse panierCaisse);

    void edit(PanierCaisse panierCaisse);

    void remove(PanierCaisse panierCaisse);

    PanierCaisse find(Object id);

    List<PanierCaisse> findAll();

    List<PanierCaisse> findRange(int[] range);

    int count();
    
}
