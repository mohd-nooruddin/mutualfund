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
	public String addMoneyToWallet(Long customerId, Double amount) {
		updateCustomerWalletRepository.addMoneyToWallet(amount, customerId);
		return "Amount added successfully";
	}

	@Transactional
	public String withdrawMoneyFromWallet(Long customerId, Double amount) {
		updateCustomerWalletRepository.withdrawMoneyFromWallet(amount, customerId);
		return "Amount withdrawn successfully";
	}

	public double getAccountBalance(Long customerId) {
		return updateCustomerWalletRepository.getAccountBalance(customerId);
	}
	
	public Double usedInMf(Long customerId) {
		return updateCustomerWalletRepository.UsedInMf(customerId);		
	}
}
