/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.RayonArticle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class RayonArticleFacade extends AbstractFacade<RayonArticle> implements RayonArticleFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RayonArticleFacade() {
        super(RayonArticle.class);
    }

    // Méthode de modification du prix d'un article
    // Nécessite de rechercher l'article auparavant et de récupérer le rayon du chef de rayon dans sa session
    @Override
    public void modifierPrix(RayonArticle r, float prixRayon) {
        r.setPrixRayon(prixRayon);
        em.merge(prixRayon);
    }
    
    
    
}
