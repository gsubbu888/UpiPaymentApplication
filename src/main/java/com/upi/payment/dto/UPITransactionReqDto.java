package com.upi.payment.dto;

import java.time.LocalDate;

public class UPITransactionReqDto {

	private String fromPhoneNo;
	private String toPhoneNo;
	private LocalDate upiTransactionDate;
	private Long upiTransactionAmount;
	private String upiTransDescription;
	private String upiTransactionType;
	private int debitOrCredit;

	public String getFromPhoneNo() {
		return fromPhoneNo;
	}

	public void setFromPhoneNo(String fromPhoneNo) {
		this.fromPhoneNo = fromPhoneNo;
	}

	public String getToPhoneNo() {
		return toPhoneNo;
	}

	public void setToPhoneNo(String toPhoneNo) {
		this.toPhoneNo = toPhoneNo;
	}

	public LocalDate getUpiTransactionDate() {
		return upiTransactionDate;
	}

	public void setUpiTransactionDate(LocalDate upiTransactionDate) {
		this.upiTransactionDate = upiTransactionDate;
	}

	public Long getUpiTransactionAmount() {
		return upiTransactionAmount;
	}

	public void setUpiTransactionAmount(Long upiTransactionAmount) {
		this.upiTransactionAmount = upiTransactionAmount;
	}

	public String getUpiTransDescription() {
		return upiTransDescription;
	}

	public void setUpiTransDescription(String upiTransDescription) {
		this.upiTransDescription = upiTransDescription;
	}

	public String getUpiTransactionType() {
		return upiTransactionType;
	}

	public void setUpiTransactionType(String upiTransactionType) {
		this.upiTransactionType = upiTransactionType;
	}

	public int getDebitOrCredit() {
		return debitOrCredit;
	}

	public void setDebitOrCredit(int debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}

}
