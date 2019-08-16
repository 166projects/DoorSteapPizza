package com.mphasis.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.project.entities.Topping;
@Repository
public class ToppingDaoImpl implements ToppingDao {
@Autowired
SessionFactory sf;
	public void addToppings(Topping toppings) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(toppings);
		tr.commit();
		session.close();
	}

	public List<Topping> getToppings() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		List<Topping> toppings=session.createCriteria(Topping.class).list();
		tr.commit();
		session.close();
		return toppings;
	}

}
