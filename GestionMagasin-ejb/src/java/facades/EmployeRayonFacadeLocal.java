/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Personne.EmployeRayon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface EmployeRayonFacadeLocal {

    void create(EmployeRayon employeRayon);

    void edit(EmployeRayon employeRayon);

    void remove(EmployeRayon employeRayon);

    EmployeRayon find(Object id);

    List<EmployeRayon> findAll();

    List<EmployeRayon> findRange(int[] range);

    int count();
    
}
