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

	@Query(value = "SELECT COUNT(*) FROM mutual_fund_transaction WHERE user_id = ?2 AND mutual_funds_id = ?1", nativeQuery = true)
	int findByMutualFundsId(Long mutualFundsId, long userId);

	@Modifying
	@Query(value = "INSERT INTO mutual_fund_transaction (user_id, mutual_funds_id, price, unit) "
			+ "VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
	void addMutualFundTransaction(Long userId, Long mutualFundsId, Double price, Integer unit);

	@Modifying
	@Query(value = "UPDATE mutual_fund_transaction SET unit = unit + ?1 WHERE user_id = ?2 AND mutual_funds_id = ?3", nativeQuery = true)
	void updateMutualFundTransaction(int unit, long userId, long mutualFundId);
}
