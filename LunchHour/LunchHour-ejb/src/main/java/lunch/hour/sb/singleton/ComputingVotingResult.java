package lunch.hour.sb.singleton;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import lunch.hour.model.sb.dao.EnterpriseLocalityDAOI;
import lunch.hour.model.sb.dao.ProfessionalDAOI;
import lunch.hour.model.sb.dao.VotingDAOI;
import lunch.hour.model.entity.Restaurant;
import lunch.hour.utils.EmailUtils;

/**
 *
 * @author Heron Sanches
 */
@Singleton
@Startup
//@DependsOn("VerifyInitializesVoting")
public class ComputingVotingResult {
   
   /*@EJB
   private VerifyInitializesVotingLocal vivl;*/
   
   private VotingDAOI votingDAO;
   private EnterpriseLocalityDAOI enterpriseLocalityDAO;
   private ProfessionalDAOI professionalDAO;
   
   private Map<Integer, Integer> auxMap;
   private Map<Integer, Restaurant> restaurantMap;
   
   private String choosedPlace = "";
   private String messageContent = "";
   

   @Schedule(minute = "25", hour = "11", dayOfWeek = "Mon-Fri")
   public void sendResult(){
      
      LocalDate today = LocalDate.now();
      Integer qttVotes;
      auxMap = new HashMap<>(); 

      for (Integer idEnterprise : enterpriseLocalityDAO.findAll()) { //verifies all enterprises
         
         auxMap.clear();
         restaurantMap = new HashMap<>();
         
         for (Restaurant r : votingDAO.listRestaurantByDate(java.sql.Date.valueOf(today))) {

            restaurantMap.put(r.getIdRestaurant(), r);
            qttVotes = auxMap.get(r.getIdRestaurant());

            if (qttVotes != null) {
               auxMap.put(r.getIdRestaurant(), qttVotes + 1);
            } else {
               auxMap.put(r.getIdRestaurant(), 1);
            }

         }

         //verify the most voted on MONDAY
         Iterator<Map.Entry<Integer, Integer>> itr = auxMap.entrySet().iterator();
         Map.Entry<Integer, Integer> esFirst = itr.next();
         int idRestaurant = esFirst.getKey();

         while (itr.hasNext()) {

            Map.Entry<Integer, Integer> es = itr.next();

            if (auxMap.get(idRestaurant) < es.getValue()) {
               idRestaurant = es.getKey();
            }

         }

         //vivl.getVotingMap().get(idEnterprise).put(today.getDayOfWeek(), idRestaurant);
         
         //send emails to all colaborators of each enterprise!
         choosedPlace = restaurantMap.get(idRestaurant).getTxtName()+"\n"+restaurantMap.get(idRestaurant).getTxtAddrStreet()+", "+restaurantMap.get(idRestaurant).getTxtAddrNumber()
            +" - "+restaurantMap.get(idRestaurant).getTxtAddrNeighborhood();

         messageContent = "<div>\n" +
            "	<h3>DBSERVER Lunch Hour Result</h3>\n" +
            "	<p>The place choosed by us today was: <b>"+choosedPlace+"</b></p>\n" +
            "</div>";
         
         for(String s : professionalDAO.findAllEmailByLocalityEnterprise(idEnterprise))
            EmailUtils.enviarEmail("hr.sanches@gmail.com", messageContent, "DBSERVER Lunch Hour Result", s);

      }

   }
   
   
}