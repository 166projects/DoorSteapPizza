package com.mphasis.project.bo;

import java.util.List;

import com.mphasis.project.entities.Topping;

public interface ToppingBo {
	public void addToppings(Topping toppings);
	public List<Topping> getToppings();
}

