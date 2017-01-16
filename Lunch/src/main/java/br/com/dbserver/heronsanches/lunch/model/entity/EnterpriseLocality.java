
package br.com.dbserver.heronsanches.lunch.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "enterprise_locality")
@NamedQueries({
   @NamedQuery(name = "EnterpriseLocality.findByIdEnterpriseLocality", query = "SELECT e FROM EnterpriseLocality e WHERE e.idEnterpriseLocality = :idEnterpriseLocality")
   ,@NamedQuery(name = "EnterpriseLocality.findAll", query = "SELECT e.idEnterpriseLocality FROM EnterpriseLocality e")
})
public class EnterpriseLocality implements Serializable {

   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "id_enterprise_locality")
   private Integer idEnterpriseLocality;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 90)
   @Column(name = "txt_addr_street")
   private String txtAddrStreet;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 90)
   @Column(name = "txt_addr_neighborhood")
   private String txtAddrNeighborhood;
   
   @Size(max = 90)
   @Column(name = "txt_addr_adjunct")
   private String txtAddrAdjunct;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 20)
   @Column(name = "txt_addr_zipcode")
   private String txtAddrZipcode;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 11)
   @Column(name = "txt_addr_number")
   private String txtAddrNumber;
   
   // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   @Column(name = "num_addr_latitude")
   private BigDecimal numAddrLatitude;
   
   @Column(name = "num_addr_longitude")
   private BigDecimal numAddrLongitude;
   
   @JoinColumn(name = "id_city", referencedColumnName = "id_city")
   @ManyToOne(optional = false)
   private City idCity;
   
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnterpriseLocality")
   private Collection<Professional> professionalCollection;

   
   public EnterpriseLocality() {
   }

   
   public EnterpriseLocality(Integer idEnterpriseLocality) {
      this.idEnterpriseLocality = idEnterpriseLocality;
   }

   
   public EnterpriseLocality(Integer idEnterpriseLocality, String txtAddrStreet, String txtAddrNeighborhood, String txtAddrZipcode, String txtAddrNumber) {
      this.idEnterpriseLocality = idEnterpriseLocality;
      this.txtAddrStreet = txtAddrStreet;
      this.txtAddrNeighborhood = txtAddrNeighborhood;
      this.txtAddrZipcode = txtAddrZipcode;
      this.txtAddrNumber = txtAddrNumber;
   }

   
   public Integer getIdEnterpriseLocality() {
      return idEnterpriseLocality;
   }

   public void setIdEnterpriseLocality(Integer idEnterpriseLocality) {
      this.idEnterpriseLocality = idEnterpriseLocality;
   }

   public String getTxtAddrStreet() {
      return txtAddrStreet;
   }

   public void setTxtAddrStreet(String txtAddrStreet) {
      this.txtAddrStreet = txtAddrStreet;
   }

   public String getTxtAddrNeighborhood() {
      return txtAddrNeighborhood;
   }

   public void setTxtAddrNeighborhood(String txtAddrNeighborhood) {
      this.txtAddrNeighborhood = txtAddrNeighborhood;
   }

   public String getTxtAddrAdjunct() {
      return txtAddrAdjunct;
   }

   public void setTxtAddrAdjunct(String txtAddrAdjunct) {
      this.txtAddrAdjunct = txtAddrAdjunct;
   }

   public String getTxtAddrZipcode() {
      return txtAddrZipcode;
   }

   public void setTxtAddrZipcode(String txtAddrZipcode) {
      this.txtAddrZipcode = txtAddrZipcode;
   }

   public String getTxtAddrNumber() {
      return txtAddrNumber;
   }

   public void setTxtAddrNumber(String txtAddrNumber) {
      this.txtAddrNumber = txtAddrNumber;
   }

   public BigDecimal getNumAddrLatitude() {
      return numAddrLatitude;
   }

   public void setNumAddrLatitude(BigDecimal numAddrLatitude) {
      this.numAddrLatitude = numAddrLatitude;
   }

   public BigDecimal getNumAddrLongitude() {
      return numAddrLongitude;
   }

   public void setNumAddrLongitude(BigDecimal numAddrLongitude) {
      this.numAddrLongitude = numAddrLongitude;
   }

   public City getIdCity() {
      return idCity;
   }

   public void setIdCity(City idCity) {
      this.idCity = idCity;
   }

   public Collection<Professional> getProfessionalCollection() {
      return professionalCollection;
   }

   public void setProfessionalCollection(Collection<Professional> professionalCollection) {
      this.professionalCollection = professionalCollection;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idEnterpriseLocality != null ? idEnterpriseLocality.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof EnterpriseLocality)) {
         return false;
      }
      EnterpriseLocality other = (EnterpriseLocality) object;
      if ((this.idEnterpriseLocality == null && other.idEnterpriseLocality != null) || (this.idEnterpriseLocality != null && !this.idEnterpriseLocality.equals(other.idEnterpriseLocality))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "br.com.dbserver.heronsanches.lunch.model.entity.EnterpriseLocality[ idEnterpriseLocality=" + idEnterpriseLocality + " ]";
   }

}
