package lunch.hour.sb.singleton;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import static javax.ejb.ConcurrencyManagementType.CONTAINER;
import javax.ejb.Lock;
import static javax.ejb.LockType.READ;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import lunch.hour.model.sb.dao.EnterpriseLocalityDAOI;
import lunch.hour.model.sb.dao.VotingDAOI;

/**
 *
 * @author Heron Sanches
 */
@Singleton(name = "VerifyInitializesVoting")
@Startup
@ConcurrencyManagement(CONTAINER)
public class VerifyInitializesVoting implements VerifyInitializesVotingLocal {

   private VotingDAOI votingDAO;
   private EnterpriseLocalityDAOI enterpriseLocalityDAO;

   private Map<Integer, Integer> auxMap;

   /**
    * represents the map of restaurants with the most voting during week
    * Map<dayOfWeek, idRestaurant>
    */
   // private Map<DayOfWeek, Integer> votingMap;
   /**
    * Map<ID_ENTERPRISE_LOCALITY, Map<dayOfWeek, idRestaurant>>
    */
   private Map<Integer, Map<DayOfWeek, Integer>> allEnterprisesVotingMap;

   public VerifyInitializesVoting() {

      this.auxMap = new HashMap<>();
      this.allEnterprisesVotingMap = new HashMap<>();

   }

   @Lock(READ)
   @Override
   public Map<Integer, Map<DayOfWeek, Integer>> getVotingMap() {
      return allEnterprisesVotingMap;
   }

   @PostConstruct
   private void initializesVotingMap() {

      /*LocalDate today = LocalDate.now();
      Integer qttVotes;
      DayOfWeek dayOwToday = today.getDayOfWeek();

      for (Integer idEnterprise : eldl.findAll()) { //verifies all enterprises
         
         allEnterprisesVotingMap.put(idEnterprise, new HashMap<>()); //begining of the population of the map

         if (dayOwToday == DayOfWeek.MONDAY) {

            auxMap.clear();

            for (Restaurant r : vdl.listRestaurantByDate(java.sql.Date.valueOf(today))) {

               qttVotes = auxMap.get(r.getIdRestaurant());

               if (qttVotes != null) {
                  auxMap.put(r.getIdRestaurant(), qttVotes + 1);
               } else {
                  auxMap.put(r.getIdRestaurant(), 1);
               }
                  System.out.println("forrrrr auxMap");
            }

            //verify the most voted on MONDAY
            Iterator<Entry<Integer, Integer>> itr = auxMap.entrySet().iterator();
            Entry<Integer, Integer> esFirst = itr.next();
            int idRestaurant = esFirst.getKey();

            while (itr.hasNext()) {

               Entry<Integer, Integer> es = itr.next();

               if (auxMap.get(idRestaurant) < es.getValue()) {
                  idRestaurant = es.getKey();
               }

            }

            allEnterprisesVotingMap.get(idEnterprise).put(DayOfWeek.MONDAY, idRestaurant);

         } else if (dayOwToday == DayOfWeek.TUESDAY) {

            java.util.Date date = java.sql.Date.valueOf(today);
            today.minusDays(1); //seg, query on database
            //TODO the same approach

         } else if (dayOwToday == DayOfWeek.WEDNESDAY) {

            java.util.Date date = java.sql.Date.valueOf(today);
            today.minusDays(1); //seg, ter and so query on database
            //TODO the same approach

         } else if (dayOwToday == DayOfWeek.THURSDAY) {

            java.util.Date date = java.sql.Date.valueOf(today);
            today.minusDays(1); //seg, ter and so query on database
            //TODO the same approach

         } else if (dayOwToday == DayOfWeek.FRIDAY) {

            java.util.Date date = java.sql.Date.valueOf(today);
            today.minusDays(1); //seg, ter and so query on database
            //TODO the same approach

         }

      }*/

   }
   
   
}