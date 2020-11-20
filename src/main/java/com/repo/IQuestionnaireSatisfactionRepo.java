/**
 * 
 */
package com.repo;

import org.springframework.stereotype.Repository;

import com.entity.QuestionnaireSatisfaction;

/**
 * @author Pauline Humbert
 * 
 * Interface repository de l'entité QuestionnaireSatisfaction qui étend de {@code IDaoRepo}.
 * @see IDaoRepo
 *
 */
@Repository
public interface IQuestionnaireSatisfactionRepo extends IDaoRepo<QuestionnaireSatisfaction>{

}
