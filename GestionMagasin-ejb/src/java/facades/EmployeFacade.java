/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.Employe;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class EmployeFacade extends AbstractFacade<Employe> implements EmployeFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeFacade() {
        super(Employe.class);
    }
    
    
     public void modifierEmploye(Employe E, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
     {
         
        E.setNomPersonne(nom);
        E.setPrenomPersonne(prenom);
        E.setLogin(login);
        E.setPassword(mdp);
        E.setDateCreationCompte(dateCreationCompte);
        E.setTypeCompte(typeCompte);
        E.setLeMagasin(magasin);
        E.setLeRayon(rayon);
        em.merge(E);
         
         
         
     }
     public void supprimerEmploye(Employe E)
     {
         em.remove(E);
    
}
}
