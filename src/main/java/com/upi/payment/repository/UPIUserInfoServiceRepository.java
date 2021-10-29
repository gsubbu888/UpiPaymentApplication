package com.upi.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upi.payment.entity.UPIUserInfo;

@Repository
public interface UPIUserInfoServiceRepository extends JpaRepository<UPIUserInfo, Long>{

	UPIUserInfo findByPhoneNo(String phoneNo);
	
	//UPIUserInfo findByUniqueid(Long uniqueId);
}
