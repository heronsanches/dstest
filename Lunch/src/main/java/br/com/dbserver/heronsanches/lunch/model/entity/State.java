
package br.com.dbserver.heronsanches.lunch.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "state")
@NamedQueries({
   @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s")
   , @NamedQuery(name = "State.findByIdState", query = "SELECT s FROM State s WHERE s.idState = :idState")
   , @NamedQuery(name = "State.findByTxtName", query = "SELECT s FROM State s WHERE s.txtName = :txtName")})
public class State implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2)
   @Column(name = "id_state")
   private String idState;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 100)
   @Column(name = "txt_name")
   private String txtName;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "idState")
   private Collection<City> cityCollection;

   public State() {
   }

   public State(String idState) {
      this.idState = idState;
   }

   public State(String idState, String txtName) {
      this.idState = idState;
      this.txtName = txtName;
   }

   public String getIdState() {
      return idState;
   }

   public void setIdState(String idState) {
      this.idState = idState;
   }

   public String getTxtName() {
      return txtName;
   }

   public void setTxtName(String txtName) {
      this.txtName = txtName;
   }

   public Collection<City> getCityCollection() {
      return cityCollection;
   }

   public void setCityCollection(Collection<City> cityCollection) {
      this.cityCollection = cityCollection;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idState != null ? idState.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof State)) {
         return false;
      }
      State other = (State) object;
      if ((this.idState == null && other.idState != null) || (this.idState != null && !this.idState.equals(other.idState))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "br.com.dbserver.heronsanches.lunch.model.entity.State[ idState=" + idState + " ]";
   }

}
