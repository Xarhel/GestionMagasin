/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Personne.Direction;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface DirectionFacadeLocal {

    void create(Direction direction);

    void edit(Direction direction);

    void remove(Direction direction);

    Direction find(Object id);

    List<Direction> findAll();

    List<Direction> findRange(int[] range);

    int count();
    
}
