package com.registration.mf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.registration.mf.entity.RegistrationEntity;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, String> {

	@Modifying
    @Query(value = "INSERT INTO user (username, first_name, last_name, password) VALUES (?, ?, ?, ?)",
            nativeQuery = true)
    void insertUser(@Param("username") String username, @Param("firstName") String firstName,
                    @Param("lastName") String lastName, @Param("password") String password);
    
    @Query(value = "SELECT COUNT(*) FROM user WHERE username = ?", nativeQuery = true)
    int isUserExists(@Param("username") String username);
}
