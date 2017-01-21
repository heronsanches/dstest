package lunch.hour.model.sb.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import lunch.hour.model.entity.Restaurant;
import lunch.hour.model.entity.Voting;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface VotingDAOI {
   
   public boolean insert(Voting vote);
   public boolean verifyIfVoted(String idProfessional, Date date);
   public List<Restaurant> listRestaurantByDate(Date day);
   
}
