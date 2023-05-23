package com.user.registration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private  String firstName;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "username", unique = true)
    private String username;

	public User() {
		super();
	}

	public User(Long id, String firstName, boolean isEnabled, String lastName, String password, String role,
			String username) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.isEnabled = isEnabled;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(String firstName, boolean isEnabled, String lastName, String password, String role, String username) {
		super();
		this.firstName = firstName;
		this.isEnabled = isEnabled;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.username = username;
	}
    
    
}


