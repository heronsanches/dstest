package br.com.dbserver.heronsanches.lunch.controller;

import br.com.dbserver.heronsanches.lunch.model.entity.Restaurant;
import br.com.dbserver.heronsanches.lunch.model.sb.stateless.RestaurantSBLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Heron Sanches
 */
@Named(value = "restaurantMB")
@ViewScoped
public class RestaurantMB implements Serializable{
   
   @EJB
   private RestaurantSBLocal rsbl;
   
   /*@Inject
   private LoginMB loginMB;*/
   private String email; 
   private  List<Restaurant> data;

   
   /**
    * Creates a new instance of RestaurantMB
    */
   public RestaurantMB() {
   }

   
   @PostConstruct
   private void initializeData(){
      
      email = (String)((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("loginEmail");
      data = rsbl.findAllRestaurantOnCity(email);
      
   }
   
   
   public String getDataJsonArray(){
      
      JsonArrayBuilder jab = Json.createArrayBuilder();
      JsonObjectBuilder job = Json.createObjectBuilder();
      
      for(Restaurant r : data){
         
         job.add("name", r.getTxtName());
         job.add("street", r.getTxtAddrStreet());
         job.add("number", r.getTxtAddrNumber());
         job.add("neighborhood", r.getTxtAddrNeighborhood());
         job.add("latitude", r.getNumAddrLatitude());
         job.add("longitude", r.getNumAddrLongitude());
         job.add("id", r.getIdRestaurant());
         
         jab.add(job.build());
         
      }
      
      return jab.build().toString();
      
   }

   
   public String logout(){
      
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
      return "login?faces-redirect=true";
      
   }
   
   
   public List<Restaurant> getData() {
      return data;
   }

   public String getEmail() {
      return email;
   }
    

}