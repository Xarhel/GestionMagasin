/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.BonDeCommande;
import Entites.Autre.CommandeLot;
import Entites.Lot.Lot;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public Collection<CommandeLot> chercherCommandeLots (BonDeCommande bdc){
    Collection<CommandeLot> result;
    
    Query req = getEntityManager().createQuery("SELECT cl FROM CommandeLot AS cl inner join cl.leBonDeCommande WHERE cl.leBonDeCommande=:bdc" );
        req.setParameter("bdc", bdc);
    result = req.getResultList();
    
    return result;
    
    }
    
}
