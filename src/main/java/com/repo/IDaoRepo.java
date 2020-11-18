/**
 * 
 */
package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface repository responsable de la communication avec la base de donnée
 * pour tout le projet. Elle implémente JpaRepository.
 * 
 * @author Maxime Rembert
 *
 */
public interface IDaoRepo<E> extends JpaRepository<E, Long> {

}
