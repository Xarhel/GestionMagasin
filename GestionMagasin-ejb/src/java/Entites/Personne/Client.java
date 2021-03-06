/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Personne;

import Entites.Autre.Adresse;
import Entites.Vente.PanierInternet;
import java.io.Serializable;
import java.sql.Date;
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
public class Client extends Personne implements Serializable {

    @OneToMany(mappedBy = "leClient")
    private List<Adresse> adresses;

    @OneToMany(mappedBy = "leClient")
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.PersonneEtHeritier.Client[ id=" + id + " ]";
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public List<PanierInternet> getPanierInternets() {
        return panierInternets;
    }

    public void setPanierInternets(List<PanierInternet> panierInternets) {
        this.panierInternets = panierInternets;
    }
    
    private String adresseEmail;

    /**
     * Get the value of adresseEmail
     *
     * @return the value of adresseEmail
     */
    public String getAdresseEmail() {
        return adresseEmail;
    }

    /**
     * Set the value of adresseEmail
     *
     * @param adresseEmail new value of adresseEmail
     */
    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    private Date dateNaissance;

    /**
     * Get the value of dateNaissance
     *
     * @return the value of dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Set the value of dateNaissance
     *
     * @param dateNaissance new value of dateNaissance
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    private String telephone;

    /**
     * Get the value of telephone
     *
     * @return the value of telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set the value of telephone
     *
     * @param telephone new value of telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
