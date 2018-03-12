/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Vente;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
public class Planning implements Serializable {

    @OneToMany(mappedBy = "lePlanning")
    private List<Creneau> creneaus;

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
        if (!(object instanceof Planning)) {
            return false;
        }
        Planning other = (Planning) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.Planning[ id=" + id + " ]";
    }
    
    @Column (nullable=false)
        private int annee;

    /**
     * Get the value of annee
     *
     * @return the value of annee
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * Set the value of annee
     *
     * @param annee new value of annee
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Column (nullable=false)
    private int mois;

    /**
     * Get the value of mois
     *
     * @return the value of mois
     */
    public int getMois() {
        return mois;
    }

    /**
     * Set the value of mois
     *
     * @param mois new value of mois
     */
    public void setMois(int mois) {
        this.mois = mois;
    }

    
    @Column (nullable=false)
        private int semaine;

    /**
     * Get the value of semaine
     *
     * @return the value of semaine
     */
    public int getSemaine() {
        return semaine;
    }

    /**
     * Set the value of semaine
     *
     * @param semaine new value of semaine
     */
    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    
}
