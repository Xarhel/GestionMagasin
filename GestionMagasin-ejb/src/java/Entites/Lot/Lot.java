/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Lot;

import Entites.Autre.Article;
import Entites.Autre.BonDeCommande;
import Entites.Autre.CommandeLot;
import Entites.Autre.LivraisonLot;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 5153218
 */
@Entity
public class Lot implements Serializable {

    @OneToMany(mappedBy = "leLot")
    private List<LivraisonLot> livraisonLots;

    @OneToMany(mappedBy = "leLot")
    private List<CommandeLot> commandeLots;
    
    @ManyToOne
        private Article lArticle;

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
        if (!(object instanceof Lot)) {
            return false;
        }
        Lot other = (Lot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Lot[ id=" + id + " ]";
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

    

    /**
     * Get the value of lArticle
     *
     * @return the value of lArticle
     */
    public Article getlArticle() {
        return lArticle;
    }

    /**
     * Set the value of lArticle
     *
     * @param lArticle new value of lArticle
     */
    public void setlArticle(Article lArticle) {
        this.lArticle = lArticle;
    }

    
   
    
}
