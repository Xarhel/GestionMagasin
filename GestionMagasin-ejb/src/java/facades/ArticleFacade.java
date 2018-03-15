/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
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
    public void creerArticle(int referenceArticle, String libelle, int codeBarre, boolean promotion) {
        Article a = new Article();
        a.setReferenceArticle(referenceArticle);
        a.setLibelle(libelle);
        a.setCodeBarre(codeBarre);
        a.setPromotion(false);
        a.setPrixPromotion(0);
        em.persist(a);
    }
    
    //Méthode de modification du prix d'un article (passage en promotion)
    @Override
    public void modifierPrixArticle(Article a, float prixPromotion) {
        a.setPrixPromotion(prixPromotion);
        a.setPromotion(true);
        em.merge(a);
    }

    @Override
    public void annulerPromotion(Article a) {
        a.setPromotion(false);
        em.merge(a);
    }

    @Override
    public Article rechercheArticleParReference(int referenceArticle) {
            Article result;
    
        Query req = getEntityManager().createQuery("SELECT a FROM Article AS a WHERE a.id =: referenceArticle");
        req.setParameter("referenceArticle", referenceArticle);
        
        result = (Article) req.getSingleResult();
        
        return result;
    }
    
    /**
     *
     * @param libelle
     * @return
     */
    @Override
    public Collection<Article> rechercherArticleParLibelle(String libelle) {
        
    Collection<Article> result;
    
        Query req = getEntityManager().createQuery("SELECT a FROM Article AS a WHERE a.libelle LIKE libelle ");
        req.setParameter("libelle", libelle);
        
        result = req.getResultList();
        
        return result;
        
    }
    
    
    
    
}
