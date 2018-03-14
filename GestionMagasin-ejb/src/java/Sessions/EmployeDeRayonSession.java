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
import java.util.Collection;
import java.util.Date;
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

    

    @Override
    public RayonArticle RechercheArticleParLibelle(Rayon r, String libelle)
    {
       RayonArticle resultat= rayonArticleFacade.rechercherRayonArticleParLibelle(r, libelle);
        return resultat;
    }
    
    @Override
     public RayonArticle RechercheArticleParReference(Rayon r, int reference)
    {
       RayonArticle resultat= rayonArticleFacade.rechercherRayonArticleParReference(r, reference);
        return resultat;
    }
    
     
    @Override
     public void retirerStockPerime(Date date, Rayon r)
     {
         Collection<Stock> s = stockFacade.rechercherLotRayonPerimeParDate(date, r);
         stockRetraitFacade.retirerStockPerime(s, date);
         stockFacade.retirerStockPerimeRayon(s);
         
     }
}
