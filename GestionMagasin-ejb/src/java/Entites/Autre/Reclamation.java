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
import javax.persistence.OneToOne;

/**
 *
 * @author 5153218
 */
@Entity
public class Reclamation implements Serializable {

    @OneToOne(mappedBy = "laReclamation")
    private Livraison livraison;

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
        if (!(object instanceof Reclamation)) {
            return false;
        }
        Reclamation other = (Reclamation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Reclamation[ id=" + id + " ]";
    }
    @Column (nullable=false)
    private String motifReclamationGeneral;

    /**
     * Get the value of motifReclamationGeneral
     *
     * @return the value of motifReclamationGeneral
     */
    public String getMotifReclamationGeneral() {
        return motifReclamationGeneral;
    }

    /**
     * Set the value of motifReclamationGeneral
     *
     * @param motifReclamationGeneral new value of motifReclamationGeneral
     */
    public void setMotifReclamationGeneral(String motifReclamationGeneral) {
        this.motifReclamationGeneral = motifReclamationGeneral;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

}
