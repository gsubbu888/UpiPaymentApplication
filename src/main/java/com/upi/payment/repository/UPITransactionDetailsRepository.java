package com.upi.payment.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upi.payment.entity.UPITransactions;

@Repository
public interface UPITransactionDetailsRepository extends JpaRepository<UPITransactions, Long>{
	
	List<UPITransactions> findByFromPhoneNo(String fromPhoneNo, Pageable pageable);

}
