/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Adresse;
import Entites.Autre.Magasin;
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
    public void modifierMagasin(Magasin magasinAModifier, String nom, Adresse adresse) {
    
    magasinAModifier.setNom(nom);
    magasinAModifier.setAdresse(adresse);
    
    em.persist(magasinAModifier);
    
    }

    @Override
    public Magasin rechercherMagasinParNom(String nom) {
        
    Magasin result;
    
        Query req = getEntityManager().createQuery("SELECT m FROM Magasin AS m WHERE m.nom =: nom");
        req.setParameter("nom", nom);
        
        result = (Magasin) req.getSingleResult();
        
        return result;
        
    }

    @Override
    public Magasin rechercherMagasinParId(int idMagasin) {
        
    Magasin result;
    
        Query req = getEntityManager().createQuery("SELECT m FROM Magasin AS m WHERE m.id =: idMagasin");
        req.setParameter("idMagasin", idMagasin);
        
        result = (Magasin) req.getSingleResult();
        
        return result;
        
    }
}