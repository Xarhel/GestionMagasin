/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Personne;

import Entites.Autre.BonDeCommande;
import Entites.Autre.FournisseurMagasin;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 6137220
 */
@Entity
public class Fournisseur extends Employe implements Serializable {

    @OneToMany(mappedBy = "leFournisseur")
    private List<FournisseurMagasin> fournisseurMagasins;

    @OneToMany(mappedBy = "leFournisseur")
    private List<BonDeCommande> bonDeCommandes;

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
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.PersonneEtHeritier.Fournisseur[ id=" + id + " ]";
    }
    
        private String raisonSociale;

    /**
     * Get the value of raisonSociale
     *
     * @return the value of raisonSociale
     */
    public String getRaisonSociale() {
        return raisonSociale;
    }

    /**
     * Set the value of raisonSociale
     *
     * @param raisonSociale new value of raisonSociale
     */
    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public List<FournisseurMagasin> getFournisseurMagasins() {
        return fournisseurMagasins;
    }

    public void setFournisseurMagasins(List<FournisseurMagasin> fournisseurMagasins) {
        this.fournisseurMagasins = fournisseurMagasins;
    }

    public List<BonDeCommande> getBonDeCommandes() {
        return bonDeCommandes;
    }

    public void setBonDeCommandes(List<BonDeCommande> bonDeCommandes) {
        this.bonDeCommandes = bonDeCommandes;
    }

    
}
