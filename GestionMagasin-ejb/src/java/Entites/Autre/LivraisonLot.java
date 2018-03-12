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
import javax.persistence.OneToOne;

/**
 *
 * @author 6137220
 */
@Entity
public class LivraisonLot implements Serializable {

    @OneToOne(mappedBy = "laLivraisonLot")
    private Stock stock;

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
        if (!(object instanceof LivraisonLot)) {
            return false;
        }
        LivraisonLot other = (LivraisonLot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.LivraisonLot[ id=" + id + " ]";
    }  
    
    @Column (nullable=false)
        private int quantiteExpediee;

    /**
     * Get the value of quantiteExpediee
     *
     * @return the value of quantiteExpediee
     */
    public int getQuantiteExpediee() {
        return quantiteExpediee;
    }

    /**
     * Set the value of quantiteExpediee
     *
     * @param quantiteExpediee new value of quantiteExpediee
     */
    public void setQuantiteExpediee(int quantiteExpediee) {
        this.quantiteExpediee = quantiteExpediee;
    }

    @Column (nullable=false)
        private int quantiteLivree;

    /**
     * Get the value of quantiteLivree
     *
     * @return the value of quantiteLivree
     */
    public int getQuantiteLivree() {
        return quantiteLivree;
    }

    /**
     * Set the value of quantiteLivree
     *
     * @param quantiteLivree new value of quantiteLivree
     */
    public void setQuantiteLivree(int quantiteLivree) {
        this.quantiteLivree = quantiteLivree;
    }

    
    @Column (nullable=false)
        private int quantiteAcceptee;

    /**
     * Get the value of quantiteAcceptee
     *
     * @return the value of quantiteAcceptee
     */
    public int getQuantiteAcceptee() {
        return quantiteAcceptee;
    }

    /**
     * Set the value of quantiteAcceptee
     *
     * @param quantiteAcceptee new value of quantiteAcceptee
     */
    public void setQuantiteAcceptee(int quantiteAcceptee) {
        this.quantiteAcceptee = quantiteAcceptee;
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

    
    @ManyToOne
        private Livraison laLivraison;

    /**
     * Get the value of laLivraison
     *
     * @return the value of laLivraison
     */
    public Livraison getLaLivraison() {
        return laLivraison;
    }

    /**
     * Set the value of laLivraison
     *
     * @param laLivraison new value of laLivraison
     */
    public void setLaLivraison(Livraison laLivraison) {
        this.laLivraison = laLivraison;
    }

}
