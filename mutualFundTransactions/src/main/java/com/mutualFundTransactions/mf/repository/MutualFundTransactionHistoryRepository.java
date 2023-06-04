package com.mutualFundTransactions.mf.repository;

import com.mutualFundTransactions.mf.entity.MutualFundTransactionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MutualFundTransactionHistoryRepository
		extends JpaRepository<MutualFundTransactionHistoryEntity, Long> {

	@Modifying
	@Query(value = "INSERT INTO mutualfund_transaction_history (user_id, mutual_funds_id, type, price, unit, transaction_date) "
			+ "VALUES (?1, ?2, ?3, ?4, ?5, CURRENT_TIMESTAMP)", nativeQuery = true)
	void insertTransaction(Long userId, Long mutualFundsId, String type, Double price, Double unit);

	@Query(value = "SELECT * FROM mutualfund_transaction_history WHERE user_id = ?1", nativeQuery = true)
	List<MutualFundTransactionHistoryEntity> findByUserId(Long userId);

	@Query(value = "SELECT * FROM mutualfund_transaction_history WHERE type = ?1 AND user_id = ?2", nativeQuery = true)
	List<MutualFundTransactionHistoryEntity> findByType(String type, long userId);

	@Modifying
	@Query(value = "UPDATE customer_wallet SET WALLET_BALANCE=(WALLET_BALANCE + ?) WHERE CUSTOMER_ID=?", nativeQuery = true)
	public void addMoneyToWallet(Double amount, Long custId);

	@Modifying
	@Query(value = "UPDATE customer_wallet SET WALLET_BALANCE=(WALLET_BALANCE - ?) WHERE CUSTOMER_ID=?", nativeQuery = true)
	public void withdrawMoneyFromWallet(Double amount, Long custId);
	
	@Query(value = "SELECT WALLET_BALANCE FROM customer_wallet WHERE CUSTOMER_ID=?", nativeQuery = true)
	public double getAccountBalance(Long customerId);
}
