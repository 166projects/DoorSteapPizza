package com.mphasis.project.dao;

import java.util.List;

import com.mphasis.project.entities.OrderItems;
public interface OrderItemsDao {
	public List<OrderItems> getAllOrderItems();
	//public OrderItems getOrderItemsById(int id);
	public void insertOrderItems(OrderItems orderItems);
	public void updateOrderItems(OrderItems OrderItemsItems);
	//public void deleteOrderItems(int id);
	//public double getTotalPrice(int quantity, int cost);
	public List<OrderItems> getOrderItemsByCid(String cid);
	//public void updateOrderId(int oid);
	public int getQuantity(int fid);
}
