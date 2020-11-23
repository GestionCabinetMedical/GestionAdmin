/**
 * 
 */
package com.repo;

import org.springframework.stereotype.Repository;

import com.entity.QuestionnaireSatisfaction;

/**
 * @author Pauline Humbert
 * 
 * Interface repository {@code IQuestionnaireSatisfactionRepo} spécifique de {@link QuestionnaireSatisfaction}  
 * et qui étend de {@code IDaoRepo}.
 * @see IDaoRepo
 *
 */
@Repository
public interface IQuestionnaireSatisfactionRepo extends IDaoRepo<QuestionnaireSatisfaction>{

}
