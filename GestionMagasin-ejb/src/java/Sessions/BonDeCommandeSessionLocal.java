/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.BonDeCommande;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author 5153218
 */
@Local
public interface BonDeCommandeSessionLocal {
    
  void creerBonDeCommande(Date dateCommande, int idFournisseur, int idArticle);
  Collection<BonDeCommande> RechercherBonDeCommande(Date dateCommande, int idFournisseur, int idArticle);
  Collection<BonDeCommande> rechercherCommandeParArticle (int idArticle);
  public Collection<BonDeCommande> AfficherCommande ();

    
}
