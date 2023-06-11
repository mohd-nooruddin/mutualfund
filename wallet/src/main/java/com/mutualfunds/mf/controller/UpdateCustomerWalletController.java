package com.mutualfunds.mf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mutualfunds.mf.service.CustomerWalletHistoryService;
import com.mutualfunds.mf.service.UpdateCustomerWalletService;

@Controller
@RequestMapping("mutualfunds/wallet/update")
@CrossOrigin
public class UpdateCustomerWalletController {
	@Autowired
	UpdateCustomerWalletService updateCustomerWalletService;
	@Autowired
	CustomerWalletHistoryService customerWalletHistoryService;

	@PatchMapping(value = "/addMoney")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<String> addMoneyToWallet(@RequestParam("customerId") Long customerId,
			@RequestParam("amount") Double amount) {
		customerWalletHistoryService.updateTransactionHistory(customerId, "Deposit", amount);
		return ResponseEntity.ok(updateCustomerWalletService.addMoneyToWallet(customerId, amount));
	}

	@PatchMapping(value = "/withdrawMoney")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<String> withdrawMoneyFromWallet(
			@RequestParam("customerId") Long customerId, @RequestParam("amount") double amount) {
		if (updateCustomerWalletService.getAccountBalance(customerId) >= amount) {
			customerWalletHistoryService.updateTransactionHistory(customerId, "Withdraw", amount);
			return ResponseEntity.ok(updateCustomerWalletService.withdrawMoneyFromWallet(customerId, amount));
		}
		else {
			return ResponseEntity.ok("Insufficient balance");
		}
		
	}
	
	@GetMapping(value = "/getAccountBalance")
	@CrossOrigin
	public ResponseEntity<Double> getHistory(@RequestParam("customerId") Long customerId){
		return ResponseEntity.ok(updateCustomerWalletService.getAccountBalance(customerId));
	}
}
