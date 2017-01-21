package lunch.hour.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import lunch.hour.model.entity.Restaurant;
import lunch.hour.sb.stateless.RestaurantSBLocal;

/**
 *
 * @author Heron Sanches
 */
@Named
@SessionScoped
public class RestaurantB implements Serializable{
   
   @EJB
   private RestaurantSBLocal restaurantSB;
   
   /*@Inject :
   private LoginB loginMB;
   OBS: it creates another instance of RestaurantB to the same session, because it I used sessionMap on initializeData()
   */
   private  List<Restaurant> data;

   
   /**
    * Creates a new instance of RestaurantMB
    */
   public RestaurantB() {
      System.out.println("RestaurantMB");
   }

   
   @PostConstruct
   public void initializeData(){
      data = restaurantSB.findAllRestaurantOnCity((String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginEmail"));
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


   public List<Restaurant> getData() {
      return data;
   }
    

}