package com.fitfinder.controller;

import com.fitfinder.dto.CandidateRequest;
import com.fitfinder.dto.CompanyRequest;
import com.fitfinder.model.User;
import com.fitfinder.service.CandidateService;
import com.fitfinder.service.CompanyService;
import com.fitfinder.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@NoArgsConstructor
@AllArgsConstructor
public class AuthController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @PostMapping("/candidate/register")
    public ResponseEntity<String> registerCandidate(@Valid @RequestBody CandidateRequest request, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        System.out.println(request);
        User user = userService.addUser(request);

        candidateService.addCandidate(request, user);
        return new ResponseEntity<>("Registration for candidate is successfull!", HttpStatus.CREATED);

    }

    @PostMapping("/company/register")
    public ResponseEntity<String> registerCompany(@Valid @RequestBody CompanyRequest request,  BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        System.out.println(request);
        User user = userService.addUser(request);

        companyService.addCompany(request, user);
        return new ResponseEntity<>("Registration for company is successfull!", HttpStatus.CREATED);

    }
}

