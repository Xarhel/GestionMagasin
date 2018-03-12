/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Vente.Planning;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface PlanningFacadeLocal {

    void create(Planning planning);

    void edit(Planning planning);

    void remove(Planning planning);

    Planning find(Object id);

    List<Planning> findAll();

    List<Planning> findRange(int[] range);

    int count();
    
}
