package com.user.registration.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import com.user.registration.entity.User;
import com.user.registration.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public Long randomNumber() {
		Random random = new Random();
		return random.nextLong(900000)+100000;
	}

	public void sendMail(String to) {
		
//		customerOtp.setOTP(randomNumber());
		Optional<User> cusOptional = findByEmail(to);
		String subject = "FundFusion - OTP Verification";
		String body = "Dear "+cusOptional.get().getFirstName()+" "+cusOptional.get().getLastName()+", \r\n"
				+ "\r\n"
				+ "Thank you for using FundFusion, the leading platform for managing mutual funds. To ensure the security of your account, we require you to verify your email address by entering the One-Time Password (OTP) provided below.\r\n"
				+ "\r\n"
				+ "Please enter the OTP in the FundFusion website to complete the verification process:\r\n"
				+ "\r\n"
				+ "OTP: "+ randomNumber()+" \r\n"
				+ "\r\n"
				+ "If you didn't initiate this verification, please ignore this email.\r\n"
				+ "\r\n"
				+ "Thank you for choosing FundFusion!\r\n"
				+ "\r\n"
				+ "Best regards,\r\n"
				+ "The FundFusion Team"
				+ "";
		System.out.println(body);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		 mailMessage.setTo(to);
		 mailMessage.setSubject(subject);
		 mailMessage.setText(body);
		 mailMessage.setFrom("fundfusion.mf@gmail.com");
		 
		 mailSender.send(mailMessage);
		 
//		 customerOtp.setCustomer_id(cusOptional.get().getCustomerId());
		 
//		 userRepository.save(customerOtp);
	}

	public Optional<User> findById(Long customerId) {
		return userRepository.findById(customerId);
	}
	
	public Optional<User> findByEmail(String email){
		return userRepository.findByUsername(email);
	}
	
	public String registerUser(User user) {
		try {
			
			if (!findByEmail(user.getUsername()).isEmpty() ) {
				System.out.println(findByEmail(user.getUsername()));
				return "Email Id Already Exits";
			}
//			CustomerCredentials customerCredentials = new CustomerCredentials();
//			customerCredentials.setUserName(customer.getEmailId());
//			customerCredentials.setPassword(customer.getVerificationStatus());
			
//			customer.setVerificationStatus("Pending");	
			
//			Adding Cutomer Data To Customer Table Without Password 
//			customerRepository.save(customer);
//			Adding customer username and password in other table
//			customerCredentialsRepository.save(customerCredentials);
			user.setRole("User");
			userRepository.save(user);
			
			System.out.println("Registration Filled");
			
			sendMail(user.getUsername());
			
			System.out.println("Email Sent Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Registration Completed and OTP has been sent";
	}
	
}
