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
	public String updatePortfolioBuy(Long userId, Long mutualFundsId, Double price, Double unit) {
		if (transactionRepository.findByMutualFundsId(mutualFundsId, userId) == 0) {
			transactionRepository.addMutualFundTransaction(userId, mutualFundsId, price, unit);
			return "Data inserted successfully";
		}
		transactionRepository.updateMutualFundTransaction(unit, userId, mutualFundsId);
		return "Data inserted successfully";
	}
	
	@Transactional
	public String updatePortfolioSell(Long userId, Long mutualFundsId, Double price, Double unit) {

		if (transactionRepository.findByMutualFundsId(mutualFundsId, userId) == 0) {
			transactionRepository.addMutualFundTransaction(userId, mutualFundsId, price, unit);
			return "Data inserted successfully";
		}
		else {
			if (check(mutualFundsId, userId) + unit < 0 || check(mutualFundsId, userId) == 0) {
				return "Not enough units";
			}
			transactionRepository.updateMutualFundTransaction(unit, userId, mutualFundsId);
			return "Data inserted successfully";
		}
		
	}
	
	public Long getUserId(String username) {
		return transactionRepository.getById(username);
	}
	
	public Double check(Long mutualFundsId, Long userId) {
		return transactionRepository.check(mutualFundsId, userId);
	}
}
