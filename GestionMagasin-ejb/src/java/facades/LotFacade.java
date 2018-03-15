/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Lot.Lot;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class LotFacade extends AbstractFacade<Lot> implements LotFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LotFacade() {
        super(Lot.class);
    }

    // Création du lot
    @Override
    public Lot creerLot(Article lArticle, int quantite) {
        Lot lot = new Lot();
        lot.setlArticle(lArticle);
        lot.setQuantite(quantite);
        em.persist(lot);
        return lot;
    }
    
    
    
}
