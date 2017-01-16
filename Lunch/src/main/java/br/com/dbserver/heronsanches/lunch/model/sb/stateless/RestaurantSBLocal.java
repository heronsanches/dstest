package br.com.dbserver.heronsanches.lunch.model.sb.stateless;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface RestaurantSBLocal {
   public List findAllRestaurantOnCity(String professionalEmail);
}
