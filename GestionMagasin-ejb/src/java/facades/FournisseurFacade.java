/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Personne.Fournisseur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 3137574
 */
@Stateless
public class FournisseurFacade extends AbstractFacade<Fournisseur> implements FournisseurFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FournisseurFacade() {
        super(Fournisseur.class);
    }

    @Override
    public void creerFournisseur(String raisonSocial, String login, String password) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setRaisonSociale(raisonSocial);
        fournisseur.setLogin(login);
        fournisseur.setPassword(password);
        em.persist(fournisseur);
    }
  
    @Override
    public Fournisseur rechercherFournisseurParId(long id)
    {
         Fournisseur result;
    
        Query req = getEntityManager().createQuery("SELECT f FROM Fournisseur AS f WHERE f.id=:id");
        req.setParameter("id", id);
        
        result = (Fournisseur) req.getSingleResult();
        
        return result;
        
    }
    }
    

