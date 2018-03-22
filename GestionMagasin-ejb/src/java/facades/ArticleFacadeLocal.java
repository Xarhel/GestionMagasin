/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.Rayon;
import Entites.Enum.CategorieArticle;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface ArticleFacadeLocal {

    void create(Article article);

    void edit(Article article);

    void remove(Article article);

    Article find(Object id);

    List<Article> findAll();

    List<Article> findRange(int[] range);

    int count();

    void creerArticle(int referenceArticle, String libelle, CategorieArticle ca);

    void modifierPrixArticle(Article a, float prixPromotion);

    void annulerPromotion(Article a);

    Article rechercheArticleParReference(int referenceArticle);

    public Collection<Article> rechercherArticleParLibelle(String libelle);

    public Article rechercherArticleParId(int id);

    public Collection<Article> rechercherArticleParCategorie(int categorie);

    public List<Article> rechercheArticlesParReference(int referenceArticle);

    public Collection<Article> afficherTousLesArticles();
    
}
