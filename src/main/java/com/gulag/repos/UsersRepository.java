package com.gulag.repos;

import com.gulag.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
