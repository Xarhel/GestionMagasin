/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Adresse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class AdresseFacade extends AbstractFacade<Adresse> implements AdresseFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdresseFacade() {
        super(Adresse.class);
    }
    @Override
    public Adresse creerAdresse(String libelleAdresse, String rueNom, String rueComplement, int codePostal, String ville) {
        
        Adresse adresseACreer = new Adresse();
        
        adresseACreer.setLibelleAdresse(libelleAdresse);
        adresseACreer.setRueNom(rueNom);
        adresseACreer.setRueComplement(rueComplement);
        adresseACreer.setCodePostal(codePostal);
        adresseACreer.setVille(ville);
        
        em.persist(adresseACreer);
        return (adresseACreer);
    }

    @Override
    public void modifierAdresse(Adresse adresseAModifier, String libelleAdresse, String rueNom, String rueComplement, int codePostal, String ville) {
    
        adresseAModifier.setLibelleAdresse(libelleAdresse);
        adresseAModifier.setRueNom(rueNom);
        adresseAModifier.setRueComplement(rueComplement);
        adresseAModifier.setCodePostal(codePostal);
        adresseAModifier.setVille(ville);
        
        em.persist(adresseAModifier);
    }
        
}
