/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Article;
import Entites.Personne.Client;
import java.sql.Date;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author 5153218
 */
@Local
public interface ClientSessionLocal {

    

  

    public void creerClient(String nom, String prenom, String login, String password, String adresseEmail, java.util.Date dateNaissance, String telephone);

    public void creerAdresse(Client client, String libelleAdresse, String rueNom, String rueComplement, int codePostal, String ville);

    public Collection<Article> rechercherArticleParLibelle(String libelle);

    public Article rechercherArticleParReference(int reference);
    
}
