package com.user.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.registration.entity.UserOtp;

@Repository
public interface UserOtpRepository extends JpaRepository<UserOtp, Long>{
	
	@Query(value = "Select * from user_otp where user_id=? order by id desc limit 1",nativeQuery = true)
	public UserOtp findUserOtpByUserId(Long idLong);
	@Query(value = "Select * from user_otp where user_id=?",nativeQuery = true)
	public List<UserOtp> findAllUserOtpByUserId(Long idLong);
}
