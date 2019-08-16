package com.mphasis.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.project.entities.DeliveryBoy;
import com.mphasis.project.entities.Topping;
@Repository
public class DeliveryBoyDaoImpl implements DeliveryBoyDao {
@Autowired
SessionFactory sf;

public DeliveryBoy signUp(DeliveryBoy db) {
	  Session session=sf.openSession();
	  Transaction tr=session.beginTransaction();
	  try {
			session.save(db);
			tr.commit();
			}catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
			return db;
	}


public DeliveryBoy login(int did, String dpass) {
	Session session=sf.openSession();
	Transaction tr=session.beginTransaction();
	Query query=session.createQuery("from DeliveryBoy where did=:did and dpass=:dpass");//comparing with the value stored in database
	query.setInteger("did", did);//storing value from argument to did 
	query.setString("dpass", dpass);
	DeliveryBoy db=(DeliveryBoy) query.uniqueResult();
	tr.commit();
	session.close();
	return db;
}

public void updateDeliveryBoy(int did, long contactno) {
	Session session=sf.openSession();
	Transaction tr=session.beginTransaction();
	DeliveryBoy db=(DeliveryBoy) session.get(DeliveryBoy.class, did);										
	db.setContactno(contactno);
	session.update(db);
	tr.commit();
	session.close();
	
}

	public void changePassword(int did, String dpass) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		DeliveryBoy db=(DeliveryBoy) session.get(DeliveryBoy.class, did);
		db.setDpass(dpass);
		session.update(db);
		tr.commit();
		session.close();
	}


	public void deleteDeliveryBoy(int did) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		DeliveryBoy db=(DeliveryBoy) session.get(DeliveryBoy.class, did);
		db.setDid(did);
		session.delete(db);
		tr.commit();
		session.close();
	}


	public List<DeliveryBoy> getAll() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		List<DeliveryBoy> deliveryBoy=session.createCriteria(DeliveryBoy.class).list();
		tr.commit();
		session.close();
		return deliveryBoy;
	}

	



}
