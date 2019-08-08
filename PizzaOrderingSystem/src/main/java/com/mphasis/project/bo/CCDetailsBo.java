package com.mphasis.project.bo;

import com.mphasis.project.entities.CreditCardDetails;

public interface CCDetailsBo {
	 public void insertCreditCardDetails(CreditCardDetails ccd) throws Exception;
     public void removeCreditCardDetails(long card_no);
     
}
