package lunch.hour.model.sb.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface EnterpriseLocalityDAOI {
   public List<Integer> findAll();
}