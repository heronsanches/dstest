
package lunch.hour.model.entity;

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
@Table(name = "restaurant")
@NamedQueries({
   @NamedQuery(name = "Restaurant.findAllByCityProfessional", query = "SELECT r FROM Restaurant r WHERE r.idCity = :idCity")
})
public class Restaurant implements Serializable {

   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "id_restaurant")
   private Integer idRestaurant;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 100)
   @Column(name = "txt_name")
   private String txtName;
   
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
   @NotNull
   @Column(name = "num_addr_latitude")
   private BigDecimal numAddrLatitude;
   
   @NotNull
   @Column(name = "num_addr_longitude")
   private BigDecimal numAddrLongitude;
   
   @JoinColumn(name = "id_city", referencedColumnName = "id_city")
   @ManyToOne(optional = false)
   private City idCity;
   
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
   private Collection<Voting> votingCollection;

   
   public Restaurant() {
   }
   

   public Restaurant(Integer idRestaurant) {
      this.idRestaurant = idRestaurant;
   }
   

   public Restaurant(Integer idRestaurant, String txtName, String txtAddrStreet, String txtAddrNeighborhood, String txtAddrZipcode, String txtAddrNumber) {
      this.idRestaurant = idRestaurant;
      this.txtName = txtName;
      this.txtAddrStreet = txtAddrStreet;
      this.txtAddrNeighborhood = txtAddrNeighborhood;
      this.txtAddrZipcode = txtAddrZipcode;
      this.txtAddrNumber = txtAddrNumber;
   }

   public Integer getIdRestaurant() {
      return idRestaurant;
   }

   public void setIdRestaurant(Integer idRestaurant) {
      this.idRestaurant = idRestaurant;
   }

   public String getTxtName() {
      return txtName;
   }

   public void setTxtName(String txtName) {
      this.txtName = txtName;
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

   public Collection<Voting> getVotingCollection() {
      return votingCollection;
   }

   public void setVotingCollection(Collection<Voting> votingCollection) {
      this.votingCollection = votingCollection;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idRestaurant != null ? idRestaurant.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Restaurant)) {
         return false;
      }
      Restaurant other = (Restaurant) object;
      if ((this.idRestaurant == null && other.idRestaurant != null) || (this.idRestaurant != null && !this.idRestaurant.equals(other.idRestaurant))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "br.com.dbserver.heronsanches.lunch.model.entity.Restaurant[ idRestaurant=" + idRestaurant + " ]";
   }

}
