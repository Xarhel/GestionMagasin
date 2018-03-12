/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.Autre;

import Entites.Enum.StatutLivraison;
import Entites.Personne.AgentDeLivraison;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author 5153218
 */
@Entity
public class Livraison implements Serializable {

    @OneToMany(mappedBy = "laLivraison")
    private List<LivraisonLot> livraisonLots;

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
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Livraison[ id=" + id + " ]";
    }
    

    @Column (nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreationLivraison;

    /**
     * Get the value of dateCreationLivraison
     *
     * @return the value of dateCreationLivraison
     */
    
    public Date getDateCreationLivraison() {
        return dateCreationLivraison;
    }

    /**
     * Set the value of dateCreationLivraison
     *
     * @param dateCreationLivraison new value of dateCreationLivraison
     */
    public void setDateCreationLivraison(Date dateCreationLivraison) {
        this.dateCreationLivraison = dateCreationLivraison;
    }

    @Column (nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateReceptionLivraison;

    /**
     * Get the value of dateReceptionLivraison
     *
     * @return the value of dateReceptionLivraison
     */
    
    public Date getDateReceptionLivraison() {
        return dateReceptionLivraison;
    }

    /**
     * Set the value of dateReceptionLivraison
     *
     * @param dateReceptionLivraison new value of dateReceptionLivraison
     */
    public void setDateReceptionLivraison(Date dateReceptionLivraison) {
        this.dateReceptionLivraison = dateReceptionLivraison;
    }
    
    @Column (nullable=false)
        private StatutLivraison statutLivraison;

    /**
     * Get the value of statutLivraison
     *
     * @return the value of statutLivraison
     */
    public StatutLivraison getStatutLivraison() {
        return statutLivraison;
    }

    /**
     * Set the value of statutLivraison
     *
     * @param statutLivraison new value of statutLivraison
     */
    public void setStatutLivraison(StatutLivraison statutLivraison) {
        this.statutLivraison = statutLivraison;
    }
    
    
    @ManyToOne
        private BonDeCommande leBonDeCommande;

    /**
     * Get the value of leBonDeCommande
     *
     * @return the value of leBonDeCommande
     */
    public BonDeCommande getLeBonDeCommande() {
        return leBonDeCommande;
    }

    /**
     * Set the value of leBonDeCommande
     *
     * @param leBonDeCommande new value of leBonDeCommande
     */
    public void setLeBonDeCommande(BonDeCommande leBonDeCommande) {
        this.leBonDeCommande = leBonDeCommande;
    }

    @OneToOne
    private Reclamation laReclamation;

    /**
     * Get the value of laReclamation
     *
     * @return the value of laReclamation
     */
    public Reclamation getLaReclamation() {
        return laReclamation;
    }

    /**
     * Set the value of laReclamation
     *
     * @param laReclamation new value of laReclamation
     */
    public void setLaReclamation(Reclamation laReclamation) {
        this.laReclamation = laReclamation;
    }

    @ManyToOne
    private AgentDeLivraison lAgentDeLivraison;

    /**
     * Get the value of lAgentDeLivraison
     *
     * @return the value of lAgentDeLivraison
     */
    public AgentDeLivraison getlAgentDeLivraison() {
        return lAgentDeLivraison;
    }

    /**
     * Set the value of lAgentDeLivraison
     *
     * @param lAgentDeLivraison new value of lAgentDeLivraison
     */
    public void setlAgentDeLivraison(AgentDeLivraison lAgentDeLivraison) {
        this.lAgentDeLivraison = lAgentDeLivraison;
    }

}
