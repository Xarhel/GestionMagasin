/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Enum.MoyenPaiement;
import Entites.Enum.TypeLivraison;
import Entites.Personne.Client;
import Entites.Vente.Panier;
import Entites.Vente.PanierInternet;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class PanierInternetFacade extends AbstractFacade<PanierInternet> implements PanierInternetFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PanierInternetFacade() {
        super(PanierInternet.class);
    }

   @Override
    public PanierInternet creerPanier(MoyenPaiement moyenPaiement, Client c, Magasin mag,TypeLivraison typeLivraison) {
        PanierInternet p= new PanierInternet();
        
        Date dateDuJour= new Date();
        p.setDateJour((java.sql.Date) dateDuJour);
        p.setMontantTotal(0);
        p.setMoyenPaiement(moyenPaiement);
        p.setLeMagasin(mag);
        p.setLeClient(c);
        p.setTypeLivraison(typeLivraison);
        
        em.persist(p);
        return p;
    }
    

    
}
