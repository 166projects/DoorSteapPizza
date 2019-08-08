package com.mphasis.project.entities;

import java.io.Serializable;

import java.sql.Blob;
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
public class Restaurants implements Serializable {	

	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int rid;

@Column(nullable=false,length=50)
private String rname;

@Column(nullable=false)
private Blob image;

@Column(nullable=false,length=50)
private String menu;

@Column(nullable=false)
private int ratings;

@ManyToMany(mappedBy="restaurants", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
private List<Location> location;

public int getRid() {
	return rid;
}

public String getRname() {
	return rname;
}

public Blob getImage() {
	return image;
}

public String getMenu() {
	return menu;
}

public int getRatings() {
	return ratings;
}

public List<Location> getLocation() {
	return location;
}

public void setRid(int rid) {
	this.rid = rid;
}

public void setRname(String rname) {
	this.rname = rname;
}

public void setImage(Blob image) {
	this.image = image;
}

public void setMenu(String menu) {
	this.menu = menu;
}

public void setRatings(int ratings) {
	this.ratings = ratings;
}

public void setLocation(List<Location> location) {
	this.location = location;
}

/*@OneToMany(mappedBy="restaurants", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
private List<FoodItems> fooditems;*/






}
