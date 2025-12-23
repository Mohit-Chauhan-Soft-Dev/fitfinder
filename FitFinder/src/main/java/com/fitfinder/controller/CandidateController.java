package com.fitfinder.controller;

import com.fitfinder.dto.CandidateResponse;
import com.fitfinder.mapper.CandidateMapper;
import com.fitfinder.model.Candidate;
import com.fitfinder.model.User;
import com.fitfinder.service.CandidateService;
import com.fitfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public ResponseEntity<CandidateResponse> profile(Principal principal) {

        System.out.println(principal.getName());

        String email = principal.getName();
        User user = userService.getUser(email);

        String userId = user.getId();
        Candidate candidate = candidateService.getCandidate(userId);

        CandidateResponse candidateResponse = CandidateMapper.mapToCandidateResponse(candidate, user);

        return new ResponseEntity<>(candidateResponse, HttpStatus.OK);

    }



}
