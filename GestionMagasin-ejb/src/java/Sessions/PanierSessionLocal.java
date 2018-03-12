/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Enum.MoyenPaiement;
import java.sql.Date;
import javax.ejb.Local;

/**
 *
 * @author 5153218
 */
@Local
public interface PanierSessionLocal {

    void creerPanier(Date dateJour, MoyenPaiement moyenPaiement, float montantTotal);
    
}
