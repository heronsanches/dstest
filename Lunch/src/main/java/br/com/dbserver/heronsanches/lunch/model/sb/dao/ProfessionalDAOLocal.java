package br.com.dbserver.heronsanches.lunch.model.sb.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author heron
 */
@Local
public interface ProfessionalDAOLocal {
   
   public String getEncryptedPassword(String email);  
   public String getIdProfessionalByEmail(String email);
   public List<String> findAllEmailByLocalityEnterprise(int idLocality);
   
}
