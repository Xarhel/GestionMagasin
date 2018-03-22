/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.BonDeCommande;
import Entites.Autre.Livraison;
import Entites.Autre.Magasin;
import Entites.Enum.StatutLivraison;
import Entites.Personne.AgentDeLivraison;
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
public class LivraisonFacade extends AbstractFacade<Livraison> implements LivraisonFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivraisonFacade() {
        super(Livraison.class);
    }
    
    
    @Override
    public void creerLivraison(BonDeCommande bdc, AgentDeLivraison adl, Date dateCreationCommande)
    {
        Livraison l=new Livraison();
        l.setLeBonDeCommande(bdc);
        l.setDateCreationLivraison(dateCreationCommande);
        l.setlAgentDeLivraison(adl);
        l.setStatutLivraison(StatutLivraison.enCours);
        em.persist(l);
        
        
    }
    
    
    @Override
    public Collection <Livraison> afficherLivraisonsEnCours (Magasin magasin) {
    
        Collection<Livraison> result;
        
        Query req = getEntityManager().createQuery("select l from Livraison l join l.leBonDeCommande bdc join bdc.leChefDeRayon cdr join cdr.leMagasin mag Where l.statutLivraison =:encours And cdr.leMagasin=:magasin");
        req.setParameter("magasin", magasin);
        req.setParameter("encours", StatutLivraison.enCours);
        result = req.getResultList();
        
        
        
    return result;
    }
    
    @Override
    public void recevoirLivraison(Livraison livraison, Date dateReception)
    {
        
        livraison.setDateReceptionLivraison(dateReception);
        livraison.setStatutLivraison(StatutLivraison.livree);
        
        em.merge(livraison);
    }
    
    
    @Override
    public Livraison rechercherLivraisonParId(int idLivraison)
    {
        Livraison result;
    
        Query req = getEntityManager().createQuery("SELECT liv FROM Livraison AS liv WHERE liv.id=:idLivraison");
        req.setParameter("idLivraison", idLivraison);
        
        result = (Livraison) req.getSingleResult();
        
        return result;
    }
    
}
