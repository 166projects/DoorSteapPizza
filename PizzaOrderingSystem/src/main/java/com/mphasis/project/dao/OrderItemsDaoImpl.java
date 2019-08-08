package com.mphasis.project.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemsDaoImpl implements OrderItemsDao{
	@Autowired
	SessionFactory sessionFactory;
	public List<OrderItemsDao> getAllOrderItems() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<OrderItemsDao> orderItems=session.createCriteria(OrderItemsDao.class).list();
		return orderItems;
	}

	public OrderItemsDao getOrderItemsById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		OrderItemsDao od=(OrderItemsDao) session.get(OrderItemsDao.class, id);
		tr.commit();
		return od;
	}

	public void insertOrderItems(OrderItemsDao orderItems) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(orderItems);
		tr.commit();
	}

	public void updateOrderItems(OrderItemsDao ordersItems) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(ordersItems);
		tr.commit();
	}

	public void deleteOrderItems(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		OrderItemsDao od1=(OrderItemsDao) session.get(OrderItemsDao.class, id);
		session.delete(od1);
		tr.commit();
	}

	public double getTotalPrice(int quantity, int cost) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		return quantity*cost;
	}

	public OrderItemsDao getOrderItemsByCid(int cid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
