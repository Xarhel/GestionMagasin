/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.RayonArticle;
import facades.RayonArticleFacade;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author houss
 */
@Stateless
public class DirectionSession implements DirectionSessionLocal {
    @EJB
    private facades.RayonArticleFacade rayonFacade;
    
    @EJB
    private facades.ArticleFacade article;
    
    
    @Override
    public void demarrerUnePrommotion (int reference, float prixPromotion) {
    
        Article ar = article.rechercheArticleParReference(reference);
        article.modifierPrixArticle(ar, prixPromotion);
        Collection<RayonArticle> articleDansRayons =rayonFacade.chercherRayonArticlesParReference(reference);
        rayonFacade.commencerPromotion(articleDansRayons, prixPromotion);
    }
    
    @Override
    public void cloturerPromotion (int reference){
        Article ar = article.rechercheArticleParReference(reference);
        Collection<RayonArticle> articleDansRayons =rayonFacade.chercherRayonArticlesParReference(reference);
        article.annulerPromotion(ar);
        rayonFacade.cloturerPromotion(articleDansRayons);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
