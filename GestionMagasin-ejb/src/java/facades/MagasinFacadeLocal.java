/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Adresse;
import Entites.Autre.Magasin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface MagasinFacadeLocal {
    void create(Magasin magasin);

    void edit(Magasin magasin);

    void remove(Magasin magasin);

    Magasin find(Object id);

    List<Magasin> findAll();

    List<Magasin> findRange(int[] range);

    int count();

    void creerMagasin(String nom, Adresse adresse);

    void modifierMagasin(Magasin magasinAModifier, String nom, Adresse adresse);

    Magasin rechercherMagasinParNom(String nom);
    
    public Magasin rechercherMagasinParId(int idMagasin);

    public void supprimerMagasin(Magasin mag);
    
}
