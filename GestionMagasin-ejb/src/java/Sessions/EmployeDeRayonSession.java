/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import Entites.Autre.Stock;
import Entites.Lot.Lot;
import facades.RayonArticleFacadeLocal;
import facades.StockFacadeLocal;
import facades.StockRetraitFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6137220
 */


@Stateless
public class EmployeDeRayonSession implements EmployeDeRayonSessionLocal {

    @EJB
    private StockRetraitFacadeLocal stockRetraitFacade;

    @EJB
    private StockFacadeLocal stockFacade;

    @EJB
    private RayonArticleFacadeLocal rayonArticleFacade;

    

    public RayonArticle RechercheArticleParLibelle(Rayon r, String libelle)
    {
       RayonArticle resultat= rayonArticleFacade.rechercherRayonArticleParLibelle(r, libelle);
        return resultat;
    }
    
     public RayonArticle RechercheArticleParReference(Rayon r, int reference)
    {
       RayonArticle resultat= rayonArticleFacade.rechercherRayonArticleParReference(r, reference);
        return resultat;
    }
    
     
     public void retirerStock(int quantite, Rayon r, Article a, Lot l)
     {
         
         
        Stock s= stockFacade.rechercherStock(a.getId(), l.getId(), r.getId());
        stockFacade.retirerStockDuRayon(s, quantite);
        
        
        // a terminer, galère
      
        
     }
}
