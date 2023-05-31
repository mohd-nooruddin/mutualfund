package com.mutualFundTransactions.mf.controller;

import com.mutualFundTransactions.mf.entity.MutualFundTransactionHistoryEntity;
import com.mutualFundTransactions.mf.service.MutualFundTransactionHistoryService;
import com.mutualFundTransactions.mf.service.MutualFundTransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactionhistory")
@CrossOrigin
public class MutualFundTransactionHistoryController {

	private final MutualFundTransactionHistoryService transactionHistoryService;
	private final MutualFundTransactionService transactionService;

	@Autowired
	public MutualFundTransactionHistoryController(MutualFundTransactionHistoryService transactionHistoryService, MutualFundTransactionService transactionService) {
		this.transactionHistoryService = transactionHistoryService;
		this.transactionService = transactionService;
	}

	@PostMapping("/insert")
	public String insertTransaction(@RequestParam("username") String username,
			@RequestParam("mutualFundsId") Long mutualFundsId, @RequestParam("type") String type,
			@RequestParam("price") Double price, @RequestParam("unit") Integer unit) {
		long id = transactionService.getUserId(username);
		System.out.println(id);
		transactionHistoryService.insertTransaction(id, mutualFundsId, type, price, unit);
		transactionService.updateportfolio(transactionService.getUserId(username), mutualFundsId, price, unit);
		
		return "Data inserted Successfully";
	}

	@GetMapping("/user/{userId}")
	public List<MutualFundTransactionHistoryEntity> getTransactionsByUserId(@PathVariable Long userId) {
		return transactionHistoryService.getTransactionsByUserId(userId);
	}
	
	@GetMapping("/userid/{userId}")
	public Long getTransactionsByUser(@PathVariable String userId) {
		return transactionService.getUserId(userId);
	}

	@GetMapping("/type/{type}")
	public List<MutualFundTransactionHistoryEntity> getTransactionsByType(@PathVariable String type, @RequestParam("userId") long userId) {
		return transactionHistoryService.getTransactionsByType(type, userId);
	}
}
