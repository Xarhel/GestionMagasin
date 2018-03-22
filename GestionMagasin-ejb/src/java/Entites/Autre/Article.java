/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import Entites.Enum.CategorieArticle;
import Entites.Lot.Lot;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 6137220
 */
@Entity
public class Article implements Serializable {

    @OneToOne(mappedBy = "lArticle")
    private Stock leStock;

    @OneToMany(mappedBy = "lArticle")
    private List<Lot> lots;
    
    @OneToMany(mappedBy = "lesArticles")
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.Article[ id=" + id + " ]";
    }
    
    
    private int referenceArticle;

    /**
     * Get the value of referenceArticle
     *
     * @return the value of referenceArticle
     */
    public int getReferenceArticle() {
        return referenceArticle;
    }

    /**
     * Set the value of referenceArticle
     *
     * @param referenceArticle new value of referenceArticle
     */
    public void setReferenceArticle(int referenceArticle) {
        this.referenceArticle = referenceArticle;
    }

    
    private String libelle;

    /**
     * Get the value of libelle
     *
     * @return the value of libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Set the value of libelle
     *
     * @param libelle new value of libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
    private int codeBarre;

    /**
     * Get the value of codeBarre
     *
     * @return the value of codeBarre
     */
    public int getCodeBarre() {
        return codeBarre;
    }

    /**
     * Set the value of codeBarre
     *
     * @param codeBarre new value of codeBarre
     */
    public void setCodeBarre(int codeBarre) {
        this.codeBarre = codeBarre;
    }

    @Column (nullable=false)
    private boolean promotion;

    /**
     * Get the value of promotion
     *
     * @return the value of promotion
     */
    public boolean isPromotion() {
        return promotion;
    }

    /**
     * Set the value of promotion
     *
     * @param promotion new value of promotion
     */
    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    
    private float prixPromotion;

    /**
     * Get the value of prixPromotion
     *
     * @return the value of prixPromotion
     */
    public float getPrixPromotion() {
        return prixPromotion;
    }

    /**
     * Set the value of prixPromotion
     *
     * @param prixPromotion new value of prixPromotion
     */
    public void setPrixPromotion(float prixPromotion) {
        this.prixPromotion = prixPromotion;
    }

    public Stock getLeStock() {
        return leStock;
    }

    public void setLeStock(Stock leStock) {
        this.leStock = leStock;
    }

    public List<RayonArticle> getLesRayonArticles() {
        return lesRayonArticles;
    }

    public void setLesRayonArticles(List<RayonArticle> lesRayonArticles) {
        this.lesRayonArticles = lesRayonArticles;
    }





    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }


        private CategorieArticle Categorie;

    /**
     * Get the value of Categorie
     *
     * @return the value of Categorie
     */
    public CategorieArticle getCategorie() {
        return Categorie;
    }

    /**
     * Set the value of Categorie
     *
     * @param Categorie new value of Categorie
     */
    public void setCategorie(CategorieArticle Categorie) {
        this.Categorie = Categorie;
    }

    
    
    
}
