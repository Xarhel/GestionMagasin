/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.CommandeLot;
import Entites.Autre.Livraison;
import Entites.Autre.LivraisonLot;
import Entites.Lot.Lot;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface LivraisonLotFacadeLocal {

    void create(LivraisonLot livraisonLot);

    void edit(LivraisonLot livraisonLot);

    void remove(LivraisonLot livraisonLot);

    LivraisonLot find(Object id);

    List<LivraisonLot> findAll();

    List<LivraisonLot> findRange(int[] range);

    int count();

//    public void creerLivraisonLots(Collection<CommandeLot> listeCommandeLot, Livraison livraison);

    public LivraisonLot creerLivraisonLot(Lot lot, Livraison livraison, int quantiteExpediee, int quantiteAcceptee, int quantiteLivree);
    
}
