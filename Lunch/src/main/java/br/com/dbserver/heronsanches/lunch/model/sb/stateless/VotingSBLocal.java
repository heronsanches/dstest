package br.com.dbserver.heronsanches.lunch.model.sb.stateless;

import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface VotingSBLocal {
   public byte vote(String email, int idRestaurant);
}
