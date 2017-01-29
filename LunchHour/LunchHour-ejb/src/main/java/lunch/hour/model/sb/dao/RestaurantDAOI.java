package lunch.hour.model.sb.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface RestaurantDAOI {
   
   public List findAllRestaurantOnCity(String txtEmail);
   public List findRestaurantByRange(int first, int qttRows, String txtEmail);
   public Long totalRestaurantOnCity(String txtEmail);
   
}
