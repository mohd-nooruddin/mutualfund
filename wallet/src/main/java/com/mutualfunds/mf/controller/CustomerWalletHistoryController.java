package com.mutualfunds.mf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mutualfunds.mf.entity.CustomerWalletHistory;
import com.mutualfunds.mf.service.CustomerWalletHistoryService;


@Controller
@RequestMapping("mutualfunds/wallet")
@CrossOrigin
public class CustomerWalletHistoryController {
	@Autowired
	CustomerWalletHistoryService customerWalletHistoryService;
	
//	http://localhost:8090/mutualfunds/details/top?limit=5
	@GetMapping(value = "/history", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CustomerWalletHistory>> getHistory(@RequestParam("customerId") int customerId){
		return ResponseEntity.ok(customerWalletHistoryService.getHistories(customerId));
	}
	
	@PatchMapping(value = "/updateTransactionHistory")
	@ResponseBody
	public ResponseEntity<String> updateTransactionHistory( @RequestParam("customerId") int customerId, @RequestParam("transactionTypeId") int transactionTypeId, @RequestParam("walletAmount") double walletAmount, @RequestParam("walletId") int walletId) {
		return ResponseEntity.ok(customerWalletHistoryService.updateTransactionHistory( customerId, transactionTypeId, walletAmount, walletId));
	}
	
}