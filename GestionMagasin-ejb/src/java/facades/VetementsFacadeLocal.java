/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Lot.Vetements;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface VetementsFacadeLocal {

    void create(Vetements vetements);

    void edit(Vetements vetements);

    void remove(Vetements vetements);

    Vetements find(Object id);

    List<Vetements> findAll();

    List<Vetements> findRange(int[] range);

    int count();
    
}
