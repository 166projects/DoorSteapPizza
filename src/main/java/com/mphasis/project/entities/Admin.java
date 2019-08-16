package com.mphasis.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

import com.mphasis.project.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
		 @GenericGenerator(
			        name = "admin_seq", 
			        strategy = "com.mphasis.project.util.StringPrefixedSequenceIdGenerator", 
			        parameters = {
			            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AD_"),
			            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })
		private String aid;
		@Column(nullable=false)
		private String name;
		@Column(nullable=false)
		private String password;
		@Column(nullable=false,length=10)
		private long contactno;
		
		
		
		public String getAid() {
			return aid;
		}
		public void setAid(String aid) {
			this.aid = aid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public long getContactno() {
			return contactno;
		}
		public void setContactno(long contactno) {
			this.contactno = contactno;
		}
		@Override
		public String toString() {
			return "Admin [aid=" + aid + ", name=" + name + ", password=" + password + ", contactno=" + contactno + "]";
		}
		
}
