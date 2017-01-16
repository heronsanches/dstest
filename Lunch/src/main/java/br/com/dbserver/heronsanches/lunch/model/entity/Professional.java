
package br.com.dbserver.heronsanches.lunch.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Heron Sanches
 */
@Entity
@Table(name = "professional")
@NamedQueries({
   @NamedQuery(name = "Professional.findTxtPasswordByEmail", query = "SELECT p.txtPassword FROM Professional p WHERE p.txtEmail = :txtEmail")
   ,@NamedQuery(name = "Professional.findIdCidadeByTxtEmail", query = "SELECT p.idEnterpriseLocality.idCity FROM Professional p WHERE p.txtEmail = :txtEmail")
   ,@NamedQuery(name = "Professional.findIdProfessionalByTxtEmail", query = "SELECT p.idProfessionalTxtCpf FROM Professional p WHERE p.txtEmail = :txtEmail")
   ,@NamedQuery(name = "Professional.findAllEmailByIdEnterpriseLocality", query = "SELECT p.txtEmail FROM Professional p WHERE p.idEnterpriseLocality.idEnterpriseLocality = :locality")
})
public class Professional implements Serializable {

   private static final long serialVersionUID = 1L;
   
   @Id
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 11)
   @Column(name = "id_professional_txt_cpf")
   private String idProfessionalTxtCpf;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 70)
   @Column(name = "txt_name")
   private String txtName;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 80)
   @Column(name = "txt_email")
   private String txtEmail;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "txt_password")
   private String txtPassword;
   
   @Basic(optional = false)
   @NotNull
   @Column(name = "bool_facilitator")
   private boolean boolFacilitator;
   
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "professional")
   private Collection<Voting> votingCollection;
   
   @JoinColumn(name = "id_enterprise_locality", referencedColumnName = "id_enterprise_locality")
   @ManyToOne(optional = false)
   private EnterpriseLocality idEnterpriseLocality;

   
   public Professional() {
   }

   
   public Professional(String idProfessionalTxtCpf) {
      this.idProfessionalTxtCpf = idProfessionalTxtCpf;
   }
   

   public Professional(String idProfessionalTxtCpf, String txtName, String txtEmail, String txtPassword, boolean boolFacilitator) {
      this.idProfessionalTxtCpf = idProfessionalTxtCpf;
      this.txtName = txtName;
      this.txtEmail = txtEmail;
      this.txtPassword = txtPassword;
      this.boolFacilitator = boolFacilitator;
   }

   
   public String getIdProfessionalTxtCpf() {
      return idProfessionalTxtCpf;
   }

   public void setIdProfessionalTxtCpf(String idProfessionalTxtCpf) {
      this.idProfessionalTxtCpf = idProfessionalTxtCpf;
   }

   public String getTxtName() {
      return txtName;
   }

   public void setTxtName(String txtName) {
      this.txtName = txtName;
   }

   public String getTxtEmail() {
      return txtEmail;
   }

   public void setTxtEmail(String txtEmail) {
      this.txtEmail = txtEmail;
   }

   public String getTxtPassword() {
      return txtPassword;
   }

   public void setTxtPassword(String txtPassword) {
      this.txtPassword = txtPassword;
   }

   public boolean getBoolFacilitator() {
      return boolFacilitator;
   }

   public void setBoolFacilitator(boolean boolFacilitator) {
      this.boolFacilitator = boolFacilitator;
   }

   public Collection<Voting> getVotingCollection() {
      return votingCollection;
   }

   public void setVotingCollection(Collection<Voting> votingCollection) {
      this.votingCollection = votingCollection;
   }

   public EnterpriseLocality getIdEnterpriseLocality() {
      return idEnterpriseLocality;
   }

   public void setIdEnterpriseLocality(EnterpriseLocality idEnterpriseLocality) {
      this.idEnterpriseLocality = idEnterpriseLocality;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idProfessionalTxtCpf != null ? idProfessionalTxtCpf.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Professional)) {
         return false;
      }
      Professional other = (Professional) object;
      if ((this.idProfessionalTxtCpf == null && other.idProfessionalTxtCpf != null) || (this.idProfessionalTxtCpf != null && !this.idProfessionalTxtCpf.equals(other.idProfessionalTxtCpf))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "br.com.dbserver.heronsanches.lunch.model.entity.Professional[ idProfessionalTxtCpf=" + idProfessionalTxtCpf + " ]";
   }

}
