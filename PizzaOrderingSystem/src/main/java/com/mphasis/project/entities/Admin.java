package com.mphasis.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String name;
		private String password;
		private long contactno;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
			return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", contactno=" + contactno + "]";
		}
		
}
