/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Autre.BonDeCommande;
import Entites.Personne.Fournisseur;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 3137574
 */
@Stateless
public class BonDeCommandeFacade extends AbstractFacade<BonDeCommande> implements BonDeCommandeFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BonDeCommandeFacade() {
        super(BonDeCommande.class);
    }
    
     //Méthode pour créer le bon de commande
    
    @Override
    public void creerBonDeCommande(Date dateCommande) {
        BonDeCommande bd= new BonDeCommande();
        bd.setDateCommande(dateCommande);
        em.persist(bd);
    }
    
    // Méthode pour rechercher de commande par date commande, par fourniseur et par article
    
    @Override
    public Collection<BonDeCommande> rechercherCommande(Date dateCommande, int idFournisseur, int idArticle) {
        Collection<BonDeCommande> result;
    
        Query req = getEntityManager().createQuery("SELECT bc FROM BonDeCommande AS bc WHERE bc.leFournisseur.id =: idFournisseur and bc.commandeLots.leLot.lArticle.id =: idArticle ");
        req.setParameter("dateCommande", dateCommande);
        req.setParameter("idFournisseur", idFournisseur);
        req.setParameter("idArticle", idArticle);
        
        result = req.getResultList();
        
        return result;
        
    }
    // Méthode pour rechercher des commandes par article
    
    @Override
    public Collection <BonDeCommande> rechercherCommandeParArticle( int idArticle) {
        Collection<BonDeCommande> result;
    
        Query req = getEntityManager().createQuery("SELECT bc FROM BonDeCommande AS bc WHERE bc.commandeLots.leLot.lArticle.id =: idArticle ");      
        req.setParameter("idArticle", idArticle);      
        result = req.getResultList();      
        return result;
    }
    
    // Méthode pour consulter les commandes
    @Override
    public Collection <BonDeCommande> getBonDeCommandes() {
           Collection <BonDeCommande> liste= null;
        String txt ="SELECT a FROM BonDeComande AS a";
        Query req;
        req = getEntityManager().createQuery(txt);
        try{
        liste = req.getResultList();
            }catch(Exception e){e.getMessage();}
        return liste;
        
    }
    
    
}

