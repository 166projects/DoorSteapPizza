package com.mphasis.project.dao;

import java.util.List;

import com.mphasis.project.entities.Orders;

public interface OrderDao {
	public List<Orders> getAllOrders();
	public Orders getOrdersById(int oid);
	public void insertOrders(Orders orders);
	//public void updateOrders(Orders orders);
	//public void deleteOrders(int id);
	//public double getTotalCost();
	public double getTotalCost(int oid) ;
	public void updateStatusById(int oid,String status);
}
