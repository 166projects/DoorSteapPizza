package com.mphasis.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.project.util.StringPrefixedSequenceIdGenerator;
@Entity
@Table(name="Customer")
public class Customer implements Serializable{
 
	private static final long serialVersionUID = 1L;
	@Id
    /* @GeneratedValue(strategy=GenerationType.AUTO)*/
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
	 @GenericGenerator(
		        name = "cust_seq", 
		        strategy = "com.mphasis.project.entities.StringPrefixedSequenceIdGenerator", 
		        parameters = {
		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "US_"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })    
	private int cid;
     @Column(nullable=false)
  private String cname;
     @Column(nullable=false)
  private String password;
     @Column(nullable=false, length=11)
  private long contact_number;
     @Column(nullable=false)
  private String address;
     @OneToMany(mappedBy="users",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
     private List<CreditCardDetails> ccd;
     @OneToMany(mappedBy="users",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
     private List<Orders> orders;
     
     
     public int getCid() {
            return cid;
     }
     public void setCid(int cid) {
            this.cid = cid;
     }
     public String getCname() {
            return cname;
     }
     public void setCname(String cname) {
            this.cname = cname;
     }
     public String getPassword() {
            return password;
     }
     public void setPassword(String password) {
            this.password = password;
     }
     public long getContact_number() {
            return contact_number;
     }
     public void setContact_number(long contact_number) {
            this.contact_number = contact_number;
     }
     public String getAddress() {
            return address;
     }
     public void setAddress(String address) {
            this.address = address;
     }
     public List<CreditCardDetails> getCcd() {
            return ccd;
     }
     public void setCcd(List<CreditCardDetails> ccd) {
            this.ccd = ccd;
     }
     public List<Orders> getOrders() {
            return orders;
     }
     public void setOrders(List<Orders> orders) {
            this.orders = orders;
     }
     @Override
     public String toString() {
            return "User [cid=" + cid + ", cname=" + cname + ", password=" + password + ", contact_number=" + contact_number
                         + ", address=" + address + ", ccd=" + ccd + "]";
     }
     
}

