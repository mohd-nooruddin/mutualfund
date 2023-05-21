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
	@Query(value = "INSERT INTO user1 (username, first_name, last_name, password, email) VALUES (?, ?, ?, ?, ?)", nativeQuery = true)
	void insertUser(@Param("username") String username, @Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("password") String password, @Param("email") String email);

	@Query(value = "SELECT COUNT(*) FROM user1 WHERE username = ?", nativeQuery = true)
	int isUserExists(@Param("username") String username);
}
