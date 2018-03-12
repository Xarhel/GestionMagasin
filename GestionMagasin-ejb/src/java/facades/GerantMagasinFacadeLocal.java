/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.GerantMagasin;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface GerantMagasinFacadeLocal {

    void create(GerantMagasin gerantMagasin);

    void edit(GerantMagasin gerantMagasin);

    void remove(GerantMagasin gerantMagasin);

    GerantMagasin find(Object id);

    List<GerantMagasin> findAll();

    List<GerantMagasin> findRange(int[] range);

    int count();
 
    public void creerGerantMagasin(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon);
    public void modifierGerantMagasin(GerantMagasin GM, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon);
    public void supprimerGerantMagasin(GerantMagasin GM);
}
