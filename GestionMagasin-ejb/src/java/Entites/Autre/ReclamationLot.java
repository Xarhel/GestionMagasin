/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 5153218
 */
@Entity
public class ReclamationLot implements Serializable {

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
        if (!(object instanceof ReclamationLot)) {
            return false;
        }
        ReclamationLot other = (ReclamationLot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.ReclamationLot[ id=" + id + " ]";
    }

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

    private String motifReclamationDetail;

    /**
     * Get the value of motifReclamationDetail
     *
     * @return the value of motifReclamationDetail
     */
    public String getMotifReclamationDetail() {
        return motifReclamationDetail;
    }

    /**
     * Set the value of motifReclamationDetail
     *
     * @param motifReclamationDetail new value of motifReclamationDetail
     */
    public void setMotifReclamationDetail(String motifReclamationDetail) {
        this.motifReclamationDetail = motifReclamationDetail;
    }

}
