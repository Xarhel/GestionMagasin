/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import facades.PanierCaisseFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 5153218
 */
@Stateless
public class PanierCaisseSession implements PanierCaisseSessionLocal {

    @EJB
    private PanierCaisseFacadeLocal panierCaisseFacade;
    

    @Override
    public void creerPanierCaisse() {
        panierCaisseFacade.creerPanierCaisse();
    }

    
}
