package com.mutualfunds.mf.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import com.mutualfunds.mf.entity.CustomerWalletEntity;
import org.junit.jupiter.api.AfterEach;
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

    private CustomerWalletEntity walletEntity;

    @BeforeEach
    public void setUp() {
        // Create a new CustomerWalletEntity with a unique customer ID for each test
        int custId = Math.abs(UUID.randomUUID().hashCode());
        walletEntity = new CustomerWalletEntity();
        walletEntity.setCustomerId(custId);
        walletEntity.setWalletBalance(100.0);
        walletRepository.save(walletEntity);
    }

    @AfterEach
    public void tearDown() {
        walletRepository.deleteAll();
    }

    @Test
    @Transactional
    public void testAddMoneyToWallet() {
        // Arrange
        double amount = 50.0;

        // Act
        walletRepository.addMoneyToWallet(amount, walletEntity.getCustomerId());

        // Assert
        double updatedBalance = walletRepository.getAccountBalance(walletEntity.getCustomerId());
        assertEquals(150.0, updatedBalance);
    }

    @Test
    @Transactional
    public void testWithdrawMoneyFromWallet() {
        // Arrange
        double amount = 30.0;

        // Act
        walletRepository.withdrawMoneyFromWallet(amount, walletEntity.getCustomerId());

        // Assert
        double updatedBalance = walletRepository.getAccountBalance(walletEntity.getCustomerId());
        assertEquals(70.0, updatedBalance);
    }

    @Test
    public void testGetAccountBalance() {
        // Act
        double balance = walletRepository.getAccountBalance(walletEntity.getCustomerId());

        // Assert
        assertEquals(100.0, balance);
    }
}
