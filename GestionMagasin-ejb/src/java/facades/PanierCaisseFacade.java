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
import javax.persistence.Query;

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
    public PanierCaisse creerPanierCaisse(EmployeDeCaisse edc) {
        PanierCaisse pc= new PanierCaisse();
        pc.setlEmployeDeCaisse(edc);
        pc.setPaiement(Boolean.FALSE);
        em.persist(pc);
        return pc;
    }
    
    @Override
    public void ajouterTotal (float prixTotal, PanierCaisse pc) {
        pc.setMontantTotal(prixTotal);
        em.merge(pc);
    
    }
    @Override
    public PanierCaisse chercherPanierCaisseParId (long id){
    PanierCaisse pc;
    Query req = getEntityManager().createQuery("select pc from PanierCaisse pc WHERE pc.id=:id");
    req.setParameter("id", id);
    pc = (PanierCaisse) req.getSingleResult();
    return pc;
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
