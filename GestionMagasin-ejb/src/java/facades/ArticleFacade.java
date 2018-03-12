/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class ArticleFacade extends AbstractFacade<Article> implements ArticleFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }

    //Méthode de création d'un article
    @Override
    public void creerArticle(int referenceArticle, String libelle, int codeBarre, boolean promotion, float prixPromotion) {
        Article a = new Article();
        a.setReferenceArticle(referenceArticle);
        a.setLibelle(libelle);
        a.setCodeBarre(codeBarre);
        a.setPromotion(false);
        em.persist(a);
    }
    
    //Méthode de modification du prix d'un article
    @Override
    public void modifierPrixArticle(Article a, float prixPromotion) {
        a.setPrixPromotion(prixPromotion);
        em.merge(a);
    }
      
}
