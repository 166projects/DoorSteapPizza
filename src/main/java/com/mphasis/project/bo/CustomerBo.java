package com.mphasis.project.bo;

import java.util.List;

import com.mphasis.project.entities.Customer;

public interface CustomerBo {
	public void signUp(Customer c);
    public Customer login(String cid, String pass) throws Exception;
    public void changePassword(String cid, String opass,String npass);
    public void editCustomer(Customer customer);
    public Customer getById(String cid);
    public List<Customer> getAll();
}

