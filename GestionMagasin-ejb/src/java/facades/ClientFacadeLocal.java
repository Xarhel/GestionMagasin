/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Article;
import Entites.Personne.Client;
import java.sql.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();
     void creerClient(String adresseEmail, int idAdresseFacturation, int idAdresseLivraison, Date dateNaissance, int telephone);

    
}
