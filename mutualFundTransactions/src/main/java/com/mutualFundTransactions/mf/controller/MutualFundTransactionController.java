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

}
