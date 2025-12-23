package com.fitfinder.mapper;

import com.fitfinder.dto.CandidateRequest;
import com.fitfinder.dto.CandidateResponse;
import com.fitfinder.model.Candidate;
import com.fitfinder.model.User;

import java.util.UUID;

public class CandidateMapper {


    public static User mapToUser(CandidateRequest candidateRequest) {
        return new User(
                UUID.randomUUID().toString(),
                candidateRequest.getEmail(),
                false,
                candidateRequest.getPassword(),
                "CANDIDATE"
        );
    }

    public static Candidate mapToCandidate(CandidateRequest candidateRequest, User user) {
        return new Candidate(
                UUID.randomUUID().toString(),
                candidateRequest.getName(),
                candidateRequest.getPhone(),
                false,
                user
        );
    }

    public static CandidateResponse mapToCandidateResponse(Candidate candidate, User user) {
        return new CandidateResponse(
                user.getId(),
                candidate.getName(),
                user.getEmail(),
                candidate.getPhone(),
                user.getRole()
        );
    }
}
