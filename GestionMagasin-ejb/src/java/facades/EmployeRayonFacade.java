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
    
     public void creerEmployeDeRayon(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
        EmployeRayon EDR= new EmployeRayon();
        EDR.setNomPersonne(nom);
        EDR.setPrenomPersonne(prenom);
        EDR.setLogin(login);
        EDR.setPassword(mdp);
        EDR.setDateCreationCompte(dateCreationCompte);
        EDR.setTypeCompte(typeCompte);
        EDR.setLeMagasin(magasin);
        EDR.setLeRayon(rayon);
        em.persist(EDR);
        
    }
      
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
        
        public void supprimerEmployeDeRayon(EmployeRayon EDR)
        {
            em.remove(EDR);
}
    
        public void affecterEmployeDeRayon(EmployeRayon er, Magasin magasin,Rayon rayon)
        {
        er.setLeMagasin(magasin);
        er.setLeRayon(rayon);
        em.merge(er);
            
        }
}
