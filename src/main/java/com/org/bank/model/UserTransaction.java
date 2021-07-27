package com.org.bank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@OneToOne
	@JoinColumn(name = "transaction_TypeId_Id")
	private Transaction_Type transaction_type;
	private Date transaction_date_time;
    private Integer userId;
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public Transaction_Type getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(Transaction_Type transaction_type) {
		this.transaction_type = transaction_type;
	}

	public Date getTransaction_date_time() {
		return transaction_date_time;
	}

	public void setTransaction_date_time(Date transaction_date_time) {
		this.transaction_date_time = transaction_date_time;
	}

	public UserTransaction(Integer id, Transaction_Type transaction_type, Date transaction_date_time, User user) {
		super();
		this.Id = id;
		this.transaction_type = transaction_type;
		this.transaction_date_time = transaction_date_time;

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		userId = userId;
	}

	public UserTransaction(Integer id, Transaction_Type transaction_type, Date transaction_date_time, Integer userId) {
		super();
		Id = id;
		this.transaction_type = transaction_type;
		this.transaction_date_time = transaction_date_time;
		this.userId = userId;
	}

}
