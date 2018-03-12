/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Personne;

import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import java.io.Serializable;
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
public abstract class Employe extends Personne implements Serializable {

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
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Entites.Personne.Employe[ id=" + id + " ]";
    }
    
    
        private int idMagasin;

    /**
     * Get the value of idMagasin
     *
     * @return the value of idMagasin
     */
    public int getIdMagasin() {
        return idMagasin;
    }

    /**
     * Set the value of idMagasin
     *
     * @param idMagasin new value of idMagasin
     */
    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    
        private int idRayon;

    /**
     * Get the value of idRayon
     *
     * @return the value of idRayon
     */
    public int getIdRayon() {
        return idRayon;
    }

    /**
     * Set the value of idRayon
     *
     * @param idRayon new value of idRayon
     */
    public void setIdRayon(int idRayon) {
        this.idRayon = idRayon;
    }

    @ManyToOne
        private Rayon leRayon;

    /**
     * Get the value of leRayon
     *
     * @return the value of leRayon
     */
    public Rayon getLeRayon() {
        return leRayon;
    }

    /**
     * Set the value of leRayon
     *
     * @param leRayon new value of leRayon
     */
    public void setLeRayon(Rayon leRayon) {
        this.leRayon = leRayon;
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
