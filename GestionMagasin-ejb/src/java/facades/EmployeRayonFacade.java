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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 3137574
 */
@Stateless
public class EmployeRayonFacade extends AbstractFacade<EmployeRayon> implements EmployeRayonFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeRayonFacade() {
        super(EmployeRayon.class);
    }
    
    @Override
     public void creerEmployeDeRayon(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte)
    {
        EmployeRayon EDR= new EmployeRayon();
        EDR.setNomPersonne(nom);
        EDR.setPrenomPersonne(prenom);
        EDR.setLogin(login);
        EDR.setPassword(mdp);
        EDR.setDateCreationCompte(dateCreationCompte);
        EDR.setTypeCompte(typeCompte);
        
        em.persist(EDR);
        
    }
      
    @Override
        public void modifierEmployeDeRayon(EmployeRayon EDR, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
       
        EDR.setNomPersonne(nom);
        EDR.setPrenomPersonne(prenom);
        EDR.setLogin(login);
        EDR.setPassword(mdp);
        EDR.setDateCreationCompte(dateCreationCompte);
        EDR.setTypeCompte(typeCompte);
        EDR.setLeMagasin(magasin);
        EDR.setLeRayon(rayon);
        em.merge(EDR);
        
    }
        
    @Override
        public void supprimerEmployeDeRayon(EmployeRayon EDR)
        {
            em.remove(EDR);
}
    
    @Override
        public void affecterRayonAEmployeDeRayon(EmployeRayon er,Rayon rayon)
        {
      
        er.setLeRayon(rayon);
        em.merge(er);
            
        }
        
         @Override
    public EmployeRayon rechercherEmployeRayonParId(int id)
    {
    EmployeRayon result;
    
        Query req = getEntityManager().createQuery("SELECT er FROM EmployeRayon AS er WHERE er.id=:id");
        req.setParameter("id", id);
        
        result = (EmployeRayon) req.getSingleResult();
        
        return result;
        
        
    }
        
    
       @Override
    public void affecterEmployeRayon(EmployeRayon er, Magasin magasin) {
        
        
        er.setLeMagasin(magasin);
        
        em.merge(er);
    }
        
}
