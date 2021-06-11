package com.testproject.test.repos;

import com.testproject.test.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<Question, Long> {
}
