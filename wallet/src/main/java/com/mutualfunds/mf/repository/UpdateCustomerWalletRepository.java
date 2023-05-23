package com.mutualfunds.mf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mutualfunds.mf.entity.CustomerWalletEntity;

@Repository
public interface UpdateCustomerWalletRepository extends JpaRepository<CustomerWalletEntity, Long> {
	@Modifying
	@Query(value = "UPDATE customer_wallet SET WALLET_BALANCE=(WALLET_BALANCE + ?) WHERE CUSTOMER_ID=?", nativeQuery = true)
	public void addMoneyToWallet(double amount, long custId);

	@Modifying
	@Query(value = "UPDATE customer_wallet SET WALLET_BALANCE=(WALLET_BALANCE - ?) WHERE CUSTOMER_ID=?", nativeQuery = true)
	public void withdrawMoneyFromWallet(double amount, long custId);

	@Query(value = "SELECT WALLET_BALANCE FROM customer_wallet WHERE CUSTOMER_ID=?", nativeQuery = true)
	public double getAccountBalance(long customerId);
}
