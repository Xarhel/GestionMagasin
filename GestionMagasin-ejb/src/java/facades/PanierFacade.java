/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Enum.MoyenPaiement;
import Entites.Vente.Panier;
import java.sql.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class PanierFacade extends AbstractFacade<Panier> implements PanierFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PanierFacade() {
        super(Panier.class);
    }

    @Override
    public void creerPanier(Date dateJour, MoyenPaiement moyenPaiement, float montantTotal) {
        Panier p= new Panier();
        p.setDateJour(dateJour);
        p.setMontantTotal(montantTotal);
        p.setMontantTotal(montantTotal);
        em.persist(p);
    }
    
}
