package com.mphasis.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItems implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int serialNo;
	@Column(nullable=false)
	private double cost;
	@Column(nullable=false)
	private int quantity;
	@ManyToOne(fetch=FetchType.EAGER)
	private FoodItems fooditems;
	@ManyToOne
	private Customer customers;
	@ManyToOne
	private Orders oid;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public FoodItems getFooditems() {
		return fooditems;
	}
	public void setFooditems(FoodItems fooditems) {
		this.fooditems = fooditems;
	}
	public Customer getCustomers() {
		return customers;
	}
	public void setCustomers(Customer customers) {
		this.customers = customers;
	}
	public Orders getOid() {
		return oid;
	}
	public void setOid(Orders oid) {
		this.oid = oid;
	}
	
	

}
