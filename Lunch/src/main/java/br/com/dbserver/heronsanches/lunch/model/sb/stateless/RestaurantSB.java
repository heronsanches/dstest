package br.com.dbserver.heronsanches.lunch.model.sb.stateless;

import br.com.dbserver.heronsanches.lunch.model.sb.dao.RestaurantDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Heron Sanches
 */
@Stateless
public class RestaurantSB implements RestaurantSBLocal {

   @EJB
   private RestaurantDAOLocal rdl;
   
   
   @Override
   public List findAllRestaurantOnCity(String professionalEmail) {
      return rdl.findAllRestaurantOnCity(professionalEmail);
   }
   
   
}