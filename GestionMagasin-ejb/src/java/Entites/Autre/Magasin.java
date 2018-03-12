/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import Entites.Personne.AgentDeLivraison;
import Entites.Personne.Employe;
import Entites.Personne.EmployeDeCaisse;
import Entites.Personne.GerantMagasin;
import Entites.Vente.Creneau;
import Entites.Vente.PanierInternet;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 5153218
 */
@Entity
public class Magasin implements Serializable {

    @OneToMany(mappedBy = "leMagasin")
    private List<Rayon> rayons;

    @OneToMany(mappedBy = "leMagasin")
    private List<FournisseurMagasin> fournisseurMagasins;

    @OneToOne(mappedBy = "leMagasin")
    private Adresse adresse;

    @OneToMany(mappedBy = "leMagasin")
    private List<PanierInternet> panierInternets;

    @OneToMany(mappedBy = "leMagasin")
    private List<EmployeDeCaisse> employeDeCaisses;

    @OneToOne(mappedBy = "leMagasin")
    private GerantMagasin gerantMagasin;

    @OneToMany(mappedBy = "leMagasin")
    private List<AgentDeLivraison> agentDeLivraisons;

    @OneToMany(mappedBy = "leMagasin")
    private List<Employe> employes;

    @OneToMany(mappedBy = "leMagasin")
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
        if (!(object instanceof Magasin)) {
            return false;
        }
        Magasin other = (Magasin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Magasin[ id=" + id + " ]";
    }
    @Column (nullable=false)
    private String nom;

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<FournisseurMagasin> getFournisseurMagasins() {
        return fournisseurMagasins;
    }

    public void setFournisseurMagasins(List<FournisseurMagasin> fournisseurMagasins) {
        this.fournisseurMagasins = fournisseurMagasins;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<PanierInternet> getPanierInternets() {
        return panierInternets;
    }

    public void setPanierInternets(List<PanierInternet> panierInternets) {
        this.panierInternets = panierInternets;
    }

    public List<EmployeDeCaisse> getEmployeDeCaisses() {
        return employeDeCaisses;
    }

    public void setEmployeDeCaisses(List<EmployeDeCaisse> employeDeCaisses) {
        this.employeDeCaisses = employeDeCaisses;
    }

    public GerantMagasin getGerantMagasin() {
        return gerantMagasin;
    }

    public void setGerantMagasin(GerantMagasin gerantMagasin) {
        this.gerantMagasin = gerantMagasin;
    }

    public List<AgentDeLivraison> getAgentDeLivraisons() {
        return agentDeLivraisons;
    }

    public void setAgentDeLivraisons(List<AgentDeLivraison> agentDeLivraisons) {
        this.agentDeLivraisons = agentDeLivraisons;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public List<Creneau> getCreneaus() {
        return creneaus;
    }

    public void setCreneaus(List<Creneau> creneaus) {
        this.creneaus = creneaus;
    }



    
    

}
