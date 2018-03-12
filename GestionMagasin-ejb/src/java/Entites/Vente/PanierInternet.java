/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Vente;

import Entites.Autre.Magasin;
import Entites.Enum.TypeLivraison;
import Entites.Personne.Client;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 6137220
 */
@Entity
public class PanierInternet extends Panier implements Serializable {

    @OneToMany(mappedBy = "lePanierInternet")
    private List<ArticleVente> articleVentes;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PanierInternet)) {
            return false;
        }
        PanierInternet other = (PanierInternet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.PanierInternet[ id=" + id + " ]";
    }
    
    @Column (nullable=false)
        private TypeLivraison typeLivraison;

    /**
     * Get the value of typeLivraison
     *
     * @return the value of typeLivraison
     */
    public TypeLivraison getTypeLivraison() {
        return typeLivraison;
    }

    /**
     * Set the value of typeLivraison
     *
     * @param typeLivraison new value of typeLivraison
     */
    public void setTypeLivraison(TypeLivraison typeLivraison) {
        this.typeLivraison = typeLivraison;
    }

    @ManyToOne
        private Creneau leCreneau;

    /**
     * Get the value of leCreneau
     *
     * @return the value of leCreneau
     */
    public Creneau getLeCreneau() {
        return leCreneau;
    }

    /**
     * Set the value of leCreneau
     *
     * @param leCreneau new value of leCreneau
     */
    public void setLeCreneau(Creneau leCreneau) {
        this.leCreneau = leCreneau;
    }

    @ManyToOne
        private Client leClient;

    /**
     * Get the value of leClient
     *
     * @return the value of leClient
     */
    public Client getLeClient() {
        return leClient;
    }

    /**
     * Set the value of leClient
     *
     * @param leClient new value of leClient
     */
    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

    
    @ManyToOne
        private Magasin leMagasin;

    /**
     * Get the value of leMagasin
     *
     * @return the value of leMagasin
     */
    public Magasin getLeMagasin() {
        return leMagasin;
    }

    /**
     * Set the value of leMagasin
     *
     * @param leMagasin new value of leMagasin
     */
    public void setLeMagasin(Magasin leMagasin) {
        this.leMagasin = leMagasin;
    }

    
    
}
