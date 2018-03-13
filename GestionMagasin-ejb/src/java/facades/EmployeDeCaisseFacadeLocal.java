/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Personne.EmployeDeCaisse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface EmployeDeCaisseFacadeLocal {

    void create(EmployeDeCaisse employeDeCaisse);

    void edit(EmployeDeCaisse employeDeCaisse);

    void remove(EmployeDeCaisse employeDeCaisse);

    EmployeDeCaisse find(Object id);

    List<EmployeDeCaisse> findAll();

    List<EmployeDeCaisse> findRange(int[] range);

    int count();
    
}
