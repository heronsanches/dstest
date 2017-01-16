package br.com.dbserver.heronsanches.lunch.model.sb.dao;

import br.com.dbserver.heronsanches.lunch.constants.PersistenceConstants;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Heron Sanches
 */
@Stateless
public class ProfessionalDAO implements ProfessionalDAOLocal {

  @PersistenceContext(unitName = PersistenceConstants.PERSISTENCE_UNIT_NAME)
  private EntityManager em;
  
   
   @Override
   public String getEncryptedPassword(String email) {
      
      try{

         TypedQuery<String> tq = (TypedQuery<String>)em.createNamedQuery("Professional.findTxtPasswordByEmail", String.class);
         tq.setParameter("txtEmail", email);
         return tq.getSingleResult();
         
      }catch(NoResultException nre){
            
      }
      
      return "";
      
   }

   
   @Override
   public String getIdProfessionalByEmail(String email) {
      
      try{

         return (String)em.createNamedQuery("Professional.findIdProfessionalByTxtEmail", String.class)
            .setParameter("txtEmail", email)
            .getSingleResult();
         
      }catch(NoResultException nre){

      }
      
      return "";
      
   }

   
   @Override
   public List<String> findAllEmailByLocalityEnterprise(int idLocality) {
      
      try{

         TypedQuery<String> tq = (TypedQuery<String>)em.createNamedQuery("Professional.findAllEmailByIdEnterpriseLocality", String.class);
         tq.setParameter("locality", idLocality);
         return tq.getResultList();
         
      }catch(NoResultException nre){
            
      }
      
      return null;
      
   }
   
   
}