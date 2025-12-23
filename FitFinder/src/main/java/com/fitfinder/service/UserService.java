package com.fitfinder.service;

import com.fitfinder.dto.CandidateRequest;
import com.fitfinder.dto.CompanyRequest;
import com.fitfinder.model.User;

public interface UserService {

    public User addUser(CandidateRequest request);

    public User addUser(CompanyRequest request);

    public User getUser(String email);
}
