package com.mutualfunds.mf.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;

import com.mutualfunds.mf.entity.CustomerWalletEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
public class UpdateCustomerWalletRepositoryTest {

    @Autowired
    private UpdateCustomerWalletRepository walletRepository;


 

    @Test
    @Transactional
    public void testAddMoneyToWallet() {
    	 CustomerWalletEntity walletEntity = new CustomerWalletEntity();
         walletEntity.setCustomerId(1);
         walletEntity.setWalletBalance(100.0);
         walletRepository.save(walletEntity);
        // Arrange
        double amount = 50.0;
        int custId = 1;

        // Act
        walletRepository.addMoneyToWallet(amount, custId);

        // Assert
        double updatedBalance = walletRepository.getAccountBalance(custId);
        assertEquals(150.0, updatedBalance);
        walletRepository.deleteAll(List.of(walletEntity));
    }

    @Test
    @Transactional
    public void testWithdrawMoneyFromWallet() {
    	 CustomerWalletEntity walletEntity = new CustomerWalletEntity();
         walletEntity.setCustomerId(1);
         walletEntity.setWalletBalance(100.0);
         walletRepository.save(walletEntity);
        // Arrange
        double amount = 30.0;
        int custId = 1;

        // Act
        walletRepository.withdrawMoneyFromWallet(amount, custId);

        // Assert
        double updatedBalance = walletRepository.getAccountBalance(custId);
        assertEquals(70.0, updatedBalance);
        walletRepository.deleteAll(List.of(walletEntity));
    }

    @Test
    public void testGetAccountBalance() {
    	 CustomerWalletEntity walletEntity = new CustomerWalletEntity();
         walletEntity.setCustomerId(1);
         walletEntity.setWalletBalance(100.0);
         walletRepository.save(walletEntity);
        // Arrange
        int custId = 1;

        // Act
        double balance = walletRepository.getAccountBalance(custId);

        // Assert
        assertEquals(100.0, balance);
        walletRepository.deleteAll(List.of(walletEntity));
    }
}
