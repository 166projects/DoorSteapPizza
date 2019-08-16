package com.mphasis.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.project.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	 @Autowired
     SessionFactory sessionFactory;
	 
	public void signUp(Customer c) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			System.out.println(c.getAddress()+"Dao called");
			session.save(c);
			tr.commit();
			session.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}

	@SuppressWarnings("deprecation")
	public Customer login(String cid, String pass) throws Exception {
		Customer customers;
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		@SuppressWarnings({  "rawtypes" })
		Query query=session.createQuery("from Customer where cid=:cid and password=:npass");
		query.setString("cid", cid);
		query.setString("npass", pass);
		try {
		customers=(Customer) query.uniqueResult();
		tr.commit();
	}catch(Exception e) {
	     throw new Exception("invalid credentials");
	}
		return customers;
	}

	public void changePassword(String cid, String pass) {
        Session session=sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Customer c=(Customer) session.get(Customer.class, cid);
        c.setPassword(pass);
        session.update(c);
        tr.commit();
        session.close();
}

	

	public void updateCustomer(Customer customer) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Customer c=(Customer) session.get(Customer.class, customer.getCid());
			c.setContact_number(customer.getContact_number());
			c.setAddress(customer.getAddress());
			session.update(c);
			tr.commit();
			session.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

	public Customer getById(String cid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class,cid);
		tr.commit();
		return c;
	}


	public List<Customer> getAll() {
		Session session=sessionFactory.openSession();
		//Transaction tr=session.beginTransaction();
		List<Customer> customers= session.createCriteria(Customer.class).list();
		//tr.commit();
		return customers;
	}

}
