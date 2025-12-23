package com.fitfinder.controller;

import com.fitfinder.dto.CompanyResponse;
import com.fitfinder.mapper.CompanyMapper;
import com.fitfinder.model.Company;
import com.fitfinder.model.User;
import com.fitfinder.service.CompanyService;
import com.fitfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public ResponseEntity<CompanyResponse> profile(Principal principal) {

        String email = principal.getName();
        User user = userService.getUser(email);

        String userId = user.getId();
        Company company = companyService.getCompany(userId);

        CompanyResponse candidateResponse = CompanyMapper.mapToCompanyResponse(company, user);

        return new ResponseEntity<>(candidateResponse, HttpStatus.OK);

    }


}
