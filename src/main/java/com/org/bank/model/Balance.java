package com.org.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Balance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@NotNull
	private Integer userId;
	@NotNull
	private Double avaiableBalance;

	public Integer getId() {
		return Id;
	}
	

	public void setId(Integer id) {
		this.Id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		userId = userId;
	}

	public Double getAvaiableBalance() {
		return avaiableBalance;
	}

	public void setAvaiableBalance(Double avaiableBalance) {
		this.avaiableBalance = avaiableBalance;
	}

	public Balance(Integer id, Integer userId, Double avaiableBalance) {
		super();
		this.Id = id;
		userId = userId;
		this.avaiableBalance = avaiableBalance;
	}

	public Balance(Integer userId, Double avaiableBalance) {
		super();

		userId = userId;
		this.avaiableBalance = avaiableBalance;
	}

}
