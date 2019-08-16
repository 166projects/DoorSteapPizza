package com.mphasis.project.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mphasis.project.entities.FoodItems;
import com.mphasis.project.entities.Restaurants;
@Repository
public class FoodItemsDaoImpl implements FoodItemsDao {
@Autowired
SessionFactory sf;
	public void addFoodItems(FoodItems fooditems) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		try {
			session.save(fooditems);
		}catch (Exception e) {
		e.printStackTrace();
		}
		tr.commit();
		session.close();
	}

	public void updateFoodItems(FoodItems fooditems) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.update(fooditems);
		tr.commit();
		session.close();
	}

	public void deleteFoodItems(int fid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		FoodItems fd=(FoodItems) session.get(FoodItems.class, fid);
		fd.setFid(fid);
		session.delete(fd);
		tr.commit();
		session.close();
		
	}

	public List<FoodItems> getFoodItems() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		List<FoodItems> fooditems=session.createCriteria(FoodItems.class).list();
		tr.commit();
		//session.close();
		return fooditems;
	}

	public FoodItems getFoodItemsById(int fid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		FoodItems fd=(FoodItems) session.get(FoodItems.class, fid);
		tr.commit();
		//session.close();
		return fd;
	}

	public List<FoodItems> getFoodItemsByName(String fname) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(FoodItems.class);
		cr.add(Restrictions.eq("fname", fname));
		List<FoodItems> fd=cr.list();
		tr.commit();
		//session.close();
		return fd;
	}

	 
	 
	public int getFoodItemsCostById(int fid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(FoodItems.class);
		cr.add(Restrictions.eq("fid", fid));
		FoodItems foodItem=(FoodItems) cr.uniqueResult();
		System.out.println(foodItem.getCategory());
//		TypedQuery query = session.createSQLQuery("select * from FoodItems where fid=:fid");
//		query.setParameter("fid", fid);
		//System.out.println(query);
		//FoodItems foodItem= (FoodItems) query.getSingleResult();
		return  foodItem.getCost();
	}

	public List<FoodItems> getFoodItemsByCategory(String category) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(FoodItems.class);
		cr.add(Restrictions.eq("category", category));
		List<FoodItems> fd= cr.list();
		tr.commit();
		//session.close();
		return fd;
	}

	public List<FoodItems> getFoodItemsByType(String type) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(FoodItems.class);
		cr.add(Restrictions.eq("type", type));
		List<FoodItems> fd=cr.list();
		tr.commit();
		//session.close();
		return fd;
	}

	public List<FoodItems> getFoodItemsByRid(int rid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction(); 
		List<FoodItems> fd=session.createCriteria(FoodItems.class, String.valueOf(rid)).list();
		tr.commit();
		
		return fd;
	}
   
}
