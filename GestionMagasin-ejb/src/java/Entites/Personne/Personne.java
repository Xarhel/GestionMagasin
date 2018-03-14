/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Personne;

import Entites.Enum.TypeCompte;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 *
 * @author 6137220
 */
@Entity
@Inheritance
(strategy=InheritanceType.JOINED)
public abstract class Personne implements Serializable {

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
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Personne[ id=" + id + " ]";
    }
    @Column (nullable=false)
        private String nomPersonne;

    /**
     * Get the value of nomPersonne
     *
     * @return the value of nomPersonne
     */
    public String getNomPersonne() {
        return nomPersonne;
    }

    /**
     * Set the value of nomPersonne
     *
     * @param nomPersonne new value of nomPersonne
     */
    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    @Column (nullable=false)
        private String prenomPersonne;

    /**
     * Get the value of prenomPersonne
     *
     * @return the value of prenomPersonne
     */
    public String getPrenomPersonne() {
        return prenomPersonne;
    }

    /**
     * Set the value of prenomPersonne
     *
     * @param prenomPersonne new value of prenomPersonne
     */
    public void setPrenomPersonne(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }

    @Column (nullable=false, unique=true)
        private String login;

    /**
     * Get the value of login
     *
     * @return the value of login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set the value of login
     *
     * @param login new value of login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    @Column (nullable=false)
        private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Column (nullable=false)
        private Date dateCreationCompte;

    /**
     * Get the value of dateCreationCompte
     *
     * @return the value of dateCreationCompte
     */
    public Date getDateCreationCompte() {
        return dateCreationCompte;
    }

    /**
     * Set the value of dateCreationCompte
     *
     * @param dateCreationCompte new value of dateCreationCompte
     */
    public void setDateCreationCompte(Date dateCreationCompte) {
        this.dateCreationCompte = dateCreationCompte;
    }


   @Column (nullable=false)
   private TypeCompte typeCompte;
   
   public TypeCompte getTypeCompte()
   {
       return typeCompte;
   }

   public void setTypeCompte(TypeCompte typeCompte)
   {
       this.typeCompte=typeCompte;
   }
    
    
    
}
