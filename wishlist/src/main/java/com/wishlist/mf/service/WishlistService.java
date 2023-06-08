package com.wishlist.mf.service;

import com.wishlist.mf.entity.MutualFunds;
import com.wishlist.mf.entity.WishlistEntity;
import com.wishlist.mf.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WishlistService {
	private final WishlistRepository wishlistRepository;

	@Autowired
	public WishlistService(WishlistRepository wishlistRepository) {
		this.wishlistRepository = wishlistRepository;
	}

	public void insertWishlistItem(Long customerId, Long mutualfundId, String fundHouse, String schemaName,
			Double currentPrice, Double delta) {
		wishlistRepository.insert(customerId, mutualfundId, fundHouse, schemaName, currentPrice, delta);
	}

	public void removeWishlistItem(Long customerId, Long mutualfundId) {
		wishlistRepository.remove(customerId, mutualfundId);
	}

	public List<WishlistEntity> findWishlistItemsByCustomerId(Long customerId) {
		return wishlistRepository.findByCostomerId(customerId);
	}
	
	public int check(Long customerId, Long mutualfundId) {
		return wishlistRepository.check(customerId, mutualfundId);
	}
	
	public MutualFunds findId(Long id) {
		return wishlistRepository.findId(id);
	}
}
