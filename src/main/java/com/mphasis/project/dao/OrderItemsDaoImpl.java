package com.mphasis.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.project.entities.Customer;
import com.mphasis.project.entities.FoodItems;
import com.mphasis.project.entities.OrderItems;


@Repository
public class OrderItemsDaoImpl implements OrderItemsDao{
	@Autowired
	SessionFactory sessionFactory;
	public List<OrderItems> getAllOrderItems() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<OrderItems> orderItems=session.createCriteria(OrderItems.class).list();
		return orderItems;
	}

/*	public OrderItems getOrderItemsById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		OrderItems od=(OrderItems) session.get(OrderItems.class, id);
		tr.commit();
		return od;
	}*/

	public void insertOrderItems(OrderItems orderItems) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(orderItems);
		tr.commit();
	}

	public void updateOrderItems(OrderItems orderItems) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(orderItems);
		tr.commit();
	}

	/*public void deleteOrderItems(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		OrderItems od1=(OrderItems) session.get(OrderItems.class, id);
		session.delete(od1);
		tr.commit();
	}*/

	public double getTotalPrice(int quantity, int cost) {
		//Session session=sessionFactory.openSession();
		//Transaction tr=session.beginTransaction();
		return quantity*cost;
	}

	public List<OrderItems> getOrderItemsByCid(String cid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<OrderItems> orderItems=session.createCriteria(OrderItems.class).list();
		return orderItems;
	}

	public int getQuantity(int fid) {
		Session session=sessionFactory.openSession();
		FoodItems foodItem=session.get(FoodItems.class, fid);
		Criteria cr= session.createCriteria(OrderItems.class);
		cr.add(Restrictions.eq("fooditems", foodItem));
		OrderItems orderItem=(OrderItems) cr.uniqueResult();
		System.out.println("orderItem "+orderItem.getCost());
		return orderItem.getQuantity();
	}

//	public void updateOrderId(int oid, String cid) {
//		Session session=sessionFactory.openSession();
//		Transaction tr=session.beginTransaction();
//		Customer c=session.get(Customer.class, cid);
//	Criteria cr=	session.createCriteria(OrderItems.class);
//		cr.add(Restrictions.eq("customer", c));
//		
//		
//		
//	}
	

}
