/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface RayonFacadeLocal {

    void create(Rayon rayon);

    void edit(Rayon rayon);

    void remove(Rayon rayon);

    Rayon find(Object id);

    List<Rayon> findAll();

    List<Rayon> findRange(int[] range);

    int count();

    void creerRayon(String rayonNom, Magasin magasin);


    void modifierRayon(Rayon rayonAModifier, String rayonNom, Magasin magasin);
    
    public Rayon rechercherRayonParId(int idRayon);
    
    public Rayon rechercherRayonParNomMagasin(String rayonNom, Magasin magasin);
    
}
