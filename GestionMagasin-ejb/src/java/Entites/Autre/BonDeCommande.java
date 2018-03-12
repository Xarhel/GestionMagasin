/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import Entites.Lot.Lot;
import Entites.Personne.ChefDeRayon;
import Entites.Personne.Fournisseur;
import java.io.Serializable;
import java.sql.Date;
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
public class BonDeCommande implements Serializable {

    @OneToMany(mappedBy = "leBonDeCommande")
    private List<CommandeLot> commandeLots;

    @OneToMany(mappedBy = "leBonDeCommande")
    private List<Livraison> livraisons;

    

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
        if (!(object instanceof BonDeCommande)) {
            return false;
        }
        BonDeCommande other = (BonDeCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.BonDeCommande[ id=" + id + " ]";
    }
    
    @Column (nullable=false)
    private Date dateCommande;

    /**
     * Get the value of dateCommande
     *
     * @return the value of dateCommande
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * Set the value of dateCommande
     *
     * @param dateCommande new value of dateCommande
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @ManyToOne
        private ChefDeRayon leChefDeRayon;

    /**
     * Get the value of leChefDeRayon
     *
     * @return the value of leChefDeRayon
     */
    public ChefDeRayon getLeChefDeRayon() {
        return leChefDeRayon;
    }

    /**
     * Set the value of leChefDeRayon
     *
     * @param leChefDeRayon new value of leChefDeRayon
     */
    public void setLeChefDeRayon(ChefDeRayon leChefDeRayon) {
        this.leChefDeRayon = leChefDeRayon;
    }

    @ManyToOne
        private Fournisseur leFournisseur;

    /**
     * Get the value of leFournisseur
     *
     * @return the value of leFournisseur
     */
    public Fournisseur getLeFournisseur() {
        return leFournisseur;
    }

    /**
     * Set the value of leFournisseur
     *
     * @param leFournisseur new value of leFournisseur
     */
    public void setLeFournisseur(Fournisseur leFournisseur) {
        this.leFournisseur = leFournisseur;
    }

    
}
