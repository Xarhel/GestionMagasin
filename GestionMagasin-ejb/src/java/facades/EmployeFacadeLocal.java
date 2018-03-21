/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.Employe;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface EmployeFacadeLocal {

    void create(Employe employe);

    void edit(Employe employe);

    void remove(Employe employe);

    Employe find(Object id);

    List<Employe> findAll();

    List<Employe> findRange(int[] range);

    int count();

    Employe chercherEmployeParId(int id);

    Collection<Employe> afficherTousEmployes();

    public void modifierEmploye(Employe E, String nom, String prenom, String login, String mdp, TypeCompte typeCompte, Magasin magasin, Rayon rayon);

    public void supprimerEmploye(Employe E);

    public Collection<Employe> chercherEmployeParNom(String nom);
    
}
