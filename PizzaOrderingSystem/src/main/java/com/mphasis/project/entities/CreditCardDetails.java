package com.mphasis.project.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
//@Table(name="CreditCard")
public class CreditCardDetails implements Serializable{
       private static final long serialVersionUID = 1L;
       @Id
       @GeneratedValue(strategy=GenerationType.AUTO)
    private long card_no;
       @Column(nullable=false)
    private String card_holder_name;
       @Column(nullable=false, length=3)
    private int cvv;
       @Column(nullable=false)
    private Date expiry_date;
       @ManyToOne
       private User users;
       
       
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
       public Date getExpiry_date() {
              return expiry_date;
       }
       public void setExpiry_date(Date expiry_date) {
              this.expiry_date = expiry_date;
       }
       public User getUsers() {
              return users;
       }
       public void setUsers(User users) {
              this.users = users;
       }
       @Override
       public String toString() {
              return "CreditCardDetails [card_no=" + card_no + ", card_holder_name=" + card_holder_name + ", cvv=" + cvv
                           + ", expiry_date=" + expiry_date + ", users=" + users + "]";
       }
       
       
}

