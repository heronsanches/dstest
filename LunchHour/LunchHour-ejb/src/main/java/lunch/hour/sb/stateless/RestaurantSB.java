package lunch.hour.sb.stateless;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import lunch.hour.model.sb.dao.RestaurantDAOI;

/**
 *
 * @author Heron Sanches
 */
@Stateless
public class RestaurantSB implements RestaurantSBLocal {

   @EJB
   private RestaurantDAOI restaurantDAO;
   
   
   @Override
   public List findAllRestaurantOnCity(String professionalEmail) {
      return restaurantDAO.findAllRestaurantOnCity(professionalEmail);
   }
 
   
}