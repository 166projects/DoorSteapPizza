package com.mphasis.project.dao;

import java.util.List;
public interface OrderItemsDao {
	public List<OrderItemsDao> getAllOrderItems();
	public OrderItemsDao getOrderItemsById(int id);
	public void insertOrderItems(OrderItemsDao orderItems);
	public void updateOrderItems(OrderItemsDao ordersItems);
	public void deleteOrderItems(int id);
	public double getTotalPrice(int quantity, int cost);
	public OrderItemsDao getOrderItemsByCid(int cid);
}
