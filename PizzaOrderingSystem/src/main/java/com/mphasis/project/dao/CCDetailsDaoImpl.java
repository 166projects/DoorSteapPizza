package com.mphasis.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.project.entities.CreditCardDetails;
@Repository
public class CCDetailsDaoImpl implements CCDetailsDao{
	@Autowired
    SessionFactory sessionFactory;
	
	public void addCreditCardDetails(CreditCardDetails ccd) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			session.save(ccd);
			tr.commit();
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}

	public void deleteCreditCardDetails(long card_no) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			CreditCardDetails ccd=(CreditCardDetails) session.get(CreditCardDetails.class, card_no);
			session.delete(ccd);
			tr.commit();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
        
}
}