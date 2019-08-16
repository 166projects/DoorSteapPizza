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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.project.util.StringPrefixedSequenceIdGenerator;
@Entity

public class Customer implements Serializable{
 
	private static final long serialVersionUID = 1L;
	 @Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
	 @GenericGenerator(
		        name = "cust_seq", 
		        strategy = "com.mphasis.project.util.StringPrefixedSequenceIdGenerator", 
		        parameters = {
		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "US_"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })  
     private String cid;
     @Column(nullable=false)
     private String cname;
     @Column(nullable=false)
     private String password;
     @Column(nullable=false, length=11)
     private long contact_number;
     @Column(nullable=false)
     private String address;
     @OneToMany(mappedBy="customers", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
     @JsonIgnore
     private List<CreditCardDetails> ccd;
     @OneToMany(mappedBy="customers", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
     @JsonIgnore
     private List<Orders> orders;
     
     
     public String getCid() {
            return cid;
     }
     public void setCid(String cid) {
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
}

