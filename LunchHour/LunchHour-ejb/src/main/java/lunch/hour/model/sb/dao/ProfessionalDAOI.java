package lunch.hour.model.sb.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface ProfessionalDAOI {
   
   public String getEncryptedPassword(String email);  
   public String getIdProfessionalByEmail(String email);
   public List<String> findAllEmailByLocalityEnterprise(int idLocality);
   
}
