/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface FournisseurSessionLocal {

    public void creerLivraison(int idAgentDeLivraison, int idBonDeCommande, Date dateDebutLivraison);
    
}