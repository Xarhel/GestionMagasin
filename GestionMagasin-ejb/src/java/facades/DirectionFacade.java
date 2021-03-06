/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.Direction;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class DirectionFacade extends AbstractFacade<Direction> implements DirectionFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DirectionFacade() {
        super(Direction.class);
    }
    
    @Override
        public void creerDirection(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte)
    {
        Direction D= new Direction();
        D.setNomPersonne(nom);
        D.setPrenomPersonne(prenom);
        D.setLogin(login);
        D.setPassword(mdp);
        D.setDateCreationCompte(dateCreationCompte);
        D.setTypeCompte(typeCompte);
        em.persist(D);
        
    }
    
    @Override
    public void modifierDirection(Direction D, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte)
    {
        
        D.setNomPersonne(nom);
        D.setPrenomPersonne(prenom);
        D.setLogin(login);
        D.setPassword(mdp);
        D.setDateCreationCompte(dateCreationCompte);
        D.setTypeCompte(typeCompte);
        em.merge(D);
        
    }
    
    @Override
    public void supprimerDirection(Direction D)
    {
        
        em.remove(D);
}
    
    
    
}
