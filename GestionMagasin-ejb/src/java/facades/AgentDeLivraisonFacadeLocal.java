/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.AgentDeLivraison;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 3137574
 */
@Local
public interface AgentDeLivraisonFacadeLocal {

    void create(AgentDeLivraison agentDeLivraison);

    void edit(AgentDeLivraison agentDeLivraison);

    void remove(AgentDeLivraison agentDeLivraison);

    AgentDeLivraison find(Object id);

    List<AgentDeLivraison> findAll();

    List<AgentDeLivraison> findRange(int[] range);

    int count();

    public void modifierAgentDeLivraison(AgentDeLivraison ADL, String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon);

    public void creerAgentDeLivraison(String nom, String prenom, String login, String mdp, Date dateCreationCompte, TypeCompte typeCompte, Magasin magasin, Rayon rayon);

    public void supprimerAgentDeLivraison(AgentDeLivraison ADL);
    
}
