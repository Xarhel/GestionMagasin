/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.BonDeCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface BonDeCommandeFacadeLocal {

    void create(BonDeCommande bonDeCommande);

    void edit(BonDeCommande bonDeCommande);

    void remove(BonDeCommande bonDeCommande);

    BonDeCommande find(Object id);

    List<BonDeCommande> findAll();

    List<BonDeCommande> findRange(int[] range);

    int count();
    
}
