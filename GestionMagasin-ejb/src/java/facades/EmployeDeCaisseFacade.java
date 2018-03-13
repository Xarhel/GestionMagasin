/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.EmployeDeCaisse;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void creerEmployeDeCaisse(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
        EmployeDeCaisse EDC= new EmployeDeCaisse();
        EDC.setNomPersonne(nom);
        EDC.setPrenomPersonne(prenom);
        EDC.setLogin(login);
        EDC.setPassword(mdp);
        EDC.setDateCreationCompte(dateCreationCompte);
        EDC.setTypeCompte(typeCompte);
        EDC.setLeMagasin(magasin);
        EDC.setLeRayon(rayon);
        em.persist(EDC);
        
    }
    @Override
     public void modifierEmployeDeCaisse(EmployeDeCaisse EDC, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
      
        EDC.setNomPersonne(nom);
        EDC.setPrenomPersonne(prenom);
        EDC.setLogin(login);
        EDC.setPassword(mdp);
        EDC.setDateCreationCompte(dateCreationCompte);
        EDC.setTypeCompte(typeCompte);
        EDC.setLeMagasin(magasin);
        EDC.setLeRayon(rayon);
        em.merge(EDC);
        
    }
     
    @Override
     public void supprimerEmployeDeCaisse(EmployeDeCaisse EDC)
     {
         em.remove(EDC);
}

    @Override
    public void affecterEmployeDeCaisse(EmployeDeCaisse edc, Rayon rayon, Magasin magasin) {
        
        edc.setLeRayon(rayon);
        edc.setLeMagasin(magasin);
        
        em.merge(edc);
    }
     
     
}
