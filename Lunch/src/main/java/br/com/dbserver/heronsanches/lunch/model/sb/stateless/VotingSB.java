package br.com.dbserver.heronsanches.lunch.model.sb.stateless;

import br.com.dbserver.heronsanches.lunch.constants.CodeReturnConstants;
import br.com.dbserver.heronsanches.lunch.model.entity.Voting;
import br.com.dbserver.heronsanches.lunch.model.sb.dao.ProfessionalDAOLocal;
import br.com.dbserver.heronsanches.lunch.model.sb.dao.VotingDAOLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dbserver.heronsanches.lunch.sb.singleton.VerifyInitializesVotingLocal;
/**
 *
 * @author Heron Sanches
 */
@Stateless
public class VotingSB implements VotingSBLocal {
   
   @EJB
   private VotingDAOLocal vdl;
   
   @EJB 
   private ProfessionalDAOLocal pdl;
   
   /*@EJB
   private VerifyInitializesVotingLocal vv;*/
   

   @Override
   public byte vote(String email, int idRestaurant) {
            
      String idProfessional = pdl.getIdProfessionalByEmail(email);
      
      if(vdl.verifyIfVoted(idProfessional, new Date()))
         return CodeReturnConstants.ALREADY_VOTED_USER;
           
      /*if(vv.getVotingMap().containsValue(idRestaurant))
         return CodeReturnConstants.ALREADY_VOTED_RESTAURANT;*/
      
      if(vdl.insert(new Voting(idProfessional, idRestaurant, new Date())))
         return CodeReturnConstants.OK;
      
      return CodeReturnConstants.ERROR;
      
   }
   
   
}