package lunch.hour.sb.stateless;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import lunch.hour.model.sb.dao.ProfessionalDAOI;

/**
 *
 * @author Heron Sanches
 */
@Stateless
public class LoginSB implements LoginSBLocal {

   @EJB
   private ProfessionalDAOI professionalDAO;


   @Override
   public String getEncryptedPassword(String email) {
      return professionalDAO.getEncryptedPassword(email);
   }
   
   
}