package com.kata.security.web.security.web.repositories;


import com.kata.security.web.security.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    @Query("Select u from User u left join fetch u.roles where u.username=:name")
    Optional<User> findByUsername(String name);
    @Query("Select distinct u from User u join fetch u.roles")
    public List<User> findAll();
    @Query("Select u from User u left join fetch u.roles where u.id=:id")
    public User findById(int id);
}
