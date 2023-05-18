package com.mutualfunds.mf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutualfunds.mf.entity.CustomerWalletHistory;
import com.mutualfunds.mf.repository.CustomerWalletHistoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerWalletHistoryService {
	@Autowired
	CustomerWalletHistoryRepository customerWalletHistoryRepository;
	
	public List<CustomerWalletHistory> getHistories(int customerId) {
		return customerWalletHistoryRepository.getHistories(customerId);
	}
	
	@Transactional
	public String updateTransactionHistory(int customerId, int transactionTypeId, double walletAmount, int walletId) {
		customerWalletHistoryRepository.updateTransactionHistory(customerId, transactionTypeId, walletAmount, walletId);
		return "Update successful";
	}
}