package com.registration.mf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.mf.repository.RegistrationRepository;

import jakarta.transaction.Transactional;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Transactional
    public void insertUser(String username, String firstName, String lastName, String password, String email) {
        registrationRepository.insertUser(username, firstName, lastName, password, email);
    }
    
    public int isUserExists(String username) {
		return registrationRepository.isUserExists(username);
	}
}
