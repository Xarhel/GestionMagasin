/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Enum.MoyenPaiement;
import Entites.Personne.EmployeDeCaisse;
import Entites.Vente.PanierCaisse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 3137574
 */
@Stateless
public class PanierCaisseFacade extends AbstractFacade<PanierCaisse> implements PanierCaisseFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PanierCaisseFacade() {
        super(PanierCaisse.class);
    }

    @Override
    public void creerPanierCaisse(EmployeDeCaisse edc) {
        PanierCaisse pc= new PanierCaisse();
        pc.setlEmployeDeCaisse(edc);
        pc.setPaiement(Boolean.FALSE);
        em.persist(pc);
    }
    
    @Override
    public void choisirModeDePaiement(PanierCaisse pc , MoyenPaiement typeDePaiement)
    {
        pc.setMoyenPaiement(typeDePaiement);
        em.merge(pc);
        
        
        
    }
    
    @Override
    public boolean validerLePaiement(PanierCaisse pc)
            
    {
        pc.setPaiement(Boolean.TRUE);
        
        em.merge(pc);
        boolean result = pc.getPaiement();
        
        return result;
        
        
        
        
    }
    
    
    
    
}
