package com.mutualfunds.mf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mutualfunds.mf.entity.CustomerWalletHistory;

@Repository
public interface CustomerWalletHistoryRepository extends JpaRepository<CustomerWalletHistory, Integer> {
	
	@Query(value = "SELECT * FROM customer_wallet_history WHERE CUSTOMER_ID=?", nativeQuery = true)
	public List<CustomerWalletHistory> getHistories(int customerId);
	
	@Modifying
	@Query(value = "INSERT INTO customer_wallet_history (CUSTOMER_ID, TRANSACTION_DATE, TRANSACTION_TYPE_ID, WALLET_AMOUNT, WALLET_ID) VALUES(?, CURRENT_TIMESTAMP, ?, ?, ?)", nativeQuery = true)
	public void updateTransactionHistory(int customerId, int transactionTypeId, double walletAmount, int walletId);
	
}
