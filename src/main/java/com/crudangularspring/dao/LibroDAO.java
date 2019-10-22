
package com.crudangularspring.dao;

import com.crudangularspring.model.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface LibroDAO extends CrudRepository<Libro, Integer>{

}
