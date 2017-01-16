package br.com.dbserver.heronsanches.lunch.model.sb.stateless;

import br.com.dbserver.heronsanches.lunch.model.sb.dao.ProfessionalDAOLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Heron Sanches
 */
@Stateless
public class LoginSB implements LoginSBLocal {

   @EJB
   private ProfessionalDAOLocal pdl;


   @Override
   public String getEncryptedPassword(String email) {
      return pdl.getEncryptedPassword(email);
   }
   
   
}