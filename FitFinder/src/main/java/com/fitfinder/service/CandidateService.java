package com.fitfinder.service;

import com.fitfinder.dto.CandidateRequest;
import com.fitfinder.model.Candidate;
import com.fitfinder.model.User;

public interface
CandidateService {

    public void addCandidate(CandidateRequest candidateRequest, User user);

    public Candidate getCandidate(String userId);

}
