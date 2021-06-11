package com.testproject.test.repos;

import com.testproject.test.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepo extends CrudRepository<Answer, Long> {
    @Query(value = "select * from Answer a where a.id_question in(select q.question_id from questionary_question q where" +
            " q.questionary_id in(select qu.id_questionary from Questionary qu where qu.name = :name))", nativeQuery = true)
    //@Query("select a.id_answer from Answer a where a.formulation = :name")
    //@Query(value = "select q.id_questionary from Question q", nativeQuery = true)
    List<Answer> getAnswersFromQuestionary(@Param("name") String name);

    @Query(value = "select * from Answer a where a.id_answer = :id", nativeQuery = true)
        //@Query("select a.id_answer from Answer a where a.formulation = :name")
        //@Query(value = "select q.id_questionary from Question q", nativeQuery = true)
    List<Answer> getAnswersById(@Param("id") int id);
}
