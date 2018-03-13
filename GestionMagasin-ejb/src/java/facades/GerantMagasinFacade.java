/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.GerantMagasin;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class GerantMagasinFacade extends AbstractFacade<GerantMagasin> implements GerantMagasinFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GerantMagasinFacade() {
        super(GerantMagasin.class);
    }
    
    public void creerGerantMagasin(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
        GerantMagasin GM= new GerantMagasin();
        GM.setNomPersonne(nom);
        GM.setPrenomPersonne(prenom);
        GM.setLogin(login);
        GM.setPassword(mdp);
        GM.setDateCreationCompte(dateCreationCompte);
        GM.setTypeCompte(typeCompte);
        GM.setLeMagasin(magasin);
        GM.setLeRayon(rayon);
        em.persist(GM);
        
    }
     
     public void modifierGerantMagasin(GerantMagasin GM, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
       
        GM.setNomPersonne(nom);
        GM.setPrenomPersonne(prenom);
        GM.setLogin(login);
        GM.setPassword(mdp);
        GM.setDateCreationCompte(dateCreationCompte);
        GM.setTypeCompte(typeCompte);
        GM.setLeMagasin(magasin);
        GM.setLeRayon(rayon);
        em.merge(GM);
        
    }
     
     public void supprimerGerantMagasin(GerantMagasin GM)
     {
         em.remove(GM);
}
}
