package com.mphasis.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.project.entities.Orders;
@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	public List<Orders> getAllOrders() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Orders> orders=session.createCriteria(Orders.class).list();
		return orders;
	}

	public Orders getOrdersById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Orders od=(Orders) session.get(Orders.class, id);

		tr.commit();
		return od;
	}

	public void insertOrders(Orders orders) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(orders);
		tr.commit();
	}

	public void updateOrders(Orders orders) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(orders);
		tr.commit();
	}

	public void deleteOrders(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Orders od1=(Orders) session.get(Orders.class, id);
		session.delete(od1);
		tr.commit();
	}

	public double getTotalCost() {
		 return 0;
	}

	

}
