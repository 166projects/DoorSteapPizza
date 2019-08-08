package com.mphasis.project.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DeliveryBoy implements Serializable{

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int did;
		private String dname;
		private long contactno;
		@OneToMany(mappedBy="deliveryboy",cascade=CascadeType.ALL)
		private List<Orders> orders;
		public int getDid() {
			return did;
		}
		public void setDid(int did) {
			this.did = did;
		}
		public String getDname() {
			return dname;
		}
		public void setDname(String dname) {
			this.dname = dname;
		}
		public long getContactno() {
			return contactno;
		}
		public void setContactno(long contactno) {
			this.contactno = contactno;
		}
		public List<Orders> getOrders() {
			return orders;
		}
		public void setOrders(List<Orders> orders) {
			this.orders = orders;
		}
		@Override
		public String toString() {
			return "DeliveryBoy [did=" + did + ", dname=" + dname + ", contactno=" + contactno + "]";
		}
		
}
