package br.com.dbserver.heronsanches.lunch.controller;

import br.com.dbserver.heronsanches.lunch.constants.CodeReturnConstants;
import br.com.dbserver.heronsanches.lunch.model.sb.stateless.VotingSBLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Heron Sanches
 */
@Named(value = "votingMB")
@SessionScoped
public class VotingMB implements Serializable{
   
   @EJB
   private VotingSBLocal voting;
   private String message;
   

   /**
    * Creates a new instance of VotingMB
    */
   public VotingMB() {
   }
   
   
   public String vote(String email, int idRestaurant){
            
      byte result = voting.vote(email, idRestaurant);
      
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