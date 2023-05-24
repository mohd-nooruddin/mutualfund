package com.user.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.registration.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByUsername(String username);
	
	@Modifying
	@Query (value = "Update from user set is_enabled=? where username=?", nativeQuery = true)
	public void UpdateVerificationStatus(Boolean verificationStatus, String username);
	
}
