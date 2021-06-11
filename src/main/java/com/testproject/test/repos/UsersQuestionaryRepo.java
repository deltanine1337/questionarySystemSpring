package com.testproject.test.repos;

import com.testproject.test.model.UsersQuestionary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersQuestionaryRepo extends CrudRepository<UsersQuestionary, Long> {
    @Query(value = "select * from users_questionary uq where uq.login = :login and " +
            "uq.id_questionary = :id", nativeQuery = true)
    List<UsersQuestionary> getUserAnswers(@Param("login") String login, @Param("id") int id);
}
