package com.mphasis.project.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;
	private String tname;
	/*@ManyToMany(fetch=FetchType.LAZY, mappedBy="toppings")
	@JsonIgnore
	private List<FoodItems> foodItems;
	public List<FoodItems> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(List<FoodItems> foodItems) {
		this.foodItems = foodItems;
	}*/
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	/*public List<FoodItems> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(List<FoodItems> foodItems) {
		this.foodItems = foodItems;
	}
	@Override
	public String toString() {
		return "Topping [tid=" + tid + ", tname=" + tname + ", foodItems=" + foodItems + "]";
	}*/
	

}
