package com.mphasis.project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lid;
	
	@Column(nullable=false,length=50)
	private String lname;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Restaurants> restaurants;

	public int getLid() {
		return lid;
	}

	public String getLname() {
		return lname;
	}

	public List<Restaurants> getRestaurants() {
		return restaurants;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setRestaurants(List<Restaurants> restaurants) {
		this.restaurants = restaurants;
	}
	
	
	
	
	
}
