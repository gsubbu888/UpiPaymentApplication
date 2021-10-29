package com.upi.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upi.payment.dto.UserRequestDto;
import com.upi.payment.dto.UserResponseDto;
import com.upi.payment.service.UPIUserInfoService;

@RestController
@RequestMapping("/userDetails")
public class UPIUserInfoController {

	@Autowired(required = true)
	UPIUserInfoService upiUserService;

	@PostMapping
	public String addUser(@Valid @RequestBody UserRequestDto user) {

		String userResponse = upiUserService.addUser(user);

		if (userResponse.equalsIgnoreCase("NotAvailable")) {
			return "Invalid, Please link your bank account with mobilenumber";
		} else if (userResponse.equalsIgnoreCase("Exists")) {
			return "Already Existing Customer";
		} else {
			return "Your are Successfully added your Account " + userResponse + " with Payment System";
		}

	}

}
