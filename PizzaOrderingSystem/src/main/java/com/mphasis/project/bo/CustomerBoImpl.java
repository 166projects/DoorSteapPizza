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
		if(c.getPassword().matches("[a-zA-Z] {8,}"))
		  customerDao.signUp(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Customer login(String name, String pass) throws Exception {
		return customerDao.login(name, pass);
	           
	}

	public void chngPassword(String oldpass, String newpass) throws Exception {
		if(!oldpass.equals(newpass))
		{
			customerDao.changePassword(oldpass,newpass);
		}
		else {
			throw new Exception("old ans new password should not be same");
		}
		
	}

	public void editCustomer(long contact_number, String address, int cid) {
		customerDao.updateCustomer(contact_number, address, cid);
	}

	public Customer getById(int cid) {
		return customerDao.getById(cid);
	}

	public List<Customer> getAll() {
		return customerDao.getAll();
	}


}
