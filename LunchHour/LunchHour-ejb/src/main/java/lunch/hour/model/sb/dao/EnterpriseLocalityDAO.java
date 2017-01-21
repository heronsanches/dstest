package lunch.hour.model.sb.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import lunch.hour.constants.PersistenceConstants;

/**
 *
 * @author Heron Sanches
 */
@Stateless
public class EnterpriseLocalityDAO implements EnterpriseLocalityDAOI {
   
   @PersistenceContext(unitName = PersistenceConstants.PERSISTENCE_UNIT_NAME)
   private EntityManager em;
   

   @Override
   public List<Integer> findAll() {
      
      try{
         return em.createNamedQuery("EnterpriseLocality.findAll", Integer.class).getResultList();
      }catch(IllegalStateException |  PersistenceException e){
      }
      
      return null;
      
   }
   

}