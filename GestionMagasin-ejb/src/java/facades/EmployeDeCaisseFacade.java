/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Enum.TypeCompte;
import Entites.Personne.EmployeDeCaisse;
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
public class EmployeDeCaisseFacade extends AbstractFacade<EmployeDeCaisse> implements EmployeDeCaisseFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeDeCaisseFacade() {
        super(EmployeDeCaisse.class);
    }
    
    @Override
    public void creerEmployeDeCaisse(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin)
    {
        EmployeDeCaisse EDC= new EmployeDeCaisse();
        EDC.setNomPersonne(nom);
        EDC.setPrenomPersonne(prenom);
        EDC.setLogin(login);
        EDC.setPassword(mdp);
        EDC.setDateCreationCompte(dateCreationCompte);
        EDC.setTypeCompte(typeCompte);
        EDC.setLeMagasin(magasin);
        
        em.persist(EDC);
        
    }
    @Override
     public void modifierEmployeDeCaisse(EmployeDeCaisse EDC, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin)
    {
      
        EDC.setNomPersonne(nom);
        EDC.setPrenomPersonne(prenom);
        EDC.setLogin(login);
        EDC.setPassword(mdp);
        EDC.setDateCreationCompte(dateCreationCompte);
        EDC.setTypeCompte(typeCompte);
        EDC.setLeMagasin(magasin);
       
        em.merge(EDC);
        
    }
     
    @Override
     public void supprimerEmployeDeCaisse(EmployeDeCaisse EDC)
     {
         em.remove(EDC);
}

    @Override
    public void affecterEmployeDeCaisse(EmployeDeCaisse edc, Magasin magasin) {
        
        
        edc.setLeMagasin(magasin);
        
        em.merge(edc);
    }
     
    @Override
   public EmployeDeCaisse rechercherEmployeDeCaisse(int id)
   {
       EmployeDeCaisse result;
    
        Query req = getEntityManager().createQuery("SELECT edc FROM EmployeDeCaisse AS edc WHERE edc.id=:id");
        req.setParameter("id", id);
        
        result = (EmployeDeCaisse) req.getSingleResult();
        
        return result;
       
       
   }
}
