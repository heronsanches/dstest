package br.com.dbserver.heronsanches.lunch.model.sb.dao;

import br.com.dbserver.heronsanches.lunch.constants.PersistenceConstants;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Heron Sanches
 */
@Stateless
public class EnterpriseLocalityDAO implements EnterpriseLocalityDAOLocal {
   
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