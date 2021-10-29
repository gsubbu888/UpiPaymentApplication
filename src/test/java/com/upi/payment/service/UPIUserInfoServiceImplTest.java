package com.upi.payment.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.upi.payment.dto.UserRequestDto;
import com.upi.payment.entity.UPIUserInfo;
import com.upi.payment.feignclient.BankApplicationClient;
import com.upi.payment.repository.UPIUserInfoServiceRepository;
import com.upi.payment.service.impl.UPIUserInfoServiceImpl;



@ExtendWith(SpringExtension.class)
class UPIUserInfoServiceImplTest {

	@InjectMocks
	UPIUserInfoServiceImpl userInfoServiceImpl;

	@Mock
	UPIUserInfoServiceRepository userInfoRepository;
	
	@Mock
	BankApplicationClient bankApplicationClient;

	@Test
	void testbyPhoneNo() {
		UPIUserInfo user = new UPIUserInfo();
		user.setUniqueId(1L);
		user.setFirstName("Subramanyam");
		user.setLastName("Guntupalli");
		user.setMiddleName("");
		user.setAccountNumber("00006972");
		user.setAccountType("Savings");
		user.setEmailId("gsm@gmail.com");
		user.setPhoneNo("9876543210");
		user.setUpiName("gsm@gbl");
		UserRequestDto userdto=new UserRequestDto();
		BeanUtils.copyProperties(user, userdto);
		Mockito.when(userInfoRepository.findByPhoneNo(Mockito.anyString())).thenReturn(user);
		String testUserInfo=null;
		try {
			testUserInfo = userInfoServiceImpl.addUser(userdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(testUserInfo);
		assertEquals("Exists", testUserInfo);
	}
	
	@Test
	void testAddUser() {
		UPIUserInfo user = new UPIUserInfo();
		user.setUniqueId(1L);
		user.setFirstName("Radhika");
		user.setLastName("Raga");
		user.setMiddleName("Rani");
		user.setAccountNumber("00006972");
		user.setAccountType("Savings");
		user.setEmailId("gsm@gmail.com");
		user.setPhoneNo("9876543210");
		user.setUpiName("gsm@gbl");
		UserRequestDto userdto=new UserRequestDto();
		BeanUtils.copyProperties(user, userdto);
		
		////Mockito.when(bankApplicationClient.getCustomerbyPhoneNo("9876543210")).Mockito.anyString())thenReturn(true);
	       
        //Mockito.when(customerRepository.findByPhoneNumber("7397368451")).thenReturn(null);
		
		Mockito.when(userInfoRepository.findByPhoneNo(Mockito.anyString())).thenReturn(user);
		String testUserInfo=null;
		try {
			testUserInfo = userInfoServiceImpl.addUser(userdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(testUserInfo);
		assertEquals("Exists", testUserInfo);
	}
}
