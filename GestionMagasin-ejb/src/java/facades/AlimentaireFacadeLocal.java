/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Lot.Alimentaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface AlimentaireFacadeLocal {

    void create(Alimentaire alimentaire);

    void edit(Alimentaire alimentaire);

    void remove(Alimentaire alimentaire);

    Alimentaire find(Object id);

    List<Alimentaire> findAll();

    List<Alimentaire> findRange(int[] range);

    int count();
    
}
