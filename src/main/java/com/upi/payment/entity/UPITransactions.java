package com.upi.payment.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UPITransactions implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long upiTransactionId;
	
	private String fromPhoneNo;
	private String toPhoneNo;
    private LocalDate upiTransactionDate;
    private Long upiTransactionAmount; 
    private String upiTransDescription;
    private String upiTransactionType;
    private Long availableBalance;
    private Long ledgerBalance;
    private int debitOrCredit;
	public Long getUpiTransactionId() {
		return upiTransactionId;
	}
	public void setUpiTransactionId(Long upiTransactionId) {
		this.upiTransactionId = upiTransactionId;
	}
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
	public Long getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Long availableBalance) {
		this.availableBalance = availableBalance;
	}
	public Long getLedgerBalance() {
		return ledgerBalance;
	}
	public void setLedgerBalance(Long ledgerBalance) {
		this.ledgerBalance = ledgerBalance;
	}
	public int getDebitOrCredit() {
		return debitOrCredit;
	}
	public void setDebitOrCredit(int debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}
    
    

	
}
