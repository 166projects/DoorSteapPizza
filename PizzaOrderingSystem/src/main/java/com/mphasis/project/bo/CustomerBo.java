package com.mphasis.project.bo;

import java.util.List;

import com.mphasis.project.entities.Customer;

public interface CustomerBo {
	public void signUp(Customer c);
    public Customer login(String name, String pass) throws Exception;
    public void chngPassword(String oldpass, String newpass) throws Exception;
    public void editCustomer(long contact_number, String address, int cid);
    public Customer getById(int cid);
    public List<Customer> getAll();
}
