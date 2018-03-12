/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import Entites.Lot.Lot;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author 5153218
 */
@Entity
public class CommandeLot implements Serializable {

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
        if (!(object instanceof CommandeLot)) {
            return false;
        }
        CommandeLot other = (CommandeLot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.CommandeLot[ id=" + id + " ]";
    }
    
    @Column (nullable=false)
    private int quantite;

    /**
     * Get the value of quantite
     *
     * @return the value of quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Set the value of quantite
     *
     * @param quantite new value of quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Column (nullable=false)
    private float prixAchat;

    /**
     * Get the value of prixAchat
     *
     * @return the value of prixAchat
     */
    public float getPrixAchat() {
        return prixAchat;
    }

    /**
     * Set the value of prixAchat
     *
     * @param prixAchat new value of prixAchat
     */
    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    @ManyToOne
        private BonDeCommande leBonDeCommande;

    /**
     * Get the value of leBonDeCommande
     *
     * @return the value of leBonDeCommande
     */
    public BonDeCommande getLeBonDeCommande() {
        return leBonDeCommande;
    }

    /**
     * Set the value of leBonDeCommande
     *
     * @param leBonDeCommande new value of leBonDeCommande
     */
    public void setLeBonDeCommande(BonDeCommande leBonDeCommande) {
        this.leBonDeCommande = leBonDeCommande;
    }

    
    @ManyToOne
        private Lot leLot;

    /**
     * Get the value of leLot
     *
     * @return the value of leLot
     */
    public Lot getLeLot() {
        return leLot;
    }

    /**
     * Set the value of leLot
     *
     * @param leLot new value of leLot
     */
    public void setLeLot(Lot leLot) {
        this.leLot = leLot;
    }

    
}
