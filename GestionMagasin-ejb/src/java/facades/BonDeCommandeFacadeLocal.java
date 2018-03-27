/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.BonDeCommande;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Personne.ChefDeRayon;
import Entites.Personne.Fournisseur;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface BonDeCommandeFacadeLocal {

    void create(BonDeCommande bonDeCommande);

    void edit(BonDeCommande bonDeCommande);

    void remove(BonDeCommande bonDeCommande);

    BonDeCommande find(Object id);

    List<BonDeCommande> findAll();

    List<BonDeCommande> findRange(int[] range);

    int count();

    

    public Collection<BonDeCommande> rechercherCommande(Date dateCommande, int idFournisseur, int idArticle);
    public Collection<BonDeCommande> rechercherCommandeParArticle( int idArticle);

    public Collection <BonDeCommande> getBonDeCommandes();

    public BonDeCommande rechercherBonDeCommandeParId(int id);

  

    public Collection<BonDeCommande> rechercherBonDeCommandeParMagasin(Magasin mag);

    public BonDeCommande creerBonDeCommande(ChefDeRayon cdr, Date dateCreation, Fournisseur fournisseur);

    public Collection<BonDeCommande> rechercherBonDeCommandeParFournisseur(Fournisseur fournisseur);

    public BonDeCommande rechercherBonDeCommandeParFournisseurDateEtChef(Fournisseur fournisseur, Date dateCreation, ChefDeRayon cdr);

    public Collection<BonDeCommande> listerCommandesParRayon(Rayon r);
    
    
    
}
