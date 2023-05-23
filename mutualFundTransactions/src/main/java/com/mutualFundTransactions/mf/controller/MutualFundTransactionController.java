package com.mutualFundTransactions.mf.controller;

import com.mutualFundTransactions.mf.entity.MutualFundTransactionEntity;
import com.mutualFundTransactions.mf.service.MutualFundTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class MutualFundTransactionController {

	private final MutualFundTransactionService transactionService;

	@Autowired
	public MutualFundTransactionController(MutualFundTransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping("/user/{userId}")
	public List<MutualFundTransactionEntity> getTransactionsByUserId(@PathVariable Long userId) {
		return transactionService.getTransactionsByUserId(userId);
	}

	@PostMapping("/addTransaction")
	public void addMutualFundTransaction(@RequestParam("userId") Long userId,
			@RequestParam("mutualFundsId") Long mutualFundsId, @RequestParam("price") Double price,
			@RequestParam("unit") Integer unit) {
		transactionService.addMutualFundTransaction(userId, mutualFundsId, price, unit);
	}
}
