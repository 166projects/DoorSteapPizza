package com.mphasis.project.dao;

import java.util.List;

import com.mphasis.project.entities.CreditCardDetails;

public interface CreditCardDetailsDao {
	public List<CreditCardDetails>getAllDetails();
      public void addCreditCardDetails(CreditCardDetails ccd);
      public void deleteCreditCardDetails(long card_no);
}
