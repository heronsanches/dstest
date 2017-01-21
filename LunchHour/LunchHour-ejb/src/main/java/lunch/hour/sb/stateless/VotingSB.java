package lunch.hour.sb.stateless;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import lunch.hour.constants.CodeReturnConstants;
import lunch.hour.model.sb.dao.ProfessionalDAOI;
import lunch.hour.model.sb.dao.VotingDAOI;
import lunch.hour.model.entity.Voting;
/**
 *
 * @author Heron Sanches
 */
@Stateless
public class VotingSB implements VotingSBLocal {
   
   @EJB
   private VotingDAOI votingDAO;
   
   @EJB
   private ProfessionalDAOI professionalDAO;
   
   /*@EJB
   private VerifyInitializesVotingLocal vv;*/
   

   @Override
   public byte vote(String email, int idRestaurant) {
            
      String idProfessional = professionalDAO.getIdProfessionalByEmail(email);
      
      if(votingDAO.verifyIfVoted(idProfessional, new Date()))
         return CodeReturnConstants.ALREADY_VOTED_USER;
           
      /*if(vv.getVotingMap().containsValue(idRestaurant))
         return CodeReturnConstants.ALREADY_VOTED_RESTAURANT;*/
      
      if(votingDAO.insert(new Voting(idProfessional, idRestaurant, new Date())))
         return CodeReturnConstants.OK;
      
      return CodeReturnConstants.ERROR;
      
   }
   
   
}