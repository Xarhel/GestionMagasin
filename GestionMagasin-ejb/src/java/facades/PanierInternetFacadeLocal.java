/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Enum.MoyenPaiement;
import Entites.Enum.TypeLivraison;
import Entites.Personne.Client;
import Entites.Vente.PanierInternet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface PanierInternetFacadeLocal {

    void create(PanierInternet panierInternet);

    void edit(PanierInternet panierInternet);

    void remove(PanierInternet panierInternet);

    PanierInternet find(Object id);

    List<PanierInternet> findAll();

    List<PanierInternet> findRange(int[] range);

    int count();

   
    public PanierInternet creerPanier(MoyenPaiement moyenPaiement, Client c, Magasin mag,TypeLivraison typeLivraison);
    
}
