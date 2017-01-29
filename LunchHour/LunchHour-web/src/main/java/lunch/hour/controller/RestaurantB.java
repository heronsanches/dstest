package lunch.hour.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
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
/*@SessionScoped OBS.: With this scope and the "binding" into "<h:dataTable>" to "HtmlDataTable dataTable", when refreshes the lunch.xhtml it shows that
   Component ID dt_restaurant:j_idt9 has already been found in the view. */
@ViewScoped
public class RestaurantB implements Serializable {

   @EJB
   private RestaurantSBLocal restaurantSB;

   /*@Inject :
   private LoginB loginMB;
   OBS: it creates another instance of RestaurantB to the same session, because it I used sessionMap on initializeData()
    */
   
   /**It maintains only the data showed on the specified pagination page*/
   private Collection<Restaurant> data;
   private HtmlDataTable dataTable;
   private int rowsOnPage;
   private Long totalRows;
   private String professionalEmail;
   
   /**It controls the real initial row of the data, and it is used to the lazy search on database and to help show
    the number page on pagination.*/
   private int first;

   
   /**
    * Creates a new instance of RestaurantMB
    */
   public RestaurantB() {
      System.out.println("RestaurantMB");
   }

   
   @PostConstruct
   private void initializeData() {

      rowsOnPage = 3;
      professionalEmail = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginEmail");
      totalRows = restaurantSB.totalRestaurantOnCity(professionalEmail);
      totalRows = totalRows != null ? totalRows : 0;
      data = restaurantSB.findRestaurantByRange(0, rowsOnPage, professionalEmail);

   }

   
   public String getDataJsonArray() {

      JsonArrayBuilder jab = Json.createArrayBuilder();
      JsonObjectBuilder job = Json.createObjectBuilder();
      System.out.println("getDataJsonArray(): "+first);
      for (Restaurant r : data) {

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

   
   public void orderByName(String orderBy) {

      if (orderBy.contentEquals("asc")) {

         Collections.sort((List) data, new Comparator<Restaurant>() {

            @Override
            public int compare(Restaurant t, Restaurant t1) {
               return t.getTxtName().compareTo(t1.getTxtName());
            }

         });

         return;

      }

      if (orderBy.contentEquals("desc")) {

         Collections.sort((List) data, new Comparator<Restaurant>() {

            @Override
            public int compare(Restaurant t, Restaurant t1) {
               return t1.getTxtName().compareTo(t.getTxtName());
            }

         });

      }

      System.out.println("orderAscName");

   }

   
   public String pageOfPages(){
      return (first / rowsOnPage + 1)+" of "+totalPages();
   }
   
   
   private long totalPages(){
      
      if(totalRows % rowsOnPage == 0)
         return totalRows / rowsOnPage;
      
      return totalRows / rowsOnPage + 1; //ceil value
      
   }
   
   
   public boolean isLastPage(){

      if( (totalPages() * rowsOnPage -  rowsOnPage) == first)
         return true;

      return false;

   }
   
   
   public void goToFirstPage(){
      
      data.clear();
      data.addAll(restaurantSB.findRestaurantByRange(0, rowsOnPage, professionalEmail));
      dataTable.setValue(data);
      dataTable.setFirst(0);
      first = 0;

   }
   
   
   public boolean isFirstPage(){
      return first == 0;
   }
   
   
   public void goToPreviousPage(){
      
      first = first - rowsOnPage;
      data.clear();
      data.addAll(restaurantSB.findRestaurantByRange(first, rowsOnPage, professionalEmail));
      dataTable.setFirst(0); 

   }
   

   public void goToNextPage() { 
      
      first = first + rowsOnPage;
      data.clear();
      data.addAll(restaurantSB.findRestaurantByRange(first, rowsOnPage, professionalEmail));
      dataTable.setFirst(0);
      System.out.println("goToNextPage()"+first);

   }
   
   
   public void goToLastPage() { 
      
      int full = totalRows.intValue() / rowsOnPage; 
      int modulo = totalRows.intValue() % rowsOnPage;
      
      if (modulo > 0) {
         
         data.clear();
         data.addAll(restaurantSB.findRestaurantByRange(full * rowsOnPage, rowsOnPage, professionalEmail));
         dataTable.setFirst(0); 
         
      } else {
         
         data.clear();
         data.addAll(restaurantSB.findRestaurantByRange((full - 1) * rowsOnPage, rowsOnPage, professionalEmail));
         dataTable.setFirst(0); 
         
      }      
      
   }
   

   //getters and setters
   public Collection<Restaurant> getData() {
      return data;
   }

   public HtmlDataTable getDataTable() {
      return dataTable;
   }

   public void setDataTable(HtmlDataTable dataTable) {
      this.dataTable = dataTable;
   }

   public int getRowsOnPage() {
      return rowsOnPage;
   }
   

}