package com.mphasis.project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int oid;
	private String paymentDetails;
	private double totalCost;
	private String status;
	@OneToMany (mappedBy="oid", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<OrderItems> serialno;
	@ManyToOne(fetch=FetchType.EAGER)
	private DeliveryBoy deliveryboy;
	@ManyToOne(fetch=FetchType.EAGER)
	private Customer customers;
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
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public DeliveryBoy getDeliveryboy() {
		return deliveryboy;
	}
	public void setDeliveryboy(DeliveryBoy deliveryboy) {
		this.deliveryboy = deliveryboy;
	}
	public Customer getCustomers() {
		return customers;
	}
	public void setCustomers(Customer customers ) {
		this.customers = customers;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderItems> getSerialno() {
		return serialno;
	}
	public void setSerialno(List<OrderItems> serialno) {
		this.serialno = serialno;
	}
	
	
	

}
