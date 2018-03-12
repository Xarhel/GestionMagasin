/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import facades.ClientFacadeLocal;
import java.sql.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 5153218
 */
@Stateless
public class ClientSession implements ClientSessionLocal {

    @EJB
    private ClientFacadeLocal clientFacade;
   

    @Override
    public void creerClient(String adresseEmail, int idAdresseFacturation, int idAdresseLivraison, Date dateNaissance, int telephone) {
       clientFacade.creerClient(adresseEmail, idAdresseFacturation, idAdresseLivraison, dateNaissance, telephone);
    }

    
}
