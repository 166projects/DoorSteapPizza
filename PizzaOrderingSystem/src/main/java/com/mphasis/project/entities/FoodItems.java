package com.mphasis.project.entities;

import java.io.Serializable;
import java.sql.Blob;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FoodItems implements Serializable {

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int fid;
		@Column(nullable=false)
		private String fname;
		@Column(nullable=false)
		private String type;
		@Column(nullable=false)
		private String category;
		@ManyToMany(mappedBy="foodItems")
		private List<Topping> toppings;
		@Column(nullable=false)
		private int cost;
		@Column(nullable=false)
		private Blob image;
		@OneToMany(mappedBy="fooditems",cascade=CascadeType.ALL)
		private List<OrderItems> orderItems;
		@ManyToOne
		private Restaurants restaurants;
		public int getFid() {
			return fid;
		}
		public void setFid(int fid) {
			this.fid = fid;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
	
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		public Blob getImage() {
			return image;
		}
		public void setImage(Blob image) {
			this.image = image;
		}
		public List<Topping> getToppings() {
			return toppings;
		}
		public void setToppings(List<Topping> toppings) {
			this.toppings = toppings;
		}
		@Override
		public String toString() {
			return "FoodItems [fid=" + fid + ", fname=" + fname + ", type=" + type + ", category=" + category
					+ ", toppings=" + toppings + ", cost=" + cost + ", image=" + image + "]";
		}
		
}
