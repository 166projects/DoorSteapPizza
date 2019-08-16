package com.mphasis.project.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.project.dao.ToppingDao;
import com.mphasis.project.entities.Topping;
@Service
public class ToppingBoImpl implements ToppingBo {
@Autowired
ToppingDao toppingDao;
	public void addToppings(Topping toppings) {
		toppingDao.addToppings(toppings);
	}

	public List<Topping> getToppings() {
		return toppingDao.getToppings();
	}

}

