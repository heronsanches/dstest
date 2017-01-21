package lunch.hour.sb.singleton;

import java.time.DayOfWeek;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface VerifyInitializesVotingLocal {
   public Map<Integer, Map<DayOfWeek, Integer>> getVotingMap();
}