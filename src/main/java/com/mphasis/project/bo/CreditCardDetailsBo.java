package com.mphasis.project.bo;

import java.util.List;

import com.mphasis.project.entities.CreditCardDetails;

public interface CreditCardDetailsBo {
	public List<CreditCardDetails> getAllDetails();
	 public void insertCreditCardDetails(CreditCardDetails ccd);
     public void removeCreditCardDetails(long card_no);
     
}

