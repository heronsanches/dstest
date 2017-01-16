package br.com.dbserver.heronsanches.lunch.model.sb.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface RestaurantDAOLocal {
   public List findAllRestaurantOnCity(String txtEmail);
}
