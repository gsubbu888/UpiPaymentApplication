package com.upi.payment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upi.payment.dto.UPITransactionReqDto;
import com.upi.payment.entity.UPITransactions;
import com.upi.payment.service.UPITransactionsService;

@RestController
@RequestMapping("/upiTransDetails")
public class UPITransactionsController {

	@Autowired
	UPITransactionsService upiTransService;

	@PostMapping
	public String addUpiTransactionDetails(@Valid @RequestBody UPITransactionReqDto transactionDto) {
		return upiTransService.addUpiTransactionDetails(transactionDto);

	}

	@GetMapping("/stmt")
	public List<UPITransactions> getTransactionDetails(String phoneNo) {
		return upiTransService.getTransactionDetails(phoneNo);

	}

}
