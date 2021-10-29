package com.upi.payment.service.impl;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.upi.payment.dto.CustomerResponseDto;
import com.upi.payment.dto.TransactionDetailsDto;
import com.upi.payment.dto.TransactionDetailsResponseDto;
import com.upi.payment.dto.UPITransactionReqDto;
import com.upi.payment.entity.UPITransactions;
import com.upi.payment.feignclient.BankApplicationClient;
import com.upi.payment.feignclient.TransactionClient;
import com.upi.payment.repository.UPITransactionDetailsRepository;
import com.upi.payment.service.UPITransactionsService;

@Service
public class UPITransactionsServiceImpl implements UPITransactionsService {

	@Autowired
	UPITransactionDetailsRepository upiTransactionDetailsRepository;

	@Autowired
	BankApplicationClient bankApplicationClient;

	@Autowired
	TransactionClient transClient;

	@Override
	public String addUpiTransactionDetails(UPITransactionReqDto transDto) {

		UPITransactions transaction = new UPITransactions();

		CustomerResponseDto sourceCustomerInfo = new CustomerResponseDto();
		CustomerResponseDto targetCustomerInfo = new CustomerResponseDto();
		TransactionDetailsDto transactionDetailsDto = new TransactionDetailsDto();
		TransactionDetailsResponseDto transactionDetailsResponseDto = new TransactionDetailsResponseDto();
		
		sourceCustomerInfo = bankApplicationClient.getCustomerbyPhoneNo(transDto.getFromPhoneNo());
		targetCustomerInfo = bankApplicationClient.getCustomerbyPhoneNo(transDto.getToPhoneNo());

		if (!sourceCustomerInfo.equals(null) && !targetCustomerInfo.equals(null)) {

			ZoneId defaultZoneId = ZoneId.systemDefault();

			transactionDetailsDto.setSourceAccountNumber(sourceCustomerInfo.getAccountNumber());
			transactionDetailsDto.setTargetAccountNumber(targetCustomerInfo.getAccountNumber());
			transactionDetailsDto.setTransactionAmount(transDto.getUpiTransactionAmount());
			transactionDetailsDto.setTransactionDate(
					Date.from(transDto.getUpiTransactionDate().atStartOfDay(defaultZoneId).toInstant()));
			transactionDetailsDto.setTransactionType(transDto.getUpiTransactionType());
			transactionDetailsDto.setTransDescription(transDto.getUpiTransDescription());
			transactionDetailsDto.setDebitOrCredit(transDto.getDebitOrCredit());

			transactionDetailsResponseDto = transClient.addTransactionDetails(transactionDetailsDto);
			//System.out.println(transDto.getFromPhoneNo());
			transaction.setFromPhoneNo(transDto.getFromPhoneNo());
			transaction.setAvailableBalance(transactionDetailsResponseDto.getAvailableBalance());
			transaction.setDebitOrCredit(transDto.getDebitOrCredit());
			transaction.setLedgerBalance(transactionDetailsResponseDto.getLedgerBalance());
			transaction.setToPhoneNo(transDto.getToPhoneNo());
			transaction.setUpiTransactionAmount(transactionDetailsResponseDto.getTransactionAmount());
			transaction.setUpiTransactionDate(transDto.getUpiTransactionDate());
			transaction.setUpiTransactionType(transactionDetailsResponseDto.getTransactionType());
			transaction.setUpiTransDescription(transactionDetailsResponseDto.getTransDescription());

			upiTransactionDetailsRepository.save(transaction);

			return "Transaction Posted Successfully";

		} else {
			return "Invalid Transaction";
		}

	}

	@Override
	public List<UPITransactions> getTransactionDetails(String phoneNo) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(0, 5);
		List<UPITransactions> transDetails = upiTransactionDetailsRepository.findByFromPhoneNo(phoneNo, pageable);
		return transDetails;

	}

}
