package com.mutualfunds.mf.repository;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Disabled;
import com.mutualfunds.mf.entity.CustomerWalletHistory;

import jakarta.transaction.Transactional;

@SpringBootTest
@Disabled
public class CustomerWalletHistoryRepositoryTest {

    @Autowired
    private CustomerWalletHistoryRepository repository;

    @Test
    public void testGetHistories() {
        // Arrange
        Long customerId = (long) 1;

        // Act
        List<CustomerWalletHistory> histories = repository.getHistories(customerId);

        // Assert
        assertNotNull(histories);
        // Add additional assertions based on the expected behavior of the method
    }
    
    @Transactional
    @Test
    @Disabled
    public void testUpdateTransactionHistory() {
        // Arrange
        Long customerId = (long) 1;
        String transactionTypeId = "sell";
        double walletAmount = 100.0;

        // Create a new history entry to update
        CustomerWalletHistory history = new CustomerWalletHistory();
        history.setCustomerId(customerId);
        history.setDescription(transactionTypeId);
        history.setWalletAmount(walletAmount);
        history.setTransactionDate(new Date());
        CustomerWalletHistory savedHistory = repository.save(history);

        // Act
        repository.updateTransactionHistory(customerId, transactionTypeId, walletAmount);

        // Retrieve the updated entity
        CustomerWalletHistory updatedHistory = (CustomerWalletHistory) repository.getHistories(savedHistory.getId());

        // Assert
        assertNotNull(updatedHistory);
        assertEquals(customerId, updatedHistory.getCustomerId());
        assertEquals(transactionTypeId, updatedHistory.getDescription());
        assertEquals(walletAmount, updatedHistory.getWalletAmount());
        assertNotNull(updatedHistory.getTransactionDate());
    }

    @Test
    public void testSave() {
        // Arrange
        CustomerWalletHistory history = new CustomerWalletHistory();
        history.setCustomerId((long) 1);
        history.setWalletAmount(100.00);
        history.setDescription("sell");
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
