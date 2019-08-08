package com.mphasis.project.dao;

import com.mphasis.project.entities.CreditCardDetails;

public interface CCDetailsDao {
      public void addCreditCardDetails(CreditCardDetails ccd);
      public void deleteCreditCardDetails(long card_no);
}
