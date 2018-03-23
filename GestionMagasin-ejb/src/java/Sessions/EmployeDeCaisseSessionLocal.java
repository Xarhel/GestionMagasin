/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface EmployeDeCaisseSessionLocal {

    public long creerPanierCaisse(int idEmployeDeCaisse);

    public void ajouterArticleVente(long idPanier, int referenceArticle, int quantite, int idMagasin);

    Collection rechercherRayonArticleParIdMagasin(int idMagasin);
    
}
