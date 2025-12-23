package com.fitfinder.service;

import com.fitfinder.dto.CompanyRequest;
import com.fitfinder.model.Company;
import com.fitfinder.model.User;

public interface CompanyService {

    public void addCompany(CompanyRequest request, User user);

    public Company getCompany(String userId);
}
