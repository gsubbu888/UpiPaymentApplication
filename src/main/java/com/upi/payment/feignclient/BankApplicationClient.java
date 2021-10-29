package com.upi.payment.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.upi.payment.dto.CustomerResponseDto;

@FeignClient(value="bank-client", url="http://localhost:8083/bank/customerDetails")
public interface BankApplicationClient {
	
	@GetMapping("/{phoneNo}")
	public CustomerResponseDto getCustomerbyPhoneNo(@PathVariable String phoneNo);

}
