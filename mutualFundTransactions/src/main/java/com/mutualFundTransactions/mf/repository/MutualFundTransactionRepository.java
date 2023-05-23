package com.mutualFundTransactions.mf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mutualFundTransactions.mf.entity.MutualFundTransactionEntity;

import java.util.List;

@Repository
public interface MutualFundTransactionRepository extends JpaRepository<MutualFundTransactionEntity, Long> {

	@Query(value = "SELECT * FROM mutual_fund_transaction WHERE user_id = ?1", nativeQuery = true)
	List<MutualFundTransactionEntity> findByUserId(Long userId);

	// Add other custom queries as needed
	@Modifying
	@Query(value = "INSERT INTO mutual_fund_transaction (user_id, mutual_funds_id, price, unit, transaction_date) "
			+ "VALUES (?1, ?2, ?3, ?4, CURRENT_TIMESTAMP)", nativeQuery = true)
	void addMutualFundTransaction(Long userId, Long mutualFundsId, Double price, Integer unit);
}
