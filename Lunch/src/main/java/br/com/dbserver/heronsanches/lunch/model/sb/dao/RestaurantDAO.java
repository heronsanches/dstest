package br.com.dbserver.heronsanches.lunch.model.sb.dao;

import br.com.dbserver.heronsanches.lunch.constants.PersistenceConstants;
import br.com.dbserver.heronsanches.lunch.model.entity.City;
import br.com.dbserver.heronsanches.lunch.model.entity.Restaurant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Heron Sanches
 */
@Stateless
public class RestaurantDAO implements RestaurantDAOLocal {

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
   
   
}