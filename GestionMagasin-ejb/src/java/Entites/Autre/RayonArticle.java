/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

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


/**
 *
 * @author 6137220
 */
@Entity
public class RayonArticle implements Serializable {

        @ManyToOne
    private Article lesArticles;
        
        @ManyToOne
    private Rayon lesRayons;
    
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
        if (!(object instanceof RayonArticle)) {
            return false;
        }
        RayonArticle other = (RayonArticle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.RayonArticle[ id=" + id + " ]";
    }
    
    @Column (nullable=false)
    private Float prixVente;

    /**
     * Get the value of prixVente
     *
     * @return the value of prixVente
     */
    public Float getPrixVente() {
        return prixVente;
    }

    /**
     * Set the value of prixVente
     *
     * @param prixVente new value of prixVente
     */
    public void setPrixVente(Float prixVente) {
        this.prixVente = prixVente;
    }

    
    @Column (nullable=false)
        private float prixRayon;

    /**
     * Get the value of prixRayon
     *
     * @return the value of prixRayon
     */
    public float getPrixRayon() {
        return prixRayon;
    }

    /**
     * Set the value of prixRayon
     *
     * @param prixRayon new value of prixRayon
     */
    public void setPrixRayon(float prixRayon) {
        this.prixRayon = prixRayon;
    }

    public Article getLesArticles() {
        return lesArticles;
    }

    public void setLesArticles(Article lesArticles) {
        this.lesArticles = lesArticles;
    }

    public Rayon getLesRayons() {
        return lesRayons;
    }

    public void setLesRayons(Rayon lesRayons) {
        this.lesRayons = lesRayons;
    }


    
    
}
