/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Personne.ChefDeRayon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface ChefDeRayonFacadeLocal {

    void create(ChefDeRayon chefDeRayon);

    void edit(ChefDeRayon chefDeRayon);

    void remove(ChefDeRayon chefDeRayon);

    ChefDeRayon find(Object id);

    List<ChefDeRayon> findAll();

    List<ChefDeRayon> findRange(int[] range);

    int count();
    
}
