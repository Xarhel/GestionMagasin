/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import Entites.Personne.Client;
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
 * @author 5153218
 */
@Entity
public class Adresse implements Serializable {

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
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Adresse[ id=" + id + " ]";
    }
    @Column (nullable=false)
    private String libelleAdresse;

    /**
     * Get the value of libelleAdresse
     *
     * @return the value of libelleAdresse
     */
    public String getLibelleAdresse() {
        return libelleAdresse;
    }

    /**
     * Set the value of libelleAdresse
     *
     * @param libelleAdresse new value of libelleAdresse
     */
    public void setLibelleAdresse(String libelleAdresse) {
        this.libelleAdresse = libelleAdresse;
    }

    private String rueNom;

    /**
     * Get the value of rueNom
     *
     * @return the value of rueNom
     */
    public String getRueNom() {
        return rueNom;
    }

    /**
     * Set the value of rueNom
     *
     * @param rueNom new value of rueNom
     */
    public void setRueNom(String rueNom) {
        this.rueNom = rueNom;
    }

    private String rueComplement;

    /**
     * Get the value of rueComplement
     *
     * @return the value of rueComplement
     */
    public String getRueComplement() {
        return rueComplement;
    }

    /**
     * Set the value of rueComplement
     *
     * @param rueComplement new value of rueComplement
     */
    public void setRueComplement(String rueComplement) {
        this.rueComplement = rueComplement;
    }

    @Column (nullable=false)
    private int codePostal;

    /**
     * Get the value of codePostal
     *
     * @return the value of codePostal
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * Set the value of codePostal
     *
     * @param codePostal new value of codePostal
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    @Column (nullable=false)
    private String ville;

    /**
     * Get the value of ville
     *
     * @return the value of ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Set the value of ville
     *
     * @param ville new value of ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
    
    @ManyToOne
        private Client leClient;

    /**
     * Get the value of leClient
     *
     * @return the value of leClient
     */
    public Client getLeClient() {
        return leClient;
    }

    /**
     * Set the value of leClient
     *
     * @param leClient new value of leClient
     */
    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

    @OneToOne
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
