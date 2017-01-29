package lunch.hour.sb.stateless;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface RestaurantSBLocal {
   
   public List findAllRestaurantOnCity(String professionalEmail);
   public List findRestaurantByRange(int first, int qttRows, String txtEmail);
   public Long totalRestaurantOnCity(String professionalEmail);
   
}