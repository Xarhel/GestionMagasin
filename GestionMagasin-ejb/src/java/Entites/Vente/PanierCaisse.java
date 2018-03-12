/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Vente;

import Entites.Personne.EmployeDeCaisse;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 6137220
 */
@Entity
public class PanierCaisse extends Panier implements Serializable {

    @OneToMany(mappedBy = "lePanierCaisse")
    private List<ArticleVente> articleVentes;

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
        if (!(object instanceof PanierCaisse)) {
            return false;
        }
        PanierCaisse other = (PanierCaisse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.PanierCaisse[ id=" + id + " ]";
    }
    
    @ManyToOne
       private EmployeDeCaisse lEmployeDeCaisse;

    /**
     * Get the value of lEmployeDeCaisse
     *
     * @return the value of lEmployeDeCaisse
     */
    public EmployeDeCaisse getlEmployeDeCaisse() {
        return lEmployeDeCaisse;
    }

    /**
     * Set the value of lEmployeDeCaisse
     *
     * @param lEmployeDeCaisse new value of lEmployeDeCaisse
     */
    public void setlEmployeDeCaisse(EmployeDeCaisse lEmployeDeCaisse) {
        this.lEmployeDeCaisse = lEmployeDeCaisse;
    }

    public List<ArticleVente> getArticleVentes() {
        return articleVentes;
    }

    public void setArticleVentes(List<ArticleVente> articleVentes) {
        this.articleVentes = articleVentes;
    }
 
    
}
