package com.upi.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upi.payment.dto.CustomerResponseDto;
import com.upi.payment.dto.UserRequestDto;
import com.upi.payment.dto.UserResponseDto;
import com.upi.payment.entity.UPIUserInfo;
import com.upi.payment.feignclient.BankApplicationClient;
import com.upi.payment.repository.UPIUserInfoServiceRepository;
import com.upi.payment.service.UPIUserInfoService;

@Service
public class UPIUserInfoServiceImpl implements UPIUserInfoService{
	
	@Autowired
	UPIUserInfoServiceRepository userRepo;
	
	@Autowired
	BankApplicationClient bankApplicationClient;
	
	@Override
	public String addUser(UserRequestDto userDto) {
		CustomerResponseDto customerResponseDto=new CustomerResponseDto();
		UPIUserInfo user=new UPIUserInfo();
		UPIUserInfo verifieduser=new UPIUserInfo();
		UserResponseDto userRespDto=new UserResponseDto();
		customerResponseDto=bankApplicationClient.getCustomerbyPhoneNo(userDto.getPhoneNo());
		
		verifieduser=userRepo.findByPhoneNo(userDto.getPhoneNo());
		if(verifieduser==null)
		{
		if(!customerResponseDto.equals(null))
		{
		user.setAccountNumber(customerResponseDto.getAccountNumber());
		user.setAccountType(customerResponseDto.getAccountType());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmailId(userDto.getEmailId());
		user.setPhoneNo(userDto.getPhoneNo());
		user.setMiddleName(userDto.getMiddleName());
		user.setUpiName(userDto.getPhoneNo()+"@gbl");
		user.setAccountType(customerResponseDto.getAccountType());
		
		userRepo.save(user);
		
		userRespDto.setAccountNumber(user.getAccountNumber());
		userRespDto.setAccountType(user.getAccountType());
		userRespDto.setFirstName(user.getFirstName());
		userRespDto.setLastName(user.getLastName());
		userRespDto.setMiddleName(user.getMiddleName());
		userRespDto.setEmailId(user.getEmailId());
		userRespDto.setPhoneNo(user.getPhoneNo());
		userRespDto.setUpiName(user.getUpiName());
		userRespDto.setUniqueId(user.getUniqueId());
		userRespDto.setAccountType(user.getAccountType());
		
		return user.getAccountNumber();
		
		}else {
			
			return "NotAvailable";
		}
		
	}else {
		return "Exists";
	}
	}
}
