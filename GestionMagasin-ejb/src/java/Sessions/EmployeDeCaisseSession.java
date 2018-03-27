/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Autre.Magasin;
import Entites.Autre.RayonArticle;
import Entites.Autre.Stock;
import Entites.Personne.EmployeDeCaisse;
import Entites.Vente.ArticleVente;
import Entites.Vente.PanierCaisse;
import facades.ArticleFacadeLocal;
import facades.ArticleVenteFacadeLocal;
import facades.EmployeDeCaisseFacadeLocal;
import facades.MagasinFacadeLocal;
import facades.PanierCaisseFacadeLocal;
import facades.RayonArticleFacadeLocal;
import facades.RayonFacadeLocal;
import facades.StockFacadeLocal;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6137220
 */
@Stateless
public class EmployeDeCaisseSession implements EmployeDeCaisseSessionLocal {

    @EJB
    private RayonArticleFacadeLocal rayonArticleFacade;

    @EJB
    private ArticleVenteFacadeLocal articleVenteFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private StockFacadeLocal stockFacade;

    @EJB
    private ArticleFacadeLocal articleFacade;

    @EJB
    private RayonFacadeLocal rayonFacade;

    @EJB
    private PanierCaisseFacadeLocal panierCaisseFacade;

    @EJB
    private EmployeDeCaisseFacadeLocal employeDeCaisseFacade;
    
    
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
    @Override
    public long creerPanierCaisse(int idEmployeDeCaisse)
    { 
        EmployeDeCaisse edc = employeDeCaisseFacade.rechercherEmployeDeCaisse(idEmployeDeCaisse);
        PanierCaisse pc = panierCaisseFacade.creerPanierCaisse(edc);
        long idPanierCaisse = pc.getId();
        
        return idPanierCaisse;
    }
    
    @Override
    public void ajouterArticleVente (long idPanier, int referenceArticle, int quantite, float prixUnitaire, int idMagasin)
    {
        PanierCaisse pc= panierCaisseFacade.chercherPanierCaisseParId(idPanier);
        Article a= articleFacade.rechercheArticleParReference(referenceArticle);
        Magasin m = magasinFacade.rechercherMagasinParId(idMagasin);

        List<Stock> stocks=    (List<Stock>) stockFacade.chercherMagasinStockParReferenceArticle(referenceArticle, m);

       
        Stock s= stocks.get(0) ;
        
        articleVenteFacade.creerArticleVenteCaisse(pc, quantite, prixUnitaire, s);
        
    }

    @Override
    public Collection rechercherRayonArticleParIdMagasin(int idMagasin) {
        Collection<RayonArticle> rayonArticle = rayonArticleFacade.rechercherRayonArticleParIdMagasin(idMagasin);
        return rayonArticle;
    }

    @Override
    public RayonArticle rechercherRayonArticleParId(int idRayonArticle) {
        RayonArticle ra = rayonArticleFacade.chercherRayonArticleParId(idRayonArticle);
        return ra;
    }

    @Override
    public Collection<ArticleVente> rechercherArticleVenteParPanier(long idPanier) {
        Collection<ArticleVente> av = articleVenteFacade.rechercherArticleVenteParPanier(idPanier);       
        return av;
    }
    
    
    
    
    
    
}
