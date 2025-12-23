package com.fitfinder.service.implementation;

import com.fitfinder.dto.CandidateRequest;
import com.fitfinder.dto.CompanyRequest;
import com.fitfinder.helper.ResourceNotFoundException;
import com.fitfinder.mapper.CandidateMapper;
import com.fitfinder.mapper.CompanyMapper;
import com.fitfinder.model.User;
import com.fitfinder.repository.UserRepo;
import com.fitfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User addUser(CandidateRequest request) {

        User user = CandidateMapper.mapToUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.save(user);

    }

    @Override
    public User addUser(CompanyRequest request) {

        User user = CompanyMapper.mapToUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.save(user);

    }

    @Override
    public User getUser(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }


}
