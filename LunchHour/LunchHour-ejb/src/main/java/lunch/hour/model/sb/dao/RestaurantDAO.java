package lunch.hour.model.sb.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import lunch.hour.constants.PersistenceConstants;
import lunch.hour.model.entity.City;
import lunch.hour.model.entity.Restaurant;

/**
 *
 * @author Heron Sanches
 */
@Stateless
public class RestaurantDAO implements RestaurantDAOI {

   @PersistenceContext(unitName = PersistenceConstants.PERSISTENCE_UNIT_NAME)
   private EntityManager em;
   
   
   @Override
   public List findAllRestaurantOnCity(String txtEmail){
      
      try{
         
         TypedQuery<City> tq = (TypedQuery<City>) em.createNamedQuery("Professional.findIdCidadeByTxtEmail", City.class)
         .setParameter("txtEmail", txtEmail);
         
         return em.createNamedQuery("Restaurant.findAllByCityProfessional", Restaurant.class)
            .setParameter("idCity", tq.getSingleResult())
            .getResultList();
         
      }catch(IllegalStateException |  PersistenceException e){
      }
      
      return null;
            
   }
   

   @Override
   public List findRestaurantByRange(int first, int qttRows, String txtEmail) {
      
      try{
         
         TypedQuery<City> tq = (TypedQuery<City>) em.createNamedQuery("Professional.findIdCidadeByTxtEmail", City.class)
         .setParameter("txtEmail", txtEmail);
         
         return em.createNamedQuery("Restaurant.findAllByCityProfessional", Restaurant.class)
            .setParameter("idCity", tq.getSingleResult())
            .setFirstResult(first)
            .setMaxResults(qttRows)
            .getResultList();
         
      }catch(IllegalStateException |  PersistenceException e){
      }
      
      return null;
      
   }
   

   @Override
   public Long totalRestaurantOnCity(String txtEmail) {
      
      try{
         
         TypedQuery<City> tq = (TypedQuery<City>) em.createNamedQuery("Professional.findIdCidadeByTxtEmail", City.class)
         .setParameter("txtEmail", txtEmail);
         
         return em.createNamedQuery("Restaurant.totalRestaurantByCityProfessional", Long.class)
            .setParameter("idCity", tq.getSingleResult())
            .getSingleResult();
         
      }catch(IllegalStateException |  PersistenceException e){
      }
      
      return null;
      
   }
   
   
}