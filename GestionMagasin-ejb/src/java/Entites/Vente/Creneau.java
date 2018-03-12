/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Vente;

import Entites.Autre.Magasin;
import java.io.Serializable;
import java.util.List;
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
public class Creneau implements Serializable {

    @OneToMany(mappedBy = "leCreneau")
    private List<PanierInternet> panierInternets;

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
        if (!(object instanceof Creneau)) {
            return false;
        }
        Creneau other = (Creneau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.Creneau[ id=" + id + " ]";
    }
    
    
        
    

        private int capaciteCreneau;

    /**
     * Get the value of capaciteCreneau
     *
     * @return the value of capaciteCreneau
     */
    public int getCapaciteCreneau() {
        return capaciteCreneau;
    }

    /**
     * Set the value of capaciteCreneau
     *
     * @param capaciteCreneau new value of capaciteCreneau
     */
    public void setCapaciteCreneau(int capaciteCreneau) {
        this.capaciteCreneau = capaciteCreneau;
    }

        private int compteurCreneau;

    /**
     * Get the value of compteurCreneau
     *
     * @return the value of compteurCreneau
     */
    public int getCompteurCreneau() {
        return compteurCreneau;
    }

    /**
     * Set the value of compteurCreneau
     *
     * @param compteurCreneau new value of compteurCreneau
     */
    public void setCompteurCreneau(int compteurCreneau) {
        this.compteurCreneau = compteurCreneau;
    }

    @ManyToOne
        private Planning lePlanning;

    /**
     * Get the value of lePlanning
     *
     * @return the value of lePlanning
     */
    public Planning getLePlanning() {
        return lePlanning;
    }

    /**
     * Set the value of lePlanning
     *
     * @param lePlanning new value of lePlanning
     */
    public void setLePlanning(Planning lePlanning) {
        this.lePlanning = lePlanning;
    }

    @ManyToOne
        private CodeCreneau leCodeCreneau;

    /**
     * Get the value of leCodeCreneau
     *
     * @return the value of leCodeCreneau
     */
    public CodeCreneau getLeCodeCreneau() {
        return leCodeCreneau;
    }

    /**
     * Set the value of leCodeCreneau
     *
     * @param leCodeCreneau new value of leCodeCreneau
     */
    public void setLeCodeCreneau(CodeCreneau leCodeCreneau) {
        this.leCodeCreneau = leCodeCreneau;
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

    public List<PanierInternet> getPanierInternets() {
        return panierInternets;
    }

    public void setPanierInternets(List<PanierInternet> panierInternets) {
        this.panierInternets = panierInternets;
    }

    
}
