package com.mutualFundTransactions.mf.service;

import com.mutualFundTransactions.mf.entity.MutualFundTransactionHistoryEntity;
import com.mutualFundTransactions.mf.repository.MutualFundTransactionHistoryRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutualFundTransactionHistoryService {

	private final MutualFundTransactionHistoryRepository transactionHistoryRepository;

	@Autowired
	public MutualFundTransactionHistoryService(MutualFundTransactionHistoryRepository transactionHistoryRepository) {
		this.transactionHistoryRepository = transactionHistoryRepository;
	}

	@Transactional
	public void insertTransaction(Long userId, Long mutualFundsId, String type, Double price, Double unit) {
		transactionHistoryRepository.insertTransaction(userId, mutualFundsId, type, price, unit);
	}

	public List<MutualFundTransactionHistoryEntity> getTransactionsByUserId(Long userId) {
		return transactionHistoryRepository.findByUserId(userId);
	}

	public List<MutualFundTransactionHistoryEntity> getTransactionsByType(String type, long userId) {
		return transactionHistoryRepository.findByType(type, userId);
	}
	
	@Transactional
	public String addMoneyToWallet(Long customerId, double amount) {
		transactionHistoryRepository.addMoneyToWallet(amount, customerId);
		return "Amount added successfully";
	}

	@Transactional
	public String withdrawMoneyFromWallet(Long customerId, double amount) {
		transactionHistoryRepository.withdrawMoneyFromWallet(amount, customerId);
		return "Amount withdrawn successfully";
	}
	
	public double getAccountBalance(Long customerId) {
		return transactionHistoryRepository.getAccountBalance(customerId);
	}
	
	@Transactional
	public String updateTransactionHistory(Long customerId, String description, Double walletAmount) {
		transactionHistoryRepository.updateTransactionHistory(customerId, description, walletAmount);
		return "Update successful";
	}
	
	public String getMfName(Long mfId) {
		return transactionHistoryRepository.getMfName(mfId);
	}
	
	
}
