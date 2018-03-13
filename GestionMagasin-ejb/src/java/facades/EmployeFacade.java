/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Personne.Employe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 3137574
 */
@Stateless
public class EmployeFacade extends AbstractFacade<Employe> implements EmployeFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeFacade() {
        super(Employe.class);
    }

    @Override
    public Employe chercherEmployeParId(int id) {
        Employe result;
    
        Query req = getEntityManager().createQuery("SELECT e FROM Employe AS e WHERE e.id =: id");
        req.setParameter("idMagasin", id);
        
        result = (Employe) req.getSingleResult();
        
        return result;
    }
    
    
}
