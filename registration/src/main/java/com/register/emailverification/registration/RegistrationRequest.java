package com.register.emailverification.registration;

import org.hibernate.annotations.NaturalId;

public record RegistrationRequest(
         String firstName,
         String lastName,
         String username,
         String password,
         String role) {

}
