package com.mutualFundTransactions.mf.service;

import com.mutualFundTransactions.mf.entity.MutualFundTransactionEntity;
import com.mutualFundTransactions.mf.repository.MutualFundTransactionRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutualFundTransactionService {

	private final MutualFundTransactionRepository transactionRepository;

	@Autowired
	public MutualFundTransactionService(MutualFundTransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<MutualFundTransactionEntity> getTransactionsByUserId(Long userId) {
		return transactionRepository.findByUserId(userId);
	}
	
	@Transactional
	public void addMutualFundTransaction(Long userId, Long mutualFundsId, Double price, Integer unit) {
		transactionRepository.addMutualFundTransaction(userId, mutualFundsId, price, unit);
	}
}
