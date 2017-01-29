
package lunch.hour.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Heron Sanches
 */
@Embeddable
public class VotingPK implements Serializable {

   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 11)
   @Column(name = "id_professional_txt_cpf")
   private String idProfessionalTxtCpf;
   
   @Basic(optional = false)
   @NotNull
   @Column(name = "id_restaurant")
   private int idRestaurant;
   
   @Basic(optional = false)
   @NotNull
   @Column(name = "id_voting_dt")
   @Temporal(TemporalType.DATE)
   private Date idVotingDt;

   
   public VotingPK() {
   }
   

   public VotingPK(String idProfessionalTxtCpf, int idRestaurant, Date idVotingDt) {
      this.idProfessionalTxtCpf = idProfessionalTxtCpf;
      this.idRestaurant = idRestaurant;
      this.idVotingDt = idVotingDt;
   }
   

   public String getIdProfessionalTxtCpf() {
      return idProfessionalTxtCpf;
   }

   public void setIdProfessionalTxtCpf(String idProfessionalTxtCpf) {
      this.idProfessionalTxtCpf = idProfessionalTxtCpf;
   }

   public int getIdRestaurant() {
      return idRestaurant;
   }

   public void setIdRestaurant(int idRestaurant) {
      this.idRestaurant = idRestaurant;
   }

   public Date getIdVotingDt() {
      return idVotingDt;
   }

   public void setIdVotingDt(Date idVotingDt) {
      this.idVotingDt = idVotingDt;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idProfessionalTxtCpf != null ? idProfessionalTxtCpf.hashCode() : 0);
      hash += (int) idRestaurant;
      hash += (idVotingDt != null ? idVotingDt.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof VotingPK)) {
         return false;
      }
      VotingPK other = (VotingPK) object;
      if ((this.idProfessionalTxtCpf == null && other.idProfessionalTxtCpf != null) || (this.idProfessionalTxtCpf != null && !this.idProfessionalTxtCpf.equals(other.idProfessionalTxtCpf))) {
         return false;
      }
      if (this.idRestaurant != other.idRestaurant) {
         return false;
      }
      if ((this.idVotingDt == null && other.idVotingDt != null) || (this.idVotingDt != null && !this.idVotingDt.equals(other.idVotingDt))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "br.com.dbserver.heronsanches.lunch.model.entity.VotingPK[ idProfessionalTxtCpf=" + idProfessionalTxtCpf + ", idRestaurant=" + idRestaurant + ", idVotingDt=" + idVotingDt + " ]";
   }

}
