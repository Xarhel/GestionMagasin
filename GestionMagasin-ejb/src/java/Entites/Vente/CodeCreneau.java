/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Vente;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
public class CodeCreneau implements Serializable {

    @OneToMany(mappedBy = "leCodeCreneau")
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
        if (!(object instanceof CodeCreneau)) {
            return false;
        }
        CodeCreneau other = (CodeCreneau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Autres.CodeCreneau[ id=" + id + " ]";
    }
    @Column (nullable=false)
        private int codeCreneau;

    /**
     * Get the value of codeCreneau
     *
     * @return the value of codeCreneau
     */
    public int getCodeCreneau() {
        return codeCreneau;
    }

    /**
     * Set the value of codeCreneau
     *
     * @param codeCreneau new value of codeCreneau
     */
    public void setCodeCreneau(int codeCreneau) {
        this.codeCreneau = codeCreneau;
    }

    @Column (nullable=false)
        private String libelleCreneau;

    /**
     * Get the value of libelleCreneau
     *
     * @return the value of libelleCreneau
     */
    public String getLibelleCreneau() {
        return libelleCreneau;
    }

    /**
     * Set the value of libelleCreneau
     *
     * @param libelleCreneau new value of libelleCreneau
     */
    public void setLibelleCreneau(String libelleCreneau) {
        this.libelleCreneau = libelleCreneau;
    }

    
    
}
