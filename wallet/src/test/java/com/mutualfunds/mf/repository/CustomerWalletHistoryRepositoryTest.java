package com.mutualfunds.mf.repository;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mutualfunds.mf.entity.CustomerWalletHistory;

import jakarta.transaction.Transactional;

@SpringBootTest
public class CustomerWalletHistoryRepositoryTest {

    @Autowired
    private CustomerWalletHistoryRepository repository;

    @Test
    public void testGetHistories() {
        // Arrange
        int customerId = 1;

        // Act
        List<CustomerWalletHistory> histories = repository.getHistories(customerId);

        // Assert
        assertNotNull(histories);
        // Add additional assertions based on the expected behavior of the method
    }
    
    @Transactional
    @Test
    public void testUpdateTransactionHistory() {
        // Arrange
        int customerId = 1;
        int transactionTypeId = 2;
        double walletAmount = 100.0;
        int walletId = 3;

        // Create a new history entry to update
        CustomerWalletHistory history = new CustomerWalletHistory();
        history.setCustomerId(customerId);
        history.setTransactionTypeId(transactionTypeId);
        history.setWalletAmount(walletAmount); // Initial wallet amount
        history.setWalletId(walletId);
        history.setTransactionDate(new Date());
        CustomerWalletHistory savedHistory = repository.save(history);

        // Act
        repository.updateTransactionHistory(customerId, transactionTypeId, walletAmount, walletId);

        // Retrieve the updated entity
        CustomerWalletHistory updatedHistory = repository.findById(savedHistory.getId()).orElse(null);

        // Assert
        assertNotNull(updatedHistory);
        assertEquals(customerId, updatedHistory.getCustomerId());
        assertEquals(transactionTypeId, updatedHistory.getTransactionTypeId());
        assertEquals(walletAmount, updatedHistory.getWalletAmount());
        assertEquals(walletId, updatedHistory.getWalletId());
        assertNotNull(updatedHistory.getTransactionDate());
    }

    @Test
    public void testSave() {
        // Arrange
        CustomerWalletHistory history = new CustomerWalletHistory();
        history.setWalletId(1);
        history.setCustomerId(1);
        history.setWalletAmount(100.00);
        history.setTransactionTypeId(1);
        history.setTransactionDate(new Date());

        // Act
        CustomerWalletHistory savedHistory = repository.save(history);

        // Assert
        assertNotNull(savedHistory);
        assertNotNull(savedHistory.getId());
        // Add additional assertions based on the expected behavior of the save operation
    }

    @Test
    public void testDelete() {
        // Arrange
        int historyId = 1;

        // Act
        repository.deleteById(historyId);

        // Assert
        // Perform assertions to verify the delete operation
        boolean exists = repository.existsById(historyId);
        assertEquals(false, exists);
    }

}
