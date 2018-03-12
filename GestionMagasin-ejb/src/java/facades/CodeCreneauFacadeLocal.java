/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Vente.CodeCreneau;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface CodeCreneauFacadeLocal {

    void create(CodeCreneau codeCreneau);

    void edit(CodeCreneau codeCreneau);

    void remove(CodeCreneau codeCreneau);

    CodeCreneau find(Object id);

    List<CodeCreneau> findAll();

    List<CodeCreneau> findRange(int[] range);

    int count();
    
}
