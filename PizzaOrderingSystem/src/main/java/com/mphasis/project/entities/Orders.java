package com.mphasis.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Orders implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int oid;
	private String paymentDetails;
	private int totalCost;
	@ManyToOne
	private DeliveryBoy deliveryboy;
	@ManyToOne
	private User users;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public DeliveryBoy getDeliveryboy() {
		return deliveryboy;
	}
	public void setDeliveryboy(DeliveryBoy deliveryboy) {
		this.deliveryboy = deliveryboy;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", paymentDetails=" + paymentDetails + ", totalCost=" + totalCost
				+ ", deliveryboy=" + deliveryboy + ", users=" + users + "]";
	}
	
	

}
