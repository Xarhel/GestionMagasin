/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import Entites.Personne.Fournisseur;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author 6137220
 */
@Entity
public class FournisseurMagasin implements Serializable {

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
        if (!(object instanceof FournisseurMagasin)) {
            return false;
        }
        FournisseurMagasin other = (FournisseurMagasin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autre.FournisseurMagasin[ id=" + id + " ]";
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
