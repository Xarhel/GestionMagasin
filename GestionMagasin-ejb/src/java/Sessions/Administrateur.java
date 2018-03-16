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
import Entites.Personne.AgentDeLivraison;
import Entites.Personne.ChefDeRayon;
import Entites.Personne.Direction;
import Entites.Personne.Employe;
import Entites.Personne.Personne;
import static Entites.Personne.Personne_.typeCompte;
import facades.AdresseFacadeLocal;
import facades.AgentDeLivraisonFacadeLocal;
import facades.ChefDeRayonFacadeLocal;
import facades.DirectionFacadeLocal;
import facades.EmployeDeCaisseFacadeLocal;
import facades.EmployeFacadeLocal;
import facades.EmployeRayonFacadeLocal;
import facades.GerantMagasinFacadeLocal;
import facades.MagasinFacadeLocal;
import facades.PersonneFacadeLocal;
import facades.RayonFacadeLocal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6137220
 */
@Stateless
public class Administrateur implements AdministrateurLocal {

    @EJB
    private AdresseFacadeLocal adresseFacade;

    @EJB
    private EmployeFacadeLocal employeFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private PersonneFacadeLocal personneFacade;
    
    @EJB
    private RayonFacadeLocal rayonFacade;

    @EJB
    private GerantMagasinFacadeLocal gerantMagasinFacade;

    @EJB
    private EmployeRayonFacadeLocal employeRayonFacade;

    @EJB
    private EmployeDeCaisseFacadeLocal employeDeCaisseFacade;

    @EJB
    private DirectionFacadeLocal directionFacade;

    @EJB
    private ChefDeRayonFacadeLocal chefDeRayonFacade;
      
    @EJB
    private AgentDeLivraisonFacadeLocal agentDeLivraisonFacade;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public void creerEmploye(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, int idMagasin, int idRayon)
    {
        Magasin Mag= magasinFacade.rechercherMagasinParId(idMagasin);
        Rayon Ray=  rayonFacade.rechercherRayonParId(idRayon);
        
     if(typeCompte==TypeCompte.agentDeLivraison)
     {
         
         agentDeLivraisonFacade.creerAgentDeLivraison(nom, prenom, login, mdp, dateCreationCompte, typeCompte, Mag);
     }
        
     if(typeCompte==TypeCompte.chefDeRayon)
     {
         chefDeRayonFacade.creerChefDeRayon(nom, prenom, login, mdp, dateCreationCompte, typeCompte, Mag, Ray);
     }
        
     if(typeCompte==TypeCompte.direction)
     {
         directionFacade.creerDirection(nom, prenom, login, mdp, dateCreationCompte, typeCompte);
     }
        
     if(typeCompte==TypeCompte.employeDeCaisse)
     {
       employeDeCaisseFacade.creerEmployeDeCaisse(nom, prenom, login, mdp, dateCreationCompte, typeCompte, Mag);
     }
     
     if(typeCompte==TypeCompte.employeRayon)
     {
        employeRayonFacade.creerEmployeDeRayon(nom, prenom, login, mdp, dateCreationCompte, typeCompte, Mag, Ray);
     }
     
     if(typeCompte==TypeCompte.gerantMagasin)
     {
         gerantMagasinFacade.creerGerantMagasin(nom, prenom, login, mdp, dateCreationCompte, typeCompte,Mag);
     }
     
     else 
     {
         System.out.println("Création impossible, pas de type de compte");
     }
     
    }
    
    @Override
    public void modifierEmploye(Employe employe, String nom, String prenom, String login, String mdp, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
     employeFacade.modifierEmploye(employe, nom, prenom, login, mdp, typeCompte, magasin, rayon);
    }
    
    @Override
    public void supprimerEmploye(Employe employe)
    {
        employeFacade.supprimerEmploye(employe);
    }
    
    @Override
    public void creerMagasin(String nom, Adresse adresseMag)
    {
        magasinFacade.creerMagasin(nom, adresseMag);
    }
    
    @Override
    public void modifierMagasin( Magasin mag, String nom)
    {
        magasinFacade.modifierMagasin(mag, nom);
    }
    
    @Override
    public void supprimerMagasin(Magasin mag)
    {
        magasinFacade.supprimerMagasin(mag);
    }
    
    @Override
    public Magasin rechercherMagasinParId(int idMagasin)
    {
        Magasin mag= magasinFacade.rechercherMagasinParId(idMagasin);
        return mag;
    }
    
    @Override
    public Magasin rechercherMagasinParNom(String nom)
    {
        Magasin mag= magasinFacade.rechercherMagasinParNom(nom);
        return mag;
    }
    
    @Override
    public void creerRayon(String nom, Magasin mag)
    {
        rayonFacade.creerRayon(nom, mag);
    }
    
    @Override
    public void modifierRayon(Rayon r, String nom)
    {
        rayonFacade.modifierRayon(r, nom);
    }
    
    @Override
    public Rayon rechercherRayonParId(int idRayon)

    {
       Rayon result= rayonFacade.rechercherRayonParId(idRayon);
       return result;
    }
    
    @Override
    public Collection<Rayon> rechercherListeRayon(Magasin mag)
    {
        Collection<Rayon> result = rayonFacade.rechercherRayonParMagasin(mag);
        return result;
    }
    
    @Override
    public Rayon rechercherRayonParNomEtMagasin (String nomRayon, Magasin Mag)
    {
        Rayon result= rayonFacade.rechercherRayonParNomMagasin(nomRayon, Mag);
        return result;
        
    }

    //Authentification d'un utilisateur
    @Override
    public Personne authentification(String login, String password) {
        Personne p = personneFacade.authentification(login, password);
        return p;
    }    

    @Override
    public Collection<Employe> afficherTousEmployes() {
        Collection<Employe> e = employeFacade.afficherTousEmployes();
        return e;
    }

    @Override
    public Employe rechercherEmployeParId(int id) {
        Employe e = employeFacade.chercherEmployeParId(id);
        return e;
    }

    @Override
    public Collection<Magasin> afficherTousMagasins() {
        Collection<Magasin> magasin = magasinFacade.afficherTousMagasins();
        return magasin;
    }

    @Override
    public Adresse creerAdresse(String libelle, String rue, String complement, int codePostal, String ville) {
        Adresse adresse = adresseFacade.creerAdresse(libelle, rue, complement, codePostal, ville);
        return adresse;
    }     

    @Override
    public void supprimerPersonne(Personne personne) {
        personneFacade.supprimerPersonne(personne);
    }

    @Override
    public Personne rechercherPersonneParId(int idPersonne) {
        Personne personne = personneFacade.rechercherPersonneParId(idPersonne);
        return personne;
    }
    
    
   
}
