/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Enum.TypeCompte;
import Entites.Personne.Administrateur;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
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
public class AdministrateurFacade extends AbstractFacade<Administrateur> implements AdministrateurFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministrateurFacade() {
        super(Administrateur.class);
    }
    
    @Override
    public void creerAdminParDefaut(){
    Administrateur a = new Administrateur();
    Date d = new Date();
    a.setLogin("test");
    a.setPassword("test");
    a.setTypeCompte(TypeCompte.administrateur);
    a.setNomPersonne("Administrateur");
    a.setPrenomPersonne(" ");
    a.setDateCreationCompte(d);
    
    em.persist(a);}
    
    @Override
    public boolean adminCree (){
    List <Administrateur> admins;
    Query req = getEntityManager().createQuery("select a from Administrateur a where a.login=:test");
    req.setParameter("test", "test");
    
    admins = req.getResultList();
    
    if (admins.isEmpty()){
    return true;}
    else return false;
    }
    
}
