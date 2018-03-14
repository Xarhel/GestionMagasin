/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.BonDeCommande;
import Entites.Autre.CommandeLot;
import Entites.Lot.Lot;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface CommandeLotFacadeLocal {

    void create(CommandeLot commandeLot);

    void edit(CommandeLot commandeLot);

    void remove(CommandeLot commandeLot);

    CommandeLot find(Object id);

    List<CommandeLot> findAll();

    List<CommandeLot> findRange(int[] range);

    int count();

    void creerCommandeLot(Lot lot, BonDeCommande commande, float prixAchat);
    
}
