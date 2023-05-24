package com.user.registration.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserOtp {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private Long OTP;
	
	public UserOtp() {
		super();
	}
	public UserOtp(Long id, Long user_id, Long oTP) {
		super();
		this.id = id;
		this.userId = user_id;
		OTP = oTP;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return userId;
	}
	public void setUser_id(Long user_id) {
		this.userId = user_id;
	}
	public Long getOTP() {
		return OTP;
	}
	public void setOTP(Long oTP) {
		OTP = oTP;
	}
	@Override
	public String toString() {
		return "UserOtp [id=" + id + ", user_id=" + userId + ", OTP=" + OTP + "]";
	}
	
	
}
