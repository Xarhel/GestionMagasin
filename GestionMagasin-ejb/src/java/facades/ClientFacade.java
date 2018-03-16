/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Adresse;
import Entites.Autre.Article;
import Entites.Personne.Client;
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
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "GestionMagasin-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    @Override
    public void creerClient(String nom, String prenom, String login, String password, String adresseEmail, Date dateNaissance, String telephone) {
        Client cl= new Client();
        cl.setNomPersonne(nom);
        cl.setPrenomPersonne(prenom);
        cl.setLogin(login);
        cl.setPassword(password);
        
        Date dateActuelle= new Date();
        cl.setDateCreationCompte(dateActuelle);
        
        
        cl.setAdresseEmail(adresseEmail);
        cl.setDateNaissance((java.sql.Date) dateNaissance);
        cl.setTelephone(telephone);
        
        em.persist(cl);
    }

    @Override
    public void associerAdresse(Adresse a, Client c)
    {
        List <Adresse> listeAdresse=c.getAdresses();
        listeAdresse.add(a);
        c.setAdresses(listeAdresse);
        em.merge(c);
       
    }
    
    
    @Override
    public Client rechercherClientParId(int id)
    {
    Client result;
    
        Query req = getEntityManager().createQuery("SELECT cl FROM Client AS cl WHERE cl.id=:id");
        req.setParameter("id", id);
        
        result = (Client) req.getSingleResult();
        
        return result;
        
        
    }
  
}
