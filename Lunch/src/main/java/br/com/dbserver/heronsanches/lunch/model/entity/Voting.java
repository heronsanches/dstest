
package br.com.dbserver.heronsanches.lunch.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Heron Sanches
 */
@Entity
@Table(name = "voting")
@NamedQueries({
   @NamedQuery(name = "Voting.findAllByDate", query = "SELECT v FROM Voting v WHERE v.votingPK.idVotingDt = :todayDate ORDER BY v.votingPK.idRestaurant")
   ,@NamedQuery(name = "Voting.findByIdProfessionalTxtCpf_date", query = "SELECT v.professional FROM Voting v WHERE v.votingPK.idProfessionalTxtCpf = :idProfessionalTxtCpf "
           + "AND v.votingPK.idVotingDt = :idVotingDt")
   ,@NamedQuery(name = "Voting.findRestaurantsByDate", query = "SELECT v.restaurant FROM Voting v WHERE v.votingPK.idVotingDt = :date")
})
public class Voting implements Serializable {

   private static final long serialVersionUID = 1L;
   @EmbeddedId
   protected VotingPK votingPK;
      
   @JoinColumn(name = "id_professional_txt_cpf", referencedColumnName = "id_professional_txt_cpf", insertable = false, updatable = false)
   @ManyToOne(optional = false)
   private Professional professional;
   
   @JoinColumn(name = "id_restaurant", referencedColumnName = "id_restaurant", insertable = false, updatable = false)
   @ManyToOne(optional = false)
   private Restaurant restaurant;
   

   public Voting() {
   }

   
   public Voting(VotingPK votingPK) {
      this.votingPK = votingPK;
   }
   

   public Voting(String idProfessionalTxtCpf, int idRestaurant, Date idVotingDt) {
      this.votingPK = new VotingPK(idProfessionalTxtCpf, idRestaurant, idVotingDt);
   }
   

   public VotingPK getVotingPK() {
      return votingPK;
   }

   public void setVotingPK(VotingPK votingPK) {
      this.votingPK = votingPK;
   }

   public Professional getProfessional() {
      return professional;
   }

   public void setProfessional(Professional professional) {
      this.professional = professional;
   }

   public Restaurant getRestaurant() {
      return restaurant;
   }

   public void setRestaurant(Restaurant restaurant) {
      this.restaurant = restaurant;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (votingPK != null ? votingPK.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Voting)) {
         return false;
      }
      Voting other = (Voting) object;
      if ((this.votingPK == null && other.votingPK != null) || (this.votingPK != null && !this.votingPK.equals(other.votingPK))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "br.com.dbserver.heronsanches.lunch.model.entity.Voting[ votingPK=" + votingPK + " ]";
   }

}
