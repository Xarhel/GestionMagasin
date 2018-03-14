/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.BonDeCommande;
import Entites.Autre.Rayon;
import Entites.Lot.Lot;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface ChefDeRayonSessionLocal {

    public void ajouterFournisseur(String raisonSocial, String login, String password);

    public void ajouterArticle(int referenceArticle, String libelle, int codeBarre, boolean promotion, float prixPromotion);

    public void modifierPrixArticle(Rayon r, Article a, float prix);

    public void creerLot(Article lArticle, int quantite);

    public void creerCommandeLot(Lot lot, BonDeCommande commande, int quantite, float prixAchat);
    
}
