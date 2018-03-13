/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Enum.MoyenPaiement;
import java.sql.Date;
import javax.ejb.Stateless;

/**
 *
 * @author 5153218
 */
@Stateless
public class PanierSession implements PanierSessionLocal {

    @Override
    public void creerPanier(Date dateJour, MoyenPaiement moyenPaiement, float montantTotal) {
    }

    
}
