package br.com.dbserver.heronsanches.lunch.model.sb.dao;

import br.com.dbserver.heronsanches.lunch.model.entity.Restaurant;
import br.com.dbserver.heronsanches.lunch.model.entity.Voting;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface VotingDAOLocal {
   
   public boolean insert(Voting vote);
   public boolean verifyIfVoted(String idProfessional, Date date);
   public List<Restaurant> listRestaurantByDate(Date day);
   
}
