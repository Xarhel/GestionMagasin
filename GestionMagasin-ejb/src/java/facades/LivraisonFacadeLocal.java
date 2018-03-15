/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.BonDeCommande;
import Entites.Autre.Livraison;
import Entites.Personne.AgentDeLivraison;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface LivraisonFacadeLocal {

    void create(Livraison livraison);

    void edit(Livraison livraison);

    void remove(Livraison livraison);

    Livraison find(Object id);

    List<Livraison> findAll();

    List<Livraison> findRange(int[] range);

    int count();

    public void creerLivraison(BonDeCommande bdc, AgentDeLivraison adl, Date dateCreationCommande);

    public void recevoirLivraison(Livraison livraison, Date dateReception);
    
}
