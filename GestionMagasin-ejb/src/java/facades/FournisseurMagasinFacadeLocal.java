/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.FournisseurMagasin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface FournisseurMagasinFacadeLocal {

    void create(FournisseurMagasin fournisseurMagasin);

    void edit(FournisseurMagasin fournisseurMagasin);

    void remove(FournisseurMagasin fournisseurMagasin);

    FournisseurMagasin find(Object id);

    List<FournisseurMagasin> findAll();

    List<FournisseurMagasin> findRange(int[] range);

    int count();
    
}
