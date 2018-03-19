/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Personne.ChefDeRayon;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 3137574
 */
@Stateless
public class RayonFacade extends AbstractFacade<Rayon> implements RayonFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RayonFacade() {
        super(Rayon.class);
    }

    @Override
    public void creerRayon(String rayonNom, Magasin magasin) {
        
        Rayon rayonAAjouter = new Rayon();
        
        rayonAAjouter.setRayonNom(rayonNom);
        rayonAAjouter.setLeMagasin(magasin);
        em.persist(rayonAAjouter);
        
    }

    @Override
    public void modifierRayon(Rayon rayonAModifier, String rayonNom) {
        
  
    rayonAModifier.setRayonNom(rayonNom);
    
    em.merge(rayonAModifier);
    
    }
    
    @Override
    public Rayon rechercherRayonParId(int idRayon) {
        
    Rayon result;
    
        Query req = getEntityManager().createQuery("SELECT r FROM Rayon AS r WHERE r.id = :idRayon");
        req.setParameter("idRayon", idRayon);
        
        result = (Rayon) req.getSingleResult();
        
        return result;
        
    }
    
        @Override
    public Rayon rechercherRayonParNomMagasin(String rayonNom, Magasin magasin) {
        
    Rayon result;
    
        Query req = getEntityManager().createQuery("SELECT r FROM Rayon AS r WHERE r.rayonNom =:rayonNom AND r.leMagasin =:magasin");
        req.setParameter("rayonNom", rayonNom);
        req.setParameter("magasin", magasin);
        
        result = (Rayon) req.getSingleResult();
        
        return result;
        
    }
    
    @Override
    public Collection<Rayon> rechercherRayonParMagasin(Magasin magasin) {
        
    Collection<Rayon> result;
    
        Query req = getEntityManager().createQuery("SELECT r FROM Rayon AS r WHERE r.leMagasin =:magasin");
        req.setParameter("magasin", magasin);
        
        result = req.getResultList();
        
        return result;
        
    }
    
    
}
