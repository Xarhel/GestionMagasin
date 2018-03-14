/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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


    
    
    
    
    
    @Override
    public RayonArticle rechercherRayonArticle(Rayon r, Article a)
    {
        RayonArticle result;
    
        Query req = getEntityManager().createQuery("SELECT ra FROM RayonArticle AS ra WHERE ra.lesRayons =:r AND ra.lesRayons=:a" );
        req.setParameter("r", r);
        req.setParameter("a", a);
        
        result = (RayonArticle) req.getSingleResult();
        
        return result;
        
    }
    
    @Override
    public RayonArticle rechercherRayonArticleParLibelle(Rayon r, String libelle)
    {
        RayonArticle result;
    
        Query req = getEntityManager().createQuery("SELECT ra FROM RayonArticle AS ra inner join ra.lesArticles ar WHERE ra.lesRayons =:r AND ar.libelle=:libelle" );
        req.setParameter("r", r);
        req.setParameter("libelle", libelle);
        
        result = (RayonArticle) req.getSingleResult();
        
        return result;
        
    }
    
    @Override
     public RayonArticle rechercherRayonArticleParReference(Rayon r, int reference)
    {
        RayonArticle result;
    
        Query req = getEntityManager().createQuery("SELECT ra FROM RayonArticle AS ra inner join ra.lesArticles ar  WHERE ra.lesRayons =:r AND ar.referenceArticle=:reference" );
        req.setParameter("r", r);
        req.setParameter("reference", reference);
        
        result = (RayonArticle) req.getSingleResult();
        
        return result;
        
    }
        
    }
    
    
    

