/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Vente.ArticleVente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface ArticleVenteFacadeLocal {

    void create(ArticleVente articleVente);

    void edit(ArticleVente articleVente);

    void remove(ArticleVente articleVente);

    ArticleVente find(Object id);

    List<ArticleVente> findAll();

    List<ArticleVente> findRange(int[] range);

    int count();
    
}