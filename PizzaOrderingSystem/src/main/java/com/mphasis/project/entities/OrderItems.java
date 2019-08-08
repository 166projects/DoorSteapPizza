package com.mphasis.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
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
	private int cost;
	private int quantity;
	@ManyToOne
	private FoodItems fooditems;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
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
	@Override
	public String toString() {
		return "OrderItems [serialNo=" + serialNo + ", cost=" + cost + ", quantity=" + quantity + ", fooditems="
				+ fooditems + "]";
	}
	
	

}
