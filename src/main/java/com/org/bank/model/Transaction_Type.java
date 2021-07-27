package com.org.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction_Type {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String typeOfTransaction;
	@OneToOne(mappedBy="transaction_type")
	private UserTransaction userTransaction;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public Transaction_Type(Integer Id, String typeOfTransaction) {
		super();
		this.Id = Id;
		this.typeOfTransaction = typeOfTransaction;
	}

}
