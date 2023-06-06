package com.mutualFundTransactions.mf.controller;

import com.mutualFundTransactions.mf.entity.MutualFundTransactionEntity;
import com.mutualFundTransactions.mf.service.MutualFundTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
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

	@PostMapping("/updateportfolio")
	public String addMutualFundTransaction(@RequestParam("username") String username,
			@RequestParam("mutualFundsId") Long mutualFundsId, @RequestParam("price") Double price,
			@RequestParam("unit") Double unit) {
		Long id = transactionService.getUserId(username);
		transactionService.updateportfolio(id, mutualFundsId, price, unit);
		return "Portfolio Updated Successfully";
	}
}