/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.AgentDeLivraison;
import static Entites.Personne.Personne_.typeCompte;
import facades.AgentDeLivraisonFacadeLocal;
import facades.ChefDeRayonFacadeLocal;
import facades.DirectionFacadeLocal;
import facades.EmployeDeCaisseFacadeLocal;
import facades.EmployeRayonFacadeLocal;
import facades.GerantMagasinFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6137220
 */
@Stateless
public class Administrateur implements AdministrateurLocal {

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
    
    public void creerEmploye(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, int idMagasin, int idRayon)
    {
       // Enlever les commentaires lorsque les méthodes de recherche seront OK 
       // Magasin Mag= RechercherMagasinParId(idMagasin);
       // Rayon Ray= RechercherRayonParId(idRayon);
        
     if(typeCompte==TypeCompte.agentDeLivraison)
     {
         
        // agentDeLivraisonFacade.creerAgentDeLivraison(nom, prenom, login, mdp, dateCreationCompte, typeCompte, magasin, rayon);
     }
        
     if(typeCompte==TypeCompte.chefDeRayon)
     {
       //  chefDeRayonFacade.creerChefDeRayon(nom, prenom, login, mdp, dateCreationCompte, typeCompte, magasin, rayon);
     }
        
     if(typeCompte==TypeCompte.direction)
     {
       //  directionFacade.creerDirection(nom, prenom, login, mdp, dateCreationCompte, typeCompte, magasin, rayon);
     }
        
     if(typeCompte==TypeCompte.employeDeCaisse)
     {
       // employeDeCaisseFacade.creerEmployeDeCaisse(nom, prenom, login, mdp, dateCreationCompte, typeCompte, magasin, rayon);
     }
     
     if(typeCompte==TypeCompte.employeRayon)
     {
      //  employeRayonFacade.creerEmployeDeRayon(nom, prenom, login, mdp, dateCreationCompte, typeCompte, magasin, rayon);
     }
     
     if(typeCompte==TypeCompte.gerantMagasin)
     {
      //   gerantMagasinFacade.creerGerantMagasin(nom, prenom, login, mdp, dateCreationCompte, typeCompte, magasin, rayon);
     }
    }
    
    
    
    
}
