/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Adresse;
import Entites.Autre.Article;
import Entites.Personne.Client;
import facades.AdresseFacadeLocal;
import facades.ArticleFacadeLocal;
import facades.ClientFacadeLocal;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 5153218
 */
@Stateless
public class ClientSession implements ClientSessionLocal {

    @EJB
    private ArticleFacadeLocal articleFacade;

    @EJB
    private AdresseFacadeLocal adresseFacade;

 

    @EJB
    private ClientFacadeLocal clientFacade;
   

    @Override
    public void creerClient(String nom, String prenom, String login, String password, String adresseEmail, Date dateNaissance, String telephone)
    {
       clientFacade.creerClient(nom, prenom, login, password, adresseEmail, dateNaissance, telephone);
    }

    @Override
    public void creerAdresse(Client client, String libelleAdresse, String rueNom, String rueComplement, int codePostal, String ville)
    {
        Adresse adresse=adresseFacade.creerAdresse(libelleAdresse, rueNom, rueComplement, codePostal, ville);
        
        clientFacade.associerAdresse(adresse, client);
        
        
    }
    
    @Override
    public Collection <Article> rechercherArticleParLibelle(String libelle)
    {
       Collection <Article> resultat= articleFacade.rechercherArticleParLibelle(libelle);
       
       return resultat;
        
    }
    
    @Override
    public Article rechercherArticleParReference(int reference)
    {
        Article resultat=articleFacade.rechercheArticleParReference(reference);
        
        return resultat;
    }
    

    

    
}
