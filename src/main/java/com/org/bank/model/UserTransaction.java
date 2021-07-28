package com.org.bank.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class UserTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@OneToOne
	@JoinColumn(name = "transaction_TypeId_Id")
	@NotNull
	private Transaction_Type transaction_type;
	@NotNull
	private LocalDate transaction_date_time;
	
	private Integer UserId;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Transaction_Type getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(Transaction_Type transaction_type) {
		this.transaction_type = transaction_type;
	}

	public LocalDate getTransaction_date_time() {
		return transaction_date_time;
	}

	public void setTransaction_date_time(LocalDate transaction_date_time) {
		this.transaction_date_time = transaction_date_time;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public UserTransaction( Transaction_Type transaction_type, LocalDate transaction_date_time,
			Integer userId) {
		super();
		
		this.transaction_type = transaction_type;
		this.transaction_date_time = transaction_date_time;
		UserId = userId;
	}

	


}
