package com.mphasis.project.bo;

import java.util.List;
import com.mphasis.project.entities.OrderItems;


public interface OrderItemsBo {
	public List<OrderItems> getAllOrderItems();
	//public OrderItems getOrderItemsById(int id);
	public void insertOrderItems(OrderItems orderItems);
	public void updateOrderItems(OrderItems OrderItemsItems);
	//public void deleteOrderItems(int id);
	public double getTotalPrice(int fid);
	public List<OrderItems> getOrderItemsByCid(String cid);

}

