
package lunch.hour.model.entity;

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
@Table(name = "city")
@NamedQueries({
   @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
   , @NamedQuery(name = "City.findByIdCity", query = "SELECT c FROM City c WHERE c.idCity = :idCity")
   , @NamedQuery(name = "City.findByTxtName", query = "SELECT c FROM City c WHERE c.txtName = :txtName")})
public class City implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @NotNull
   @Column(name = "id_city")
   private Integer idCity;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 100)
   @Column(name = "txt_name")
   private String txtName;
   @JoinColumn(name = "id_state", referencedColumnName = "id_state")
   @ManyToOne(optional = false)
   private State idState;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCity")
   private Collection<EnterpriseLocality> enterpriseLocalityCollection;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCity")
   private Collection<Restaurant> restaurantCollection;

   public City() {
   }

   public City(Integer idCity) {
      this.idCity = idCity;
   }

   public City(Integer idCity, String txtName) {
      this.idCity = idCity;
      this.txtName = txtName;
   }

   public Integer getIdCity() {
      return idCity;
   }

   public void setIdCity(Integer idCity) {
      this.idCity = idCity;
   }

   public String getTxtName() {
      return txtName;
   }

   public void setTxtName(String txtName) {
      this.txtName = txtName;
   }

   public State getIdState() {
      return idState;
   }

   public void setIdState(State idState) {
      this.idState = idState;
   }

   public Collection<EnterpriseLocality> getEnterpriseLocalityCollection() {
      return enterpriseLocalityCollection;
   }

   public void setEnterpriseLocalityCollection(Collection<EnterpriseLocality> enterpriseLocalityCollection) {
      this.enterpriseLocalityCollection = enterpriseLocalityCollection;
   }

   public Collection<Restaurant> getRestaurantCollection() {
      return restaurantCollection;
   }

   public void setRestaurantCollection(Collection<Restaurant> restaurantCollection) {
      this.restaurantCollection = restaurantCollection;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idCity != null ? idCity.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof City)) {
         return false;
      }
      City other = (City) object;
      if ((this.idCity == null && other.idCity != null) || (this.idCity != null && !this.idCity.equals(other.idCity))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "br.com.dbserver.heronsanches.lunch.model.entity.City[ idCity=" + idCity + " ]";
   }

}
