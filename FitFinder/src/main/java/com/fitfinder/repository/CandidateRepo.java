package com.fitfinder.repository;

import com.fitfinder.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, String> {

    Optional<Candidate> findByUserId(String userId);

}
