/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.ChefDeRayon;
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
public class ChefDeRayonFacade extends AbstractFacade<ChefDeRayon> implements ChefDeRayonFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChefDeRayonFacade() {
        super(ChefDeRayon.class);
    }
    
    
    @Override
    public void creerChefDeRayon(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
        ChefDeRayon CDR= new ChefDeRayon();
        CDR.setNomPersonne(nom);
        CDR.setPrenomPersonne(prenom);
        CDR.setLogin(login);
        CDR.setPassword(mdp);
        CDR.setDateCreationCompte(dateCreationCompte);
        CDR.setTypeCompte(typeCompte);
        CDR.setLeMagasin(magasin);
        CDR.setLeRayon(rayon);
        em.persist(CDR);
        
    }
    
    @Override
     public void modifierChefDeRayon(ChefDeRayon CDR, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon)
    {
        
        CDR.setNomPersonne(nom);
        CDR.setPrenomPersonne(prenom);
        CDR.setLogin(login);
        CDR.setPassword(mdp);
        CDR.setDateCreationCompte(dateCreationCompte);
        CDR.setTypeCompte(typeCompte);
        CDR.setLeMagasin(magasin);
        CDR.setLeRayon(rayon);
        em.merge(CDR);
        
    }
     
    @Override
     public void supprimerChefDeRayon(ChefDeRayon CDR)
     {
         em.remove(CDR);
}

    @Override
    public void affecterChefDeRayon(ChefDeRayon cdr, Magasin magasin, Rayon rayon) {
        
        cdr.setLeRayon(rayon);
        cdr.setLeMagasin(magasin);
        
        em.merge(cdr);
    }
     
    
    @Override
    public ChefDeRayon rechercherChefDeRayonParId(int id)
    {
    ChefDeRayon result;
    
        Query req = getEntityManager().createQuery("SELECT cdr FROM ChefDeRayon AS cdr WHERE cdr=:id");
        req.setParameter("id", id);
        
        result = (ChefDeRayon) req.getSingleResult();
        
        return result;
        
        
    }
     
}
