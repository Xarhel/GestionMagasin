/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Personne.EmployeDeCaisse;
import Entites.Vente.PanierCaisse;
import facades.EmployeDeCaisseFacadeLocal;
import facades.PanierCaisseFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6137220
 */
@Stateless
public class EmployeDeCaisseSession implements EmployeDeCaisseSessionLocal {

    @EJB
    private PanierCaisseFacadeLocal panierCaisseFacade;

    @EJB
    private EmployeDeCaisseFacadeLocal employeDeCaisseFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
    @Override
    public long creerPanierCaisse(int idEmployeDeCaisse)
    { 
        EmployeDeCaisse edc=employeDeCaisseFacade.rechercherEmployeDeCaisse(idEmployeDeCaisse);
        PanierCaisse pc= panierCaisseFacade.creerPanierCaisse(edc);
        long idPanierCaisse= pc.getId();
        
        return idPanierCaisse;
    }
    
    public void ajouterArticleVente (long idPanier, )
    
}
