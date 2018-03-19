/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import Entites.Vente.ArticleVente;
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
public class ArticleVenteFacade extends AbstractFacade<ArticleVente> implements ArticleVenteFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleVenteFacade() {
        super(ArticleVente.class);
    }
    
    @Override
    public float calculerTotalVente (Collection <ArticleVente> av){
        float result=0;
        
        for(ArticleVente a: av){
            RayonArticle ra;
            Article article= a.getStock().getlArticle();
            Rayon rayon= a.getStock().getLeRayon();
            
     Query req = getEntityManager().createQuery("select ra from RayonArticle ra WHERE ra.lesArticles=:article AND ra.lesRayons=:rayon");
     req.setParameter("article", article);
     req.setParameter("rayon", rayon);
     
     ra = (RayonArticle) req.getSingleResult();
            
        int quantiteArticle= a.getQuantite();
        float prixUnitaire= ra.getPrixVente();
        result= result+(quantiteArticle*prixUnitaire);}
        return result;
    
    }
    
}
