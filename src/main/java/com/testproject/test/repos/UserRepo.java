package com.testproject.test.repos;

import com.testproject.test.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<Users, Long> {
    @Query(value = "select * from user u where u.login = :login", nativeQuery = true)
    List<Users> getUsersByLogin(@Param("login") String login);
}
