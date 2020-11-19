/**
 * 
 */
package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface repository responsable de la communication avec la base de donnée
 * pour tout le projet. Elle implémente JpaRepository.
 * 
 * @author Maxime Rembert
 *
 */
@NoRepositoryBean
public interface IDaoRepo<E> extends JpaRepository<E, Long> {

}
