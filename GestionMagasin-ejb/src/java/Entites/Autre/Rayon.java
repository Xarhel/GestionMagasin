/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import Entites.Personne.Employe;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 6137220
 */
@Entity
public class Rayon implements Serializable {

    @OneToMany(mappedBy = "leRayon")
    private List<Employe> employes;

    @OneToOne(mappedBy = "leRayon")
    private Stock stock;
    
    @ManyToMany
    private List<RayonArticle> lesRayonArticles;

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
        if (!(object instanceof Rayon)) {
            return false;
        }
        Rayon other = (Rayon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.Rayon[ id=" + id + " ]";
    }
    
    @Column (nullable=false)
        private String rayonNom;

    /**
     * Get the value of rayonNom
     *
     * @return the value of rayonNom
     */
    public String getRayonNom() {
        return rayonNom;
    }

    /**
     * Set the value of rayonNom
     *
     * @param rayonNom new value of rayonNom
     */
    public void setRayonNom(String rayonNom) {
        this.rayonNom = rayonNom;
    }


    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
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
