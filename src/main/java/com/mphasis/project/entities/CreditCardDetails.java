package com.mphasis.project.entities;
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CreditCardDetails implements Serializable{
       private static final long serialVersionUID = 1L;
       @Id
       
        private long card_no;
       @Column(nullable=false)
        private String card_holder_name;
       @Column(nullable=false, length=3)
        private int cvv;
       @Column(nullable=false)
        private String expiry_date;
       @ManyToOne(fetch=FetchType.EAGER)
       private Customer customers;
       
       
       public long getCard_no() {
              return card_no;
       }
       public void setCard_no(long card_no) {
              this.card_no = card_no;
       }
       public String getCard_holder_name() {
              return card_holder_name;
       }
       public void setCard_holder_name(String card_holder_name) {
              this.card_holder_name = card_holder_name;
       }
       public int getCvv() {
              return cvv;
       }
       public void setCvv(int cvv) {
              this.cvv = cvv;
       }
       public String getExpiry_date() {
              return expiry_date;
       }
       public void setExpiry_date(String expiry_date) {
              this.expiry_date = expiry_date;
       }
       public Customer getCustomers() {
              return customers;
       }
       public void setCustomers(Customer customers) {
              this.customers = customers;
       }
       
       
       
}

