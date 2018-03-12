/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.RayonArticle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface RayonArticleFacadeLocal {

    void create(RayonArticle rayonArticle);

    void edit(RayonArticle rayonArticle);

    void remove(RayonArticle rayonArticle);

    RayonArticle find(Object id);

    List<RayonArticle> findAll();

    List<RayonArticle> findRange(int[] range);

    int count();
    
}
