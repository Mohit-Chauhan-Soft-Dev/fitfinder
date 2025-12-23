package com.fitfinder.mapper;

import com.fitfinder.dto.CompanyRequest;
import com.fitfinder.dto.CompanyResponse;
import com.fitfinder.model.Company;
import com.fitfinder.model.User;

import java.util.UUID;

public class CompanyMapper {

    public static User mapToUser(CompanyRequest companyRequest) {
        return new User(
                UUID.randomUUID().toString(),
                companyRequest.getEmail(),
                false,
                companyRequest.getPassword(),
                "COMPANY"
        );
    }

    public static Company mapToCompany(CompanyRequest companyRequest, User user) {
        return new Company(
                UUID.randomUUID().toString(),
                companyRequest.getName(),
                companyRequest.getIndustry(),
                companyRequest.getPhone(),
                false,
                user
        );
    }

    public static CompanyResponse mapToCompanyResponse(Company company,  User user) {

        return new CompanyResponse(
                user.getId(),
                company.getName(),
                user.getEmail(),
                company.getIndustry(),
                company.getPhone(),
                user.getRole()
        );

    }
}
