package lunch.hour.sb.stateless;

import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface LoginSBLocal {
   public String getEncryptedPassword(String email);
}