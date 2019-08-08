package com.mphasis.project.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.project.dao.CCDetailsDao;
import com.mphasis.project.dao.CCDetailsDaoImpl;
import com.mphasis.project.entities.CreditCardDetails;

@Service
public class CCDetailsBoImpl implements CCDetailsBo{
    @Autowired
    CCDetailsDao cCDetailsDao;
    
	public void insertCreditCardDetails(CreditCardDetails ccd) throws Exception {
		if((ccd.getCvv()==3) && (ccd.getCard_no()==16)) {
			cCDetailsDao.addCreditCardDetails(ccd);
		}else {
			throw new Exception("enter a valid cvv");
		}
		
	}

	public void removeCreditCardDetails(long card_no) {
		cCDetailsDao.deleteCreditCardDetails(card_no);
		
	}

}
