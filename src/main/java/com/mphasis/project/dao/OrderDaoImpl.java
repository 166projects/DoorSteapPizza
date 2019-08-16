package com.mphasis.project.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.project.entities.Orders;
@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	SessionFactory sessionFactory;
	public List<Orders> getAllOrders() {
		Session session=sessionFactory.openSession();
		
		List<Orders> orders=session.createCriteria(Orders.class).list();
		return orders;
	}
	
	public Orders getOrdersById(int oid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Orders od=(Orders) session.get(Orders.class, oid);

		tr.commit();
		return od;
	}

	public void insertOrders(Orders orders) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(orders);
		tr.commit();
	}
	
	public double getTotalCost(int oid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		NativeQuery query=session.createSQLQuery("select cost from orderitems where oid_oid=:oid_oid");
		query.setParameter("oid_oid", oid);
		List<Double> list=query.getResultList();
		double totalPrice=0;
		for(Double d:list) {
			totalPrice+=d;
		}
		
		return totalPrice;
	}

	/*public void updateOrders(Orders orders) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(orders);
		tr.commit();
	}*/

	/*public void deleteOrders(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Orders od1=(Orders) session.get(Orders.class, id);
		session.delete(od1);
		tr.commit();
	}*/

	//public double getTotalCost(int oid) {
		
	
	//}

	public void updateStatusById(int oid, String status){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Orders od=(Orders) session.get(Orders.class, oid);
		od.setStatus(status);
		session.update(od);
		tr.commit();
		
	}
		
	
	
	

}
