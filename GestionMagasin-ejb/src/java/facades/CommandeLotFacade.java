/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.CommandeLot;
import Entites.Lot.Lot;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Entites.Autre.BonDeCommande;
import Entites.Autre.Magasin;
import java.util.List;

/**
 *
 * @author 3137574
 */
@Stateless
public class CommandeLotFacade extends AbstractFacade<CommandeLot> implements CommandeLotFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeLotFacade() {
        super(CommandeLot.class);
    }

    @Override
    public void creerCommandeLot(Lot lot, BonDeCommande commande, float prixAchat) {
        CommandeLot commandeLot = new CommandeLot();
        commandeLot.setLeLot(lot);
        commandeLot.setLeBonDeCommande(commande);
       
        commandeLot.setPrixAchat(prixAchat);
        em.persist(commandeLot);
    } 
    
    
    @Override
    public Collection <CommandeLot> rechercherCommandeLotParIdBonDeCommande(BonDeCommande bonDeCommande)
    {
        Collection <CommandeLot> result;
    
        Query req = getEntityManager().createQuery("SELECT cl FROM CommandeLot AS cl WHERE cl.leBonDeCommande=:bonDeCommande");
        req.setParameter("bonDeCommande", bonDeCommande);
        
        result = req.getResultList();
        
        return result;
        
        
    }
    
    @Override
    public CommandeLot rechercherCommandeLotParId(int cl)
    {
        CommandeLot result;
    
        Query req = getEntityManager().createQuery("SELECT c FROM CommandeLot AS c WHERE c.id=:cl");
        req.setParameter("cl", cl);
        List <CommandeLot> commandes = req.getResultList();
        
        result = commandes.get(0);
        
        return result;
        
        
    }
    
    
     
}
