/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Vente;

import Entites.Enum.MoyenPaiement;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author 6137220
 */

@Entity
@Inheritance
(strategy=InheritanceType.JOINED)
public class Panier implements Serializable {

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
        if (!(object instanceof Panier)) {
            return false;
        }
        Panier other = (Panier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.Panier[ id=" + id + " ]";
    }
    
    @Column (nullable=false)
        private Date dateJour;

    /**
     * Get the value of dateJour
     *
     * @return the value of dateJour
     */
    public Date getDateJour() {
        return dateJour;
    }

    /**
     * Set the value of dateJour
     *
     * @param dateJour new value of dateJour
     */
    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    
        private float montantTotal;

    /**
     * Get the value of montantTotal
     *
     * @return the value of montantTotal
     */
    public float getMontantTotal() {
        return montantTotal;
    }

    /**
     * Set the value of montantTotal
     *
     * @param montantTotal new value of montantTotal
     */
    public void setMontantTotal(float montantTotal) {
        this.montantTotal = montantTotal;
    }

    @Column (nullable=false)
        private MoyenPaiement moyenPaiement;

    /**
     * Get the value of moyenPaiement
     *
     * @return the value of moyenPaiement
     */
    public MoyenPaiement getMoyenPaiement() {
        return moyenPaiement;
    }

    /**
     * Set the value of moyenPaiement
     *
     * @param moyenPaiement new value of moyenPaiement
     */
    public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    
        private Boolean Paiement;

    /**
     * Get the value of Paiement
     *
     * @return the value of Paiement
     */
    public Boolean getPaiement() {
        return Paiement;
    }

    /**
     * Set the value of Paiement
     *
     * @param Paiement new value of Paiement
     */
    public void setPaiement(Boolean Paiement) {
        this.Paiement = Paiement;
    }

    
}
