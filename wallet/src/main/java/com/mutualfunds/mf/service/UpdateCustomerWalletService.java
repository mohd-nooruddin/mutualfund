package com.mutualfunds.mf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutualfunds.mf.repository.UpdateCustomerWalletRepository;

import jakarta.transaction.Transactional;

@Service
public class UpdateCustomerWalletService {
	@Autowired
	UpdateCustomerWalletRepository updateCustomerWalletRepository;

	@Transactional
	public String addMoneyToWallet(long customerId, double amount) {
		updateCustomerWalletRepository.addMoneyToWallet(amount, customerId);
		return "Amount added successfully";
	}

	@Transactional
	public String withdrawMoneyFromWallet(long customerId, double amount) {
		updateCustomerWalletRepository.withdrawMoneyFromWallet(amount, customerId);
		return "Amount withdrawn successfully";
	}

	public double getAccountBalance(long customerId) {
		return updateCustomerWalletRepository.getAccountBalance(customerId);
	}
}