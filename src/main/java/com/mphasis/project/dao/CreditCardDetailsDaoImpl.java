package com.mphasis.project.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.project.entities.CreditCardDetails;
@Repository
public class CreditCardDetailsDaoImpl implements CreditCardDetailsDao{
	@Autowired
    SessionFactory sessionFactory;
	
	public void addCreditCardDetails(CreditCardDetails ccd) {
		
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();System.out.println(ccd.getCvv());
			/*Date date=ccd.getExpiry_date();
			SimpleDateFormat format = new SimpleDateFormat("MM-yyyy");
			String dateBufferString = format.format(date);*/
			//ccd.setExpiry_date(dateBufferString);
			session.save(ccd);
			tr.commit();
			session.close();
			
		
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

	public List<CreditCardDetails> getAllDetails() {
		Session session=sessionFactory.openSession();
		//Transaction tr=session.beginTransaction();
		
		List<CreditCardDetails> details= session.createCriteria(CreditCardDetails.class).list();
		
		//tr.commit();
		return details;
	}
	
}