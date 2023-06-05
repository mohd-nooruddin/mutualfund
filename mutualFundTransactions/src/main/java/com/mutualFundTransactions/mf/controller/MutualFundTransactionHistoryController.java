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
	public MutualFundTransactionHistoryController(MutualFundTransactionHistoryService transactionHistoryService,
			MutualFundTransactionService transactionService) {
		this.transactionHistoryService = transactionHistoryService;
		this.transactionService = transactionService;
	}

	@PostMapping("/insert")
	public String insertTransaction(@RequestParam("username") String username,
			@RequestParam("mutualFundsId") Long mutualFundsId, @RequestParam("type") String type,
			@RequestParam("price") Double price, @RequestParam("unit") Double unit) {
		long id = transactionService.getUserId(username);
		System.out.println(id);
		if (transactionHistoryService.getAccountBalance(id) < price && type.equals("buy")) {
			return "Insufficient balance";
		} else {
			if (type.equals("sell")) {
				if (transactionService.updateportfolio(id, mutualFundsId, price, -(unit))
						.equals("Data inserted successfully")) {
					transactionHistoryService.insertTransaction(id, mutualFundsId, type, price, unit);
					transactionHistoryService.addMoneyToWallet(id, price);
					String str = "Sold " + unit + " units of " + transactionHistoryService.getMfName(mutualFundsId);
					transactionHistoryService.updateTransactionHistory(id, str, (price * unit));
					return "Data inserted successfully";
				} else {
					return "Not enough units";
				}
			}
			transactionHistoryService.insertTransaction(id, mutualFundsId, type, price, unit);
			transactionHistoryService.withdrawMoneyFromWallet(id, price);
			String str = "Buy " + unit + " units of " + transactionHistoryService.getMfName(mutualFundsId);
			transactionHistoryService.updateTransactionHistory(id, str, (price * unit));
			return transactionService.updateportfolio(id, mutualFundsId, price, unit);
		}
	}

	@GetMapping("/user/{userId}")
	public List<MutualFundTransactionHistoryEntity> getTransactionsByUserId(@PathVariable Long userId) {
		return transactionHistoryService.getTransactionsByUserId(userId);
	}

	@GetMapping("/userid/{username}")
	public Long getTransactionsByUser(@PathVariable String username) {
		return transactionService.getUserId(username);
	}

	@GetMapping("/type/{type}")
	public List<MutualFundTransactionHistoryEntity> getTransactionsByType(@PathVariable String type,
			@RequestParam("userId") long userId) {
		return transactionHistoryService.getTransactionsByType(type, userId);
	}
}
