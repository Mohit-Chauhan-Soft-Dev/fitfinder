package com.fitfinder.repository;

import com.fitfinder.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepo extends JpaRepository<Company, String> {

    Optional<Company> findByUserId(String userId);

}
