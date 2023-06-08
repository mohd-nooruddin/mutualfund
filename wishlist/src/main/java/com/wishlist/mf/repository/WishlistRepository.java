package com.wishlist.mf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wishlist.mf.entity.MutualFunds;
import com.wishlist.mf.entity.WishlistEntity;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {
	@Modifying
	@Query(value = "INSERT INTO wishlist (customer_id, mutualfund_id, fund_house, schema_name, current_price, delta) VALUES (?, ?, ?, ?, ?, ?)", nativeQuery = true)
	void insert(Long customerId, Long mutualfundId, String fundHouse, String schemaName, Double currentPrice,
			Double delta);

	@Modifying
	@Query(value = "DELETE FROM wishlist WHERE customer_id = ? AND mutualfund_id = ?", nativeQuery = true)
	void remove(Long customerId, Long mutualfundId);

	@Query(value = "SELECT * FROM wishlist WHERE customer_id = ?", nativeQuery = true)
	List<WishlistEntity> findByCostomerId(long costomerId);

	@Query(value = "SELECT COUNT(*) FROM wishlist WHERE customer_id = ? AND mutualfund_id = ?", nativeQuery = true)
	int check(Long customerId, Long mutualfundId);

	@Query(value = "SELECT schema_name, current_price, delta, fund_house FROM mutual_funds WHERE  schema_id = ?", nativeQuery = true)
	MutualFunds findId(Long mutualfundId);
}
