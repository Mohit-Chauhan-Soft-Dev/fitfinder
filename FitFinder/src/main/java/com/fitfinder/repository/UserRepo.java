package com.fitfinder.repository;

import com.fitfinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    public Optional<User> findByEmail(String email);

}
