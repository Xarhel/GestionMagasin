/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.BonDeCommande;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Personne.ChefDeRayon;
import Entites.Personne.Fournisseur;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
    
   
    
    // Méthode pour rechercher de commande par date commande, par fourniseur et par article
    
    @Override
    public Collection<BonDeCommande> rechercherCommande(Date dateCommande, int idFournisseur, int idArticle) {
        Collection<BonDeCommande> result;
    
        Query req = getEntityManager().createQuery("SELECT bc FROM BonDeCommande AS bc WHERE bc.leFournisseur.id=:idFournisseur and bc.commandeLots.leLot.lArticle.id =:idArticle");
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
    
        Query req = getEntityManager().createQuery("SELECT bc FROM BonDeCommande AS bc WHERE bc.commandeLots.leLot.lArticle.id =:idArticle ");      
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
    
    
    @Override
    public void creerBonDeCommande(ChefDeRayon cdr, Date dateCreation, Fournisseur fournisseur)
    {
        BonDeCommande bdc= new BonDeCommande();
        bdc.setDateCommande(dateCreation);
        bdc.getLeChefDeRayon();
        bdc.setLeFournisseur(fournisseur);
        em.persist(bdc);
        
    }
    
    @Override
    public BonDeCommande rechercherBonDeCommandeParId(int id)
    {
    BonDeCommande result;
    
        Query req = getEntityManager().createQuery("SELECT bdr FROM BonDeCommande AS bdr WHERE bdr.id=:id");
        req.setParameter("id", id);
        List<BonDeCommande> commandes = req.getResultList();
        result= commandes.get(0);
        
        return result;
        
        
    }
    
    @Override
    public Collection <BonDeCommande> rechercherBonDeCommandeParMagasin(Magasin mag)
    {
     Collection <BonDeCommande> result;
    
        Query req = getEntityManager().createQuery("SELECT bdc FROM BonDeCommande AS bdc inner join bdc.leChefDeRayon as cdr WHERE cdr.leMagasin=:mag");
        req.setParameter("mag", mag);
        result = req.getResultList();
        
        return result;
        
        
    }
    
    
    @Override
    public Collection <BonDeCommande> rechercherBonDeCommandeParFournisseur(Fournisseur fournisseur)
    {
         Collection <BonDeCommande> result;
    
        Query req = getEntityManager().createQuery("SELECT bdc FROM BonDeCommande AS bdc  WHERE bdc.leFournisseur=:fournisseur");
        req.setParameter("fournisseur", fournisseur);
        result = req.getResultList();
        
        return result;
    }
    
    @Override
    public  BonDeCommande rechercherBonDeCommandeParFournisseurDateEtChef(Fournisseur fournisseur, Date dateCreation, ChefDeRayon cdr)
    {
        BonDeCommande result;
    
        Query req = getEntityManager().createQuery("SELECT bdc FROM BonDeCommande AS bdc  WHERE bdc.leFournisseur=:fournisseur AND bdc.dateCommande=:dateCreation AND bdc.leChefDeRayon=:cdr");
        req.setParameter("fournisseur", fournisseur);
        req.setParameter("dateCreation", dateCreation);
        req.setParameter("cdr", cdr);
        List<BonDeCommande> commandes = req.getResultList();
        
        result = commandes.get(0);
        
        return result;
    }
    
    @Override
    public Collection <BonDeCommande> listerCommandesParRayon (Rayon r){
    Collection<BonDeCommande> commande;
    Query req = getEntityManager().createQuery("SELECT bdc FROM BonDeCommande AS b join b.leChefDeRayon c   WHERE c.leRayon=:r ");
        req.setParameter("r", r);

        commande = req.getResultList();
    
    return commande;}
    
}

