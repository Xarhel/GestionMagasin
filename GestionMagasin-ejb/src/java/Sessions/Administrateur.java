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
import static Entites.Personne.Personne_.typeCompte;
import facades.AgentDeLivraisonFacadeLocal;
import facades.ChefDeRayonFacadeLocal;
import facades.DirectionFacadeLocal;
import facades.EmployeDeCaisseFacadeLocal;
import facades.EmployeRayonFacadeLocal;
import facades.GerantMagasinFacadeLocal;
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
    private facades.EmployeFacade employeFacade;
    
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
    private facades.MagasinFacadeLocal magasinFacadeLocal;
    
    @EJB
    private facades.RayonFacadeLocal rayonFacadeLocal;
    
    @EJB
    private AgentDeLivraisonFacadeLocal agentDeLivraisonFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void creerEmploye(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, int idMagasin, int idRayon)
    {
        Magasin Mag= magasinFacadeLocal.rechercherMagasinParId(idMagasin);
        Rayon Ray=  rayonFacadeLocal.rechercherRayonParId(idRayon);
        
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
    
    public void modifierEmploye(Employe employe, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
     employeFacade.modifierEmploye(employe, nom, prenom, login, mdp, dateCreationCompte, typeCompte, magasin, rayon);
    }
    
    public void supprimerEmploye(Employe employe)
    {
        employeFacade.supprimerEmploye(employe);
    }
    
    public void creerMagasin(String nom, Adresse adresseMag)
    {
        magasinFacadeLocal.creerMagasin(nom, adresseMag);
    }
    
    public void modifierMagasin( Magasin mag, String nom, Adresse adresseMag)
    {
        magasinFacadeLocal.modifierMagasin(mag, nom, adresseMag);
    }
    
    public void supprimerMagasin(Magasin mag)
    {
        magasinFacadeLocal.supprimerMagasin(mag);
    }
    
    public Magasin rechercherMagasinParId(int idMagasin)
    {
        Magasin mag= magasinFacadeLocal.rechercherMagasinParId(idMagasin);
        return mag;
    }
    
    public Magasin rechercherMagasinParNom(String nom)
    {
        Magasin mag= magasinFacadeLocal.rechercherMagasinParNom(nom);
        return mag;
    }
    
    public void creerRayon(String nom, Magasin mag)
    {
        rayonFacadeLocal.creerRayon(nom, mag);
    }
    
    public void modifierRayon(Rayon r, String nom, Magasin mag)
    {
        rayonFacadeLocal.modifierRayon(r, nom, mag);
    }
    
    public Rayon rechercherRayonParId(int idRayon)

    {
       Rayon result= rayonFacadeLocal.rechercherRayonParId(idRayon);
       return result;
    }
    
    public Collection<Rayon> rechercherListeRayon(Magasin mag)
    {
        Collection<Rayon> result = rayonFacadeLocal.rechercherRayonParNomMagasin(mag);
        return result;
    }
    
    public Rayon rechercherRayonParNomEtMagasin (String nomRayon, Magasin Mag)
    {
        Rayon result= rayonFacadeLocal.rechercherRayonParNomMagasin(nomRayon, Mag);
        return result;
        
    }
            }
