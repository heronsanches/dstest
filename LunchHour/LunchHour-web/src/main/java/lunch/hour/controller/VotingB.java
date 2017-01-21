package lunch.hour.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lunch.hour.constants.CodeReturnConstants;
import lunch.hour.sb.stateless.VotingSBLocal;

/**
 *
 * @author Heron Sanches
 */
@Named
@RequestScoped
public class VotingB implements Serializable{
   
   @EJB
   private VotingSBLocal votingSB;
   private String message;
   

   /**
    * Creates a new instance of VotingMB
    */
   public VotingB() {
       System.out.println("VotingMB");
   }
   
   
   public String vote(String email, int idRestaurant){
            
      byte result = votingSB.vote(email, idRestaurant);
      
      if(result == CodeReturnConstants.OK){
         message = "Your vote was computed successfully!";
         //return "Your vote was computed successfully!";
         return "";
      }
      
      if(result == CodeReturnConstants.ALREADY_VOTED_USER){
         message = "You can't vote more than one time on day.";
         return "";
         //return "You can't vote more than one time on day.";
      }
      
      //TODO verify if the restaurant already was choose on week
      //return "Sorry, some error happened, try again or contact the administrator through email hr.sanches@gmail.com.";*/
      message = "Sorry, some error happened, try again or contact the administrator through email hr.sanches@gmail.com.";
      return "#";
   }
   

   public String getMessage() {
      return message;
   }
   
   
}