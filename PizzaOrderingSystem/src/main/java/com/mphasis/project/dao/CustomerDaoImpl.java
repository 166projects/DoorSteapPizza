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
			session.save(c);
			tr.commit();
			}catch(Exception e){
				e.printStackTrace();
			};
		
	}

	public Customer login(String name, String pass) throws Exception {
		Customer customers;
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from Customer where cname=:nname and password=:npass");
		query.setString("nname", name);
		query.setString("npass", pass);
		try {
		customers=(Customer) query.uniqueResult();
		tr.commit();
	}catch(Exception e) {
	     throw new Exception("invalid credentials");
	}
		return customers;
	}

	public void changePassword(String oldpass, String newpass) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		try {
		Query query = session.createQuery("from Customer set password=:newpass where password=:oldpass");
		query.setString("password", oldpass);
		query.setString("password", newpass);
		session.update(query);
		tr.commit();
	    }catch(Exception e1) {
		   e1.printStackTrace();
	    }
	}

	public void updateCustomer(long contact_number, String address, int cid) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Customer c=(Customer) session.get(Customer.class, cid);
			c.setContact_number(contact_number);
			c.setAddress(address);
			session.update(c);
			tr.commit();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

	public Customer getById(int cid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class,cid);
		tr.commit();
		return c;
	}


	public List<Customer> getAll() {
		Session session=sessionFactory.openSession();
		List<Customer> customers= session.createCriteria(Customer.class).list();
		return customers;
	}

}
