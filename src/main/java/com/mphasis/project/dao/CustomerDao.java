package com.mphasis.project.dao;

import java.util.List;

import com.mphasis.project.entities.Customer;

public interface CustomerDao {
       public void signUp(Customer c);
       public Customer login(String cid, String pass) throws Exception;
       public void changePassword(String cid, String pass);
       public void updateCustomer(Customer customer);
       public Customer getById(String cid);
       public List<Customer> getAll();
}
