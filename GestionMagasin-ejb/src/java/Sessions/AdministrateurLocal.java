/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Adresse;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.Employe;
import Entites.Personne.Personne;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface AdministrateurLocal {

    public void supprimerEmploye(Employe employe);

    public void modifierEmploye(Employe employe, String nom, String prenom, String login, String mdp, TypeCompte typeCompte, Magasin magasin, Rayon rayon);

    public void creerMagasin(String nom, Adresse adresseMag);

    public void modifierMagasin(Magasin mag, String nom);

    public void supprimerMagasin(Magasin mag);

    public Magasin rechercherMagasinParId(int idMagasin);

    public Magasin rechercherMagasinParNom(String nom);

    public void creerRayon(String nom, Magasin mag);

    public void modifierRayon(Rayon r, String nom);

    public Rayon rechercherRayonParId(int idRayon);

    public Collection<Rayon> rechercherListeRayon(Magasin mag);

    public Rayon rechercherRayonParNomEtMagasin(String nomRayon, Magasin Mag);

    public Personne authentification(String login, String password);

    public void creerEmploye(String nom, String prenom, String login, String mdp,Date dateCreationCompte, TypeCompte typeCompte, int idMagasin, int idRayon);

    Collection<Employe> afficherTousEmployes();

    Employe rechercherEmployeParId(int id);

    Collection<Magasin> afficherTousMagasins();

    Adresse creerAdresse(String libelle, String rue, String complement, int codePostal, String ville);

    void supprimerPersonne(Personne personne);

    Personne rechercherPersonneParId(int idPersonne);

    public void creerAdminDemarrage();
    
}
