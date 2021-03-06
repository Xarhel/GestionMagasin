/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.RayonArticle;
import Entites.Vente.PanierCaisse;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface EmployeDeCaisseSessionLocal {

    public long creerPanierCaisse(int idEmployeDeCaisse);

    public void ajouterArticleVente(long idPanier, int idArticle, int quantite, float prixUnitaire, int idMagasin);

    Collection rechercherRayonArticleParIdMagasin(int idMagasin);

    RayonArticle rechercherRayonArticleParId(int idRayonArticle);

    Collection rechercherArticleVenteParPanier(long idPanier);

    float calculerMontantPanier(Collection ArticlesVente, long idPanierCaisse);

    void retirerArticleVente(int idArticleVente);

    boolean validerPanier(int idPanierCaisse);
    
}
