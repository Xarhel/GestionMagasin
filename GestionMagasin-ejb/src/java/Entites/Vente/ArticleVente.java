/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Vente;

import Entites.Autre.Stock;
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
 * @author 6137220
 */
@Entity
public class ArticleVente implements Serializable {

    @OneToOne(mappedBy = "lArticleVente")
    private Stock stock;

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
        if (!(object instanceof ArticleVente)) {
            return false;
        }
        ArticleVente other = (ArticleVente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.ArticleVente[ id=" + id + " ]";
    }
    
    @Column (nullable=false)
        private int quantite;

    /**
     * Get the value of quantite
     *
     * @return the value of quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Set the value of quantite
     *
     * @param quantite new value of quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @ManyToOne
        private PanierCaisse lePanierCaisse;

    /**
     * Get the value of lePanierCaisse
     *
     * @return the value of lePanierCaisse
     */
    public PanierCaisse getLePanierCaisse() {
        return lePanierCaisse;
    }

    /**
     * Set the value of lePanierCaisse
     *
     * @param lePanierCaisse new value of lePanierCaisse
     */
    public void setLePanierCaisse(PanierCaisse lePanierCaisse) {
        this.lePanierCaisse = lePanierCaisse;
    }

    @ManyToOne
        private PanierInternet lePanierInternet;

    /**
     * Get the value of lePanierInternet
     *
     * @return the value of lePanierInternet
     */
    public PanierInternet getLePanierInternet() {
        return lePanierInternet;
    }

    /**
     * Set the value of lePanierInternet
     *
     * @param lePanierInternet new value of lePanierInternet
     */
    public void setLePanierInternet(PanierInternet lePanierInternet) {
        this.lePanierInternet = lePanierInternet;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

}
