/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.EmployeRayon;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface EmployeRayonFacadeLocal {

    void create(EmployeRayon employeRayon);

    void edit(EmployeRayon employeRayon);

    void remove(EmployeRayon employeRayon);

    EmployeRayon find(Object id);

    List<EmployeRayon> findAll();

    List<EmployeRayon> findRange(int[] range);

    int count();

    public void creerEmployeDeRayon(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon);

    public void modifierEmployeDeRayon(EmployeRayon EDR, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon);

    public void supprimerEmployeDeRayon(EmployeRayon EDR);
    
}
