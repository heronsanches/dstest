package br.com.dbserver.heronsanches.lunch.model.sb.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Heron Sanches
 */
@Local
public interface EnterpriseLocalityDAOLocal {
   public List<Integer> findAll();
}