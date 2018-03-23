/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.BonDeCommande;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import Entites.Enum.CategorieArticle;
import Entites.Lot.Lot;
import Entites.Personne.Fournisseur;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface ChefDeRayonSessionLocal {

    public void ajouterFournisseur(String raisonSocial, String login, String password, String nom, String prenom);

    public void ajouterArticle(int referenceArticle, String libelle, CategorieArticle categorie);

    public void modifierPrixArticle(RayonArticle ra, float prix);

    public void creerBonDeCommande(Date dateCommande, int idFournisseur, int idArticle);

   public void creerCommandeLot(BonDeCommande commande, float prixAchat, Article lArticle, int quantite);

    public Collection<Article> afficherTousLesArticles();

    public Article rechercherArticleParId(int id);

    public Rayon rechercherRayonParId(long id);

    public void ajouterArticleAuRayon(Article a, Rayon r, float prix);

    public RayonArticle chercherRayonArticleParId(int id);

    public Collection<RayonArticle> listerRayonArticleParRayon(Rayon r);
    public Collection<Fournisseur> listerFournisseur ();

    
}
