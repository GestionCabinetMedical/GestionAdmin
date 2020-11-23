/**
 * 
 */
package com.repo;

import org.springframework.stereotype.Repository;

import com.entity.QuestionReponse;

/**
 * Interface repository {@code IQuestionReponseRepo} spécifique de {@link QuestionReponse}. 
 * Elle étend {@code IDaoRepo}.
 * @see IDaoRepo
 * @author Maxime Rembert
 *
 */
@Repository
public interface IQuestionReponseRepo extends IDaoRepo<QuestionReponse>{

}
