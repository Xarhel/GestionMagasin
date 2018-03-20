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
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    @Override
    public Employe chercherEmployeParId(int id) {
        Employe result;
    
        Query req = getEntityManager().createQuery("SELECT e FROM Employe AS e WHERE e.id =:id");
        req.setParameter("idMagasin", id);
        List <Employe> employes = req.getResultList();
        
        result = employes.get(0);
        
        return result;
    }
    
    
    @Override
     public void modifierEmploye(Employe E, String nom, String prenom, String login, String mdp, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
     {
         
        E.setNomPersonne(nom);
        E.setPrenomPersonne(prenom);
        E.setLogin(login);
        E.setPassword(mdp);
        E.setTypeCompte(typeCompte);
        E.setLeMagasin(magasin);
        E.setLeRayon(rayon);
        em.merge(E);
 
     }
     
     @Override
     public void supprimerEmploye(Employe E)
     {
         em.remove(E);
     }

    @Override
    public Collection<Employe> afficherTousEmployes() {
        Collection e;
        Query req = em.createQuery("SELECT e FROM Employe AS e");
        e = req.getResultList();
        return e;
    }
     
    
    @Override
     public Collection <Employe> chercherEmployeParNom(String nom) {
       Collection <Employe> result;
    
        Query req = getEntityManager().createQuery("SELECT e FROM Employe AS e WHERE e.nomPersonne =:nom");
        req.setParameter("nom", nom);
        
        result =   req.getResultList();
        
        return result;
    }
}
