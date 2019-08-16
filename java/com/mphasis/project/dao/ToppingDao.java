package com.mphasis.project.dao;

import java.util.List;

import com.mphasis.project.entities.Topping;

public interface ToppingDao {
	public void addToppings(Topping toppings);
	public List<Topping> getToppings();
	
}
