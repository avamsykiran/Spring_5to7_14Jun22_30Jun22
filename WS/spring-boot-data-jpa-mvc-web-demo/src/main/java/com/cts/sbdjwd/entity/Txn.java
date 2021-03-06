package com.cts.sbdjwd.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="txns")
public class Txn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long txnId;
	@NotBlank(message = "Desp is a mandate field")
	private String desp;
	@NotNull(message="Amount is a mandate field")
	private Double amount;
	@NotNull(message="Txn Date is a mandate field")
	@PastOrPresent(message="Txn Date can not be of future")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate txnDate;
	@NotNull(message="Txn Type can not be null")
	@Enumerated(EnumType.STRING)
	private TxnType type;
	
	@ManyToOne
	private AccountHolder holder;
	
	public Txn() {
		// TODO Auto-generated constructor stub
	}

	public Txn(Long txnId, @NotBlank(message = "Desp is a mandate field") String desp,
			@NotNull(message = "Amount is a mandate field") Double amount,
			@NotNull(message = "Txn Date is a mandate field") @PastOrPresent(message = "Txn Date can not be of future") LocalDate txnDate,
			@NotNull(message = "Txn Type can not be null") TxnType type, AccountHolder holder) {
		super();
		this.txnId = txnId;
		this.desp = desp;
		this.amount = amount;
		this.txnDate = txnDate;
		this.type = type;
		this.holder = holder;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	public AccountHolder getHolder() {
		return holder;
	}

	public void setHolder(AccountHolder holder) {
		this.holder = holder;
	}
	
	
}
