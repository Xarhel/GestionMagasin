/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.CommandeLot;
import Entites.Autre.Livraison;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface AgentDeLivraisonSessionLocal {

    public void enregistrerLivraison(Date dateReception, int idLivraison);

    public Collection<CommandeLot> AfficherCommandeLots(int idLivraison);

    public void enregistrerLivraisonLots(int idLivraison, int idCommandeLot, int quantiteAcceptee, int quantiteExpediee, int quantiteLivree, Date date, String taille, int duree);

    public Collection<Livraison> listerLivraisonEnCours(long idMagasin);
    
}
