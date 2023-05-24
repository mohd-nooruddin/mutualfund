package com.mutualFundTransactions.mf.controller;

import com.mutualFundTransactions.mf.entity.MutualFundTransactionHistoryEntity;
import com.mutualFundTransactions.mf.service.MutualFundTransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactionhistory")
@CrossOrigin
public class MutualFundTransactionHistoryController {

	private final MutualFundTransactionHistoryService transactionHistoryService;

	@Autowired
	public MutualFundTransactionHistoryController(MutualFundTransactionHistoryService transactionHistoryService) {
		this.transactionHistoryService = transactionHistoryService;
	}

	@PostMapping("/insert")
	public void insertTransaction(@RequestParam("userId") Long userId, @RequestParam("mutualFundsId") Long mutualFundsId,
			@RequestParam("type") String type, @RequestParam("price") Double price, @RequestParam("unit") Integer unit, @RequestParam("transactionWallet") Double transactionWallet) {
		transactionHistoryService.insertTransaction(userId, mutualFundsId, type, price, unit,
				transactionWallet);
	}

	@GetMapping("/user/{userId}")
	public List<MutualFundTransactionHistoryEntity> getTransactionsByUserId(@PathVariable Long userId) {
		return transactionHistoryService.getTransactionsByUserId(userId);
	}

	@GetMapping("/type/{type}")
	public List<MutualFundTransactionHistoryEntity> getTransactionsByType(@PathVariable String type) {
		return transactionHistoryService.getTransactionsByType(type);
	}
}
