






package com.mvc.fraudmanagement.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CLAIM")
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="CardNo", nullable = false, unique = true)
	// @Min(value=16, message="must be equal to 16")
	// @Max(value=16, message="must be equal to 16")
	private long cardNo;

	@Column(name="UserId", nullable=false)
	private String userId;
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="TransactionId",unique=true)
	private String transId;

	@Column(name="CardHolderName",nullable=false)
	@Size(min=4, message = "Enter Card Holder Name")
	private String cardHolderName;

	@Column(name="AccNo",nullable=false, unique=true)
	// @Min(value=10, message="must be equal to 10")
	// @Max(value=10, message="must be equal to 10")
	private long accNo;


	@Column(name = "ExpiryDate",nullable=false)
	private Date expiryDate;

	@Column(name = "CardType", nullable = false)
	@Size(min = 1, message = "Enter Card Type")
	private String cardType;

	@Column(name = "TransDate", nullable=false)
	@PastOrPresent(message = "Enter the Transaction Date")
	private Date transDate;

	@Column(name = "TransDetails", nullable = false)
	@Size(min = 1, message = "Enter the Transaction Details")
	private String transDetails;

	@Column(name = "Remarks", nullable = false)
	@Size(min = 1, message = "Enter claim Remarks")
	private String remarks;

	@Column(name = "FraudLevel", nullable = false)
	@Size(min = 1, message = "Choose the Fraud Level")
	private String fraudLevel;

	@Column(name = "ValidId", nullable = false)
	private int validId;

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getTransDetails() {
		return transDetails;
	}

	public void setTransDetails(String transDetails) {
		this.transDetails = transDetails;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFraudLevel() {
		return fraudLevel;
	}

	public void setFraudLevel(String fraudLevel) {
		this.fraudLevel = fraudLevel;
	}

	public int getValidId() {
		return validId;
	}

	public void setValidId(int validId) {
		this.validId = validId;
	}

	@Override
	public String toString() {
		return "Claim [id=" + id + ", cardNo=" + cardNo + ", userId=" + userId + ", cardHolderName=" + cardHolderName
				+ ", accNo=" + accNo + ", expiryDate=" + expiryDate + ", cardType=" + cardType + ", transDate="
				+ transDate + ", transDetails=" + transDetails + ", remarks=" + remarks + ", fraudLevel=" + fraudLevel
				+ ", validId=" + validId + "]";
	}

}
