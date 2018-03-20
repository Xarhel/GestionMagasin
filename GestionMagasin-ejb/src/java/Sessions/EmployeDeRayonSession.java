/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.BonDeCommande;
import Entites.Autre.CommandeLot;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import Entites.Autre.Stock;
import Entites.Lot.Lot;
import facades.BonDeCommandeFacadeLocal;
import facades.CommandeLotFacadeLocal;
import facades.MagasinFacade;
import facades.MagasinFacadeLocal;
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
    private BonDeCommandeFacadeLocal bonDeCommandeFacade;

    @EJB
    private CommandeLotFacadeLocal commandeLotFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

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
     
     
    @Override
     public Collection <BonDeCommande> rechercherParMagasin(int idMagasin)
     {
         Magasin mag= magasinFacade.rechercherMagasinParId(idMagasin);
         
         Collection <BonDeCommande> bdc= bonDeCommandeFacade.rechercherBonDeCommandeParMagasin(mag);
         
         return bdc;
         
         
     }
     
}
