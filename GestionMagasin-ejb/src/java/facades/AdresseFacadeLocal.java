/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Adresse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface AdresseFacadeLocal {

    void create(Adresse adresse);

    void edit(Adresse adresse);

    void remove(Adresse adresse);

    Adresse find(Object id);

    List<Adresse> findAll();

    List<Adresse> findRange(int[] range);

    int count();

    Adresse creerAdresse(String libelleAdresse, String rueNom, String rueComplement, int codePostal, String ville);

    void modifierAdresse(Adresse adresseAModifier, String libelleAdresse, String rueNom, String rueComplement, int codePostal, String ville);
  
}
