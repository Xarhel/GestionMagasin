/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.ChefDeRayon;
import java.util.Date;
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

  
    public void modifierChefDeRayon(ChefDeRayon CDR, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon);

    public void supprimerChefDeRayon(ChefDeRayon CDR);

    void affecterChefDeRayon(ChefDeRayon cdr, Magasin magasin, Rayon rayon);
    public ChefDeRayon rechercherChefDeRayonParId(int id);

    public void creerChefDeRayon(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte);
    
}
