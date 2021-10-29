package com.upi.payment.feignclient;
import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.upi.payment.dto.TransactionDetailsDto;
import com.upi.payment.dto.TransactionDetailsResponseDto;


@FeignClient(value="trans-client", url="http://localhost:8083/bank/transDetails")
public interface TransactionClient {

	@PostMapping
	public TransactionDetailsResponseDto addTransactionDetails(@Valid @RequestBody TransactionDetailsDto trans);
}
