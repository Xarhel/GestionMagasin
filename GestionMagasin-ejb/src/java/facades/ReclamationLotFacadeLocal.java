/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.ReclamationLot;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface ReclamationLotFacadeLocal {

    void create(ReclamationLot reclamationLot);

    void edit(ReclamationLot reclamationLot);

    void remove(ReclamationLot reclamationLot);

    ReclamationLot find(Object id);

    List<ReclamationLot> findAll();

    List<ReclamationLot> findRange(int[] range);

    int count();
    
}
