package com.mphasis.project.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.project.dao.CustomerDao;
import com.mphasis.project.entities.Customer;

@Service
public class CustomerBoImpl implements CustomerBo {
	@Autowired
	CustomerDao customerDao;
	
	public void signUp(Customer c) {
		try {
			customerDao.signUp(c);
//		if(c.getPassword().matches("[a-zA-Z] {8,}"))
//			System.out.println("Bo called");
//		  customerDao.signUp(c);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public Customer login(String cid, String pass) throws Exception {
		return customerDao.login(cid, pass);
	           
	}

	public void changePassword(String cid, String opass,String npass) {
	        if(!opass.equals(npass))
	             customerDao.changePassword(cid, npass);
	        else
	               System.out.println("Old and new passwords should not be same");
	}


	public void editCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	public Customer getById(String cid) {
		return customerDao.getById(cid);
	}

	public List<Customer> getAll() {
		return customerDao.getAll();
	}


}
