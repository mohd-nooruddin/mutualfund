package com.user.registration.service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import com.user.registration.entity.User;
import com.user.registration.entity.UserOtp;
import com.user.registration.entity.UserWalletEntity;
import com.user.registration.repository.UserOtpRepository;
import com.user.registration.repository.UserRepository;
import com.user.registration.repository.UserWalletRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserWalletRepository userWalletRepository;
	
	@Autowired
	private UserOtpRepository userOtpRepository;
	
	
//	Generationg Random Numbers for OTP
	public Long randomNumber() {
		Random random = new Random();
		return random.nextLong(900000)+100000;
	}

	public String sendMail(String to) {
		UserOtp userOtp = new UserOtp();
		Optional<User> userOptional = findByEmail(to);
		if (userOptional.isEmpty()) {
			return "User not found!!!..."
					+ "Register YourSelf First.";
		}
		try {
			userOtp.setOTP(randomNumber());
			String subject = "FundFusion - OTP Verification";
			String body = "Dear "+userOptional.get().getFirstName()+" "+userOptional.get().getLastName()+", \r\n"
					+ "\r\n"
					+ "Thank you for using FundFusion, the leading platform for managing mutual funds. To ensure the security of your account, we require you to verify your email address by entering the One-Time Password (OTP) provided below.\r\n"
					+ "\r\n"
					+ "Please enter the OTP in the FundFusion website to complete the verification process:\r\n"
					+ "\r\n"
					+ "OTP: "+ userOtp.getOTP()+" \r\n"
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
			System.out.println("Email Sent SuccessFully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something Went wrong while sending mail");
			return "Something Went wrong while sending mail";
		}
		 
		try {
			userOtp.setUser_id(userOptional.get().getId());
			userOtpRepository.save(userOtp);
			
		} catch (Exception e) {
			 e.printStackTrace();
			 return "Something Went Wrong!!! While Saving Otp to Database";
		}
		return "Otp Sent Successfully To "+userOptional.get().getFirstName()+" "+userOptional.get().getLastName()+", email : "+userOptional.get().getUsername();
	}

	public Optional<User> findById(Long customerId) {
		return userRepository.findById(customerId);
	}
	
	public Optional<User> findByEmail(String email){
		return userRepository.findByUsername(email);
	}
	
	public String registerUser(User user) {
		String emailsentStatus = null;
		try {
			
			if (!findByEmail(user.getUsername()).isEmpty() ) {
				System.out.println(findByEmail(user.getUsername()));
				return "Email Id: '"+ user.getUsername()+"' \r\n"
						+ "Already Exits. Try With login";
			}
			
			user.setRole("User");
			user.setEnabled(false);
			
//			Registering User Without Verification
			userRepository.save(user);
			
			System.out.println("User Registered Successfully");
			
//			Calling Otp Sent Function 
			emailsentStatus = sendMail(user.getUsername());
			
			System.out.println(emailsentStatus);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Registration Completed \r\n"
				+ ""+emailsentStatus;
	}
	
	@Transactional
	public String OtpVerification(Long otp, String email) {
		UserOtp userOtp =null ;		
		Optional<User> userOptional = null;
		String errorMessage = "";
		try {
			errorMessage = "Something Went wrong while Validating User with Email..";
			userOptional = findByEmail(email);
			if (userOptional.isEmpty()) {
				return "User is Not Registered with email : "+email+" ' \r\n"
						+ "Kindly register first";
			}
			errorMessage = "OTP not Found . \r\n"
					+ "First Initiate OTP ";
			System.out.println("User OTP from User Optional is : "+userOptional.get().getId());
			userOtp = userOtpRepository.findUserOtpByUserId(userOptional.get().getId());
			if (userOtp == null) {
				return errorMessage;
			}
			System.out.println("UserOTP Class's ID : "+userOtp.getId());
			if (userOtp.getOTP().equals(otp)) {
				User user = new User();
				user.setId(userOptional.get().getId());
				user.setFirstName(userOptional.get().getFirstName());
				user.setLastName(userOptional.get().getLastName());
				user.setUsername(userOptional.get().getUsername());
				user.setPassword(userOptional.get().getPassword());
				user.setRole(userOptional.get().getRole());
				user.setEnabled(true);				
				
				errorMessage="Error While Verifying and Updating User Data";
				userRepository.save(user);
				
				UserWalletEntity userWalletEntity = new UserWalletEntity();
				userWalletEntity.setUserId(userOptional.get().getId());
				userWalletEntity.setWalletBalance(0.00);
				Timestamp curTimestamp = new Timestamp(System.currentTimeMillis());
				userWalletEntity.setTransationDate(curTimestamp);
				
				errorMessage= "Error While Instantion of User Account";
//				Initiating User wallet with 0 	Balance 
				userWalletRepository.save(userWalletEntity);
				
				return "OTP Verified Successfully!!!....";
			}else {
				return "Enter Correct OTP";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return errorMessage;
		}
	}
	
}
