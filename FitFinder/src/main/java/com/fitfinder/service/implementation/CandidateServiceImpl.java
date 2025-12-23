package com.fitfinder.service.implementation;

import com.fitfinder.dto.CandidateRequest;
import com.fitfinder.helper.ResourceNotFoundException;
import com.fitfinder.mapper.CandidateMapper;
import com.fitfinder.model.Candidate;
import com.fitfinder.model.User;
import com.fitfinder.repository.CandidateRepo;
import com.fitfinder.service.CandidateService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;

    @Override
    public void addCandidate(CandidateRequest candidateRequest, User user) {

        Candidate candidate = CandidateMapper.mapToCandidate(candidateRequest, user);
        Candidate savedCandidate = candidateRepo.save(candidate);
        System.out.println("Saved candidate: " + savedCandidate);

    }

    @Override
    public Candidate getCandidate(String userId) {
        return candidateRepo.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Candidate not found"));
    }


}
