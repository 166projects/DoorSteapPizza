package com.mphasis.project.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.project.dao.CreditCardDetailsDao;

import com.mphasis.project.entities.CreditCardDetails;

@Service
public class CreditCardDetailsBoImpl implements CreditCardDetailsBo{
    @Autowired
    CreditCardDetailsDao creditCardDetailsDao;
    
	public void insertCreditCardDetails(CreditCardDetails ccd){
		
		 
		
		creditCardDetailsDao.addCreditCardDetails(ccd);
		
	}

	public void removeCreditCardDetails(long card_no) {
		creditCardDetailsDao.deleteCreditCardDetails(card_no);
		
	}

	public List<CreditCardDetails> getAllDetails() {
		
		return creditCardDetailsDao.getAllDetails();
	}

}
