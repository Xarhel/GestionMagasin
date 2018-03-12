/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import java.io.Serializable;
import java.sql.Date;
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
public class StockRetrait implements Serializable {

    @OneToOne(mappedBy = "leStockRetrait")
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
        if (!(object instanceof StockRetrait)) {
            return false;
        }
        StockRetrait other = (StockRetrait) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.StockRetrait[ id=" + id + " ]";
    }
    
        private int quantiteRetrait;

    /**
     * Get the value of quantiteRetrait
     *
     * @return the value of quantiteRetrait
     */
    public int getQuantiteRetrait() {
        return quantiteRetrait;
    }

    /**
     * Set the value of quantiteRetrait
     *
     * @param quantiteRetrait new value of quantiteRetrait
     */
    public void setQuantiteRetrait(int quantiteRetrait) {
        this.quantiteRetrait = quantiteRetrait;
    }

     @Column (nullable=false)  
        private Date dateRetrait;

    /**
     * Get the value of dateRetrait
     *
     * @return the value of dateRetrait
     */
    public Date getDateRetrait() {
        return dateRetrait;
    }

    /**
     * Set the value of dateRetrait
     *
     * @param dateRetrait new value of dateRetrait
     */
    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

}
