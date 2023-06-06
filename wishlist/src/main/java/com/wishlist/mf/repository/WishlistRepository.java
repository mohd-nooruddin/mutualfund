package com.wishlist.mf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wishlist.mf.entity.WishlistEntity;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {
	@Modifying
	@Query(value = "INSERT INTO wishlist (customer_id, mutualfund_id) VALUES (?, ?)", nativeQuery = true)
	void insert(Long customerId, Long mutualfundId);

	@Modifying
	@Query(value = "DELETE FROM wishlist WHERE customer_id = ? AND mutualfund_id = ?", nativeQuery = true)
	void remove(Long customerId, Long mutualfundId);

	@Query(value = "SELECT * FROM wishlist WHERE customer_id = ?", nativeQuery = true)
	List<WishlistEntity> findByCostomerId(long costomerId);
	
	@Query(value = "SELECT COUNT(*) FROM wishlist WHERE customer_id = ? AND mutualfund_id = ?", nativeQuery = true)
	int check(Long customerId, Long mutualfundId);
}
