package com.testproject.test.repos;

import com.testproject.test.model.Questionary;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionaryRepo extends CrudRepository<Questionary, Long> {
    @Query(value = "select * from Questionary q where q.name = :name", nativeQuery = true)
    List<Questionary> getQuestByName(@Param("name") String name);

}
