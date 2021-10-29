package com.upi.payment.service;


import java.util.List;

import com.upi.payment.dto.UPITransactionReqDto;
import com.upi.payment.entity.UPITransactions;

public interface UPITransactionsService {

	public String addUpiTransactionDetails(UPITransactionReqDto trans);

	//public List<UPITransactionReqDto> getStatementForMonth(String accountNumber, int month, int year);
	List<UPITransactions> getTransactionDetails(String phonoNo);

}
