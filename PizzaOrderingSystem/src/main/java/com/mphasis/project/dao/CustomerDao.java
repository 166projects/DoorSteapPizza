package com.mphasis.project.dao;

import java.util.List;

import com.mphasis.project.entities.Customer;

public interface CustomerDao {
       public void signUp(Customer c);
       public Customer login(String name, String pass) throws Exception;
       public void changePassword(String oldpass, String newpass);
       public void updateCustomer(long contact_number, String address, int cid);
       public Customer getById(int cid);
       public List<Customer> getAll();
}
