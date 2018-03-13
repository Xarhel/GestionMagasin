/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.AgentDeLivraison;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 3137574
 */
@Stateless
public class AgentDeLivraisonFacade extends AbstractFacade<AgentDeLivraison> implements AgentDeLivraisonFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentDeLivraisonFacade() {
        super(AgentDeLivraison.class);
    }
    
    @Override
     public void creerAgentDeLivraison(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin)
    {
        AgentDeLivraison ADL= new AgentDeLivraison();
        ADL.setNomPersonne(nom);
        ADL.setPrenomPersonne(prenom);
        ADL.setLogin(login);
        ADL.setPassword(mdp);
        ADL.setDateCreationCompte(dateCreationCompte);
        ADL.setTypeCompte(typeCompte);
        ADL.setLeMagasin(magasin);
        em.persist(ADL);
        
    }
     
    @Override
     public void modifierAgentDeLivraison(AgentDeLivraison ADL, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin)
     {
         
        ADL.setNomPersonne(nom);
        ADL.setPrenomPersonne(prenom);
        ADL.setLogin(login);
        ADL.setPassword(mdp);
        ADL.setDateCreationCompte(dateCreationCompte);
        ADL.setTypeCompte(typeCompte);
        ADL.setLeMagasin(magasin);
        em.merge(ADL);
         
         
         
     }
     public void supprimerAgentDeLivraison(AgentDeLivraison ADL)
     {
         em.remove(ADL);
         
}

    @Override
    public void affecterAgentDeLivraison(AgentDeLivraison adl, Magasin magasin) {
        adl.setLeMagasin(magasin);
        em.merge(adl);
        
    }
     
    public AgentDeLivraison rechercherAgentParIdEmploye(int idADL)
    {
        AgentDeLivraison result;
    
        Query req = getEntityManager().createQuery("SELECT adl FROM AgentDeLivraison AS adl WHERE a.id =: idADL");
        req.setParameter("idADL", idADL);
        
        result = (AgentDeLivraison) req.getSingleResult();
        
        return result;
        
    }
    }
            
            
            

