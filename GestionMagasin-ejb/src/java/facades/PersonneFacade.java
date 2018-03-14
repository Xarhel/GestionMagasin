/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Personne.Personne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 3137574
 */
@Stateless
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade() {
        super(Personne.class);
    }
    
    //Authentification d'un utilisateur
    @Override
    public Personne authentification(String login, String password) {
        Personne p;
        Query req = em.createQuery("SELECT p FROM Personne AS P WHERE p.login=:login AND p.password=:password");
        req.setParameter("login", login);
        req.setParameter("password", password);
        p = (Personne) req.getSingleResult();
        return p;
    }
    
}
