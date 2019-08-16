package com.mphasis.project.dao;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.project.entities.Admin;
@Repository
public class AdminDaoImpl implements AdminDao {
@Autowired
SessionFactory sf;
	public Admin signUp(Admin admin) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		try {
		session.save(admin);
		tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return admin;
	}

	public Admin login(String aid, String pass) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from Admin where aid=:aid and password=:password");
		query.setString("aid", aid);
		query.setString("password", pass);
		Admin admin=(Admin) query.uniqueResult();
		tr.commit();
		session.close();
		return admin;
	}

	public void updateAdmin(String aid,long contactno) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Admin admin=(Admin) session.get(Admin.class, aid);										
		admin.setContactno(contactno);
		session.update(admin);
		tr.commit();
		session.close();
		
		
	}

	public void changePassword(String aid, String pass) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Admin admin=(Admin) session.get(Admin.class, aid);
		admin.setPassword(pass);
		session.update(admin);
		tr.commit();
		session.close();
	}

	public void deleteAdmin(String aid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Admin admin=(Admin) session.get(Admin.class, aid);
		admin.setAid(aid);
		session.delete(admin);
		tr.commit();
		session.close();
		
	}

}
