/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.BonDeCommande;
import Entites.Autre.Livraison;
import Entites.Personne.Fournisseur;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface FournisseurSessionLocal {

    public Livraison creerLivraison( int idBonDeCommande, Date dateDebutLivraison);

    public Collection<BonDeCommande> consulterBonDeCommande(long idFournisseur);

    public BonDeCommande RechercherBonDeCommandeParDateChefEtFournisseur(int idChefDeRayon, Date dateCreation, int idFournisseur);

    public Collection<Livraison> afficherLivraisonsEnCours(long idF);
    
}
