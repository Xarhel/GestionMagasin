/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Lot;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author 5153218
 */
@Entity
public class Alimentaire extends Lot implements Serializable {

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
        if (!(object instanceof Alimentaire)) {
            return false;
        }
        Alimentaire other = (Alimentaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Alimentaire[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column (nullable=false)
    private Date datePeremption;

    /**
     * Get the value of datePeremption
     *
     * @return the value of datePeremption
     */
    public Date getDatePeremption() {
        return datePeremption;
    }

    /**
     * Set the value of datePeremption
     *
     * @param datePeremption new value of datePeremption
     */
    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

}
