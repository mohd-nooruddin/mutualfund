package com.user.registration.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.registration.entity.User;
import com.user.registration.service.UserService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	

	@GetMapping("/sample")
	public String sampleString() {
		return "Sample string";
	}
	
	@GetMapping("/find/{id}")
	public Optional<User> findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/finder")
	public Optional<User> findByEmail(@RequestParam("email") String email){
		return userService.findByEmail(email);
	}
	
	@GetMapping("/send")
	public String sendEmail(@RequestParam("email") String to) {
		return userService.sendMail(to);
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@PutMapping("/verification")
	public String otpVerification(@RequestParam("email") String email, @RequestParam("otp") Long otp) {
		return userService.OtpVerification(otp, email);
	}
}

