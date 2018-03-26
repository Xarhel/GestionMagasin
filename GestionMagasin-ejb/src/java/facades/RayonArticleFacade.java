/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import java.util.Collection;
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
    public void commencerPromotion(Collection<RayonArticle> cra, float prixPromotion) {
    for (RayonArticle ra: cra)
    {
    ra.setPrixVente(prixPromotion);
    
    em.merge(ra);}
    }
    
    @Override
    public void cloturerPromotion(Collection<RayonArticle> cra){
    
    for (RayonArticle ra: cra){
        
        float prix = ra.getPrixRayon();
    
        ra.setPrixVente(prix);
        
        em.merge(ra);
    }
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
        List<RayonArticle> ras = req.getResultList();
        
        result = ras.get(0);
        
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
     @Override
     
    public Collection<RayonArticle> chercherRayonArticlesParReference(int ref){
     
        Collection<RayonArticle> result;
        Query req = getEntityManager().createQuery("SELECT ra FROM RayonArticle AS ra inner join ra.lesArticles ar  WHERE ar.referenceArticle=:ref" );
        req.setParameter("ref", ref);
               
        result = req.getResultList();
        
        return result;
     
     }
     
    @Override
     public void ajouterArticleARayon (Rayon r, Article a, float prixRayon) {
     
     RayonArticle ra = new RayonArticle();
     ra.setPrixRayon(prixRayon);
     ra.setLesArticles(a);
     ra.setLesRayons(r);
     if (a.isPromotion()) {ra.setPrixVente(a.getPrixPromotion());}
     if (!a.isPromotion()) ra.setPrixVente(prixRayon);
     
     
     em.persist(ra);}
     
    @Override
     public void modifierPrixRayonArticle (RayonArticle ra, float prixRayon)
     {
     ra.setPrixRayon(prixRayon);
     Article a = ra.getLesArticles();
     boolean test=a.isPromotion();
     if (test==false) {
     ra.setPrixVente(prixRayon);}
     em.merge(ra);
     }
     
    @Override
     public RayonArticle chercherRayonArticleParId (int id){
         RayonArticle ra;
     Query req = getEntityManager().createQuery("select ra from RayonArticle ra WHERE ra.id=:id");
     req.setParameter("id", id);
     
     ra = (RayonArticle) req.getSingleResult();
     return ra;
     }
     
    @Override
     public Collection <RayonArticle> listerRayonArticleParRayon(Rayon r){
     Collection<RayonArticle> ra;
     Query req = getEntityManager().createQuery("select ra from RayonArticle ra WHERE ra.lesRayons=:r");
     req.setParameter("r", r);
     
     ra =  req.getResultList();
     return ra;
     }

    @Override
    public Collection rechercherRayonArticleParIdMagasin(int idMagasin) {
        Collection<RayonArticle> rayonArticle;
        
        Query req = em.createQuery("SELECT lra FROM RayonArticle AS lra INNER JOIN lra.lesRayons lr INNER JOIN lr.leMagasin lm INNER JOIN lra.lesArticles lar INNER JOIN lar.leStock ls WHERE lm.id=:id AND ls.quantiteStock>1");
        
        req.setParameter("id", idMagasin);
        
        rayonArticle = req.getResultList();
        return rayonArticle;       
        
    }
        
    }
    
    
    

