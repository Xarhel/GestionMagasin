/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Personne.GerantMagasin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface GerantMagasinFacadeLocal {

    void create(GerantMagasin gerantMagasin);

    void edit(GerantMagasin gerantMagasin);

    void remove(GerantMagasin gerantMagasin);

    GerantMagasin find(Object id);

    List<GerantMagasin> findAll();

    List<GerantMagasin> findRange(int[] range);

    int count();
    
}
