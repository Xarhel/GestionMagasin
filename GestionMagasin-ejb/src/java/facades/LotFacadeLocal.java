/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Lot.Lot;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface LotFacadeLocal {

    void create(Lot lot);

    void edit(Lot lot);

    void remove(Lot lot);

    Lot find(Object id);

    List<Lot> findAll();

    List<Lot> findRange(int[] range);

    int count();

    Lot creerLotGeneral(Article lArticle, int quantite);

    public void ajouterDatePeremption (Lot l, Date date);

    public void ajouterTaille (Lot l, String taille);

    public void ajouterDureeGarantie (Lot l, int garantie);
    
}
