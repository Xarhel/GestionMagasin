/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface RayonArticleFacadeLocal {

    void create(RayonArticle rayonArticle);

    void edit(RayonArticle rayonArticle);

    void remove(RayonArticle rayonArticle);

    RayonArticle find(Object id);

    List<RayonArticle> findAll();

    List<RayonArticle> findRange(int[] range);

    int count();

    void modifierPrix(RayonArticle r, float prixRayon);

    public RayonArticle rechercherRayonArticle(Rayon r, Article a);

    public RayonArticle rechercherRayonArticleParLibelle(Rayon r, String libelle);
    
    public RayonArticle rechercherRayonArticleParReference(Rayon r, int reference);
    
    public void commencerPromotion(Collection<RayonArticle> cra, float prixPromotion);

    public void cloturerPromotion(Collection<RayonArticle> cra);

    public void ajouterArticleARayon(Rayon r, Article a, float prixRayon);

    public void modifierPrixRayonArticle (RayonArticle ra, float prixRayon);

    public Collection<RayonArticle> chercherRayonArticlesParReference (int ref);

    public RayonArticle chercherRayonArticleParId(int id);

    public Collection<RayonArticle> listerRayonArticleParRayon(Rayon r);
    
   
}
