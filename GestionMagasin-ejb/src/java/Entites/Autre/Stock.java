/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import Entites.Vente.ArticleVente;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author 6137220
 */
@Entity
public class Stock implements Serializable {
    
    @OneToOne
    private Article leStock;


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
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.Stock[ id=" + id + " ]";
    }
    
        private String quantiteStock;

    /**
     * Get the value of quantiteStock
     *
     * @return the value of quantiteStock
     */
    public String getQuantiteStock() {
        return quantiteStock;
    }

    /**
     * Set the value of quantiteStock
     *
     * @param quantiteStock new value of quantiteStock
     */
    public void setQuantiteStock(String quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    
    /**
     * Get the value of leStock
     *
     * @return the value of leStock
     */
    public Article getLeStock() {
        return leStock;
    }

    /**
     * Set the value of leStock
     *
     * @param leStock new value of leStock
     */
    public void setLeStock(Article leStock) {
        this.leStock = leStock;
    }

    @OneToOne
        private StockRetrait leStockRetrait;

    /**
     * Get the value of leStockRetrait
     *
     * @return the value of leStockRetrait
     */
    public StockRetrait getLeStockRetrait() {
        return leStockRetrait;
    }

    /**
     * Set the value of leStockRetrait
     *
     * @param leStockRetrait new value of leStockRetrait
     */
    public void setLeStockRetrait(StockRetrait leStockRetrait) {
        this.leStockRetrait = leStockRetrait;
    }

    @OneToOne
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

    @OneToOne
    private LivraisonLot laLivraisonLot;

    /**
     * Get the value of laLivraisonLot
     *
     * @return the value of laLivraisonLot
     */
    public LivraisonLot getLaLivraisonLot() {
        return laLivraisonLot;
    }

    /**
     * Set the value of laLivraisonLot
     *
     * @param laLivraisonLot new value of laLivraisonLot
     */
    public void setLaLivraisonLot(LivraisonLot laLivraisonLot) {
        this.laLivraisonLot = laLivraisonLot;
    }

    @OneToOne
    private ArticleVente lArticleVente;

    /**
     * Get the value of lArticleVente
     *
     * @return the value of lArticleVente
     */
    public ArticleVente getlArticleVente() {
        return lArticleVente;
    }

    /**
     * Set the value of lArticleVente
     *
     * @param lArticleVente new value of lArticleVente
     */
    public void setlArticleVente(ArticleVente lArticleVente) {
        this.lArticleVente = lArticleVente;
    }

    
}
