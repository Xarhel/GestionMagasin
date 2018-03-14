/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Livraison;
import Entites.Autre.Reclamation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface ReclamationFacadeLocal {

    void create(Reclamation reclamation);

    void edit(Reclamation reclamation);

    void remove(Reclamation reclamation);

    Reclamation find(Object id);

    List<Reclamation> findAll();

    List<Reclamation> findRange(int[] range);

    int count();

    public void creerReclamation(Livraison l, String motif);
    
}
