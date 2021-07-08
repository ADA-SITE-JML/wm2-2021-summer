package com.hw2.blog.repo;

import com.hw2.blog.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    boolean existsUserByEmail(String Email);

    boolean existsUserByUsername(String username);

}
