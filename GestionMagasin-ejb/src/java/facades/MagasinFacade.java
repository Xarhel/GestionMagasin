/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Adresse;
import Entites.Autre.Magasin;
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
public class MagasinFacade extends AbstractFacade<Magasin> implements MagasinFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MagasinFacade() {
        super(Magasin.class);
    }
@Override
    public void creerMagasin(String nom, Adresse adresseMagasin) {
        
        Magasin magasinACreer = new Magasin();
        
        magasinACreer.setNom(nom);
        magasinACreer.setAdresse(adresseMagasin);
        
        em.persist(magasinACreer);
    }

    @Override
    public void modifierMagasin(Magasin magasinAModifier, String nom) {
    
    magasinAModifier.setNom(nom);   
    em.merge(magasinAModifier);
    
    }

    @Override
    public Magasin rechercherMagasinParNom(String nom) {
        
    Magasin result;
    
        Query req = getEntityManager().createQuery("SELECT m FROM Magasin AS m WHERE m.nom = :nom");
        req.setParameter("nom", nom);
        List <Magasin> magasins = req.getResultList();
        
        result =magasins.get(0);
        
        return result;
        
    }

    @Override
    public Magasin rechercherMagasinParId(long idMagasin) {
        
    Magasin result;
    
        Query req = getEntityManager().createQuery("SELECT m FROM Magasin AS m WHERE m.id = :idMagasin");
        req.setParameter("idMagasin", idMagasin);
        
        result = (Magasin) req.getSingleResult();
        
        return result;
        
    }
    @Override
    public void supprimerMagasin(Magasin mag)
    {
        em.remove(mag);
    }
    
    @Override
    public Collection<Magasin> afficherTousMagasins()
    {
        Collection<Magasin> magasin;
        Query req = em.createQuery("SELECT m FROM Magasin AS m");
        magasin = req.getResultList();
        return magasin;
    }
    
}
