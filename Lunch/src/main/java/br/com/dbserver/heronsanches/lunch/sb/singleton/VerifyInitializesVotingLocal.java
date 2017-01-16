package br.com.dbserver.heronsanches.lunch.sb.singleton;

import java.time.DayOfWeek;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author heron
 */
@Local
public interface VerifyInitializesVotingLocal {
   public Map<Integer, Map<DayOfWeek, Integer>> getVotingMap();
}