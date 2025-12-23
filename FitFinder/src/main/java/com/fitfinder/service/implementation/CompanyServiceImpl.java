package com.fitfinder.service.implementation;

import com.fitfinder.dto.CompanyRequest;
import com.fitfinder.helper.ResourceNotFoundException;
import com.fitfinder.mapper.CompanyMapper;
import com.fitfinder.model.Company;
import com.fitfinder.model.User;
import com.fitfinder.repository.CompanyRepo;
import com.fitfinder.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public void addCompany(CompanyRequest request, User user) {

        Company company = CompanyMapper.mapToCompany(request, user);
        Company savedCompany = companyRepo.save(company);

        System.out.println("Saved company: " + savedCompany);

    }

    @Override
    public Company getCompany(String userId) {
        return companyRepo.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Company not found"));
    }
}
