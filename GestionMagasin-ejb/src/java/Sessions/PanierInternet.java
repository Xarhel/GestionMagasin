/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Enum.TypeLivraison;
import facades.PanierInternetFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 5153218
 */
@Stateless
public class PanierInternet implements PanierInternetLocal {

    @EJB
    private PanierInternetFacadeLocal panierInternetFacade;
    

    @Override
    public void creerPanierInternet(TypeLivraison TypeLivraison) {
        panierInternetFacade.creerPanierInternet(TypeLivraison);
        
    }
  
}
