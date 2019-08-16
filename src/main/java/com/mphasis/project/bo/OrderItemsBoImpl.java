package com.mphasis.project.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.project.dao.FoodItemsDao;
import com.mphasis.project.dao.OrderItemsDao;
import com.mphasis.project.entities.OrderItems;
import com.mphasis.project.exception.BusinessException;
@Service
public class OrderItemsBoImpl implements OrderItemsBo {
	@Autowired
	OrderItemsDao orderItemsDao;
	
	@Autowired
	FoodItemsDao foodItemsDao;

	public List<OrderItems> getAllOrderItems() {
		List<OrderItems> orders=orderItemsDao.getAllOrderItems();
		if(orders.isEmpty()) {
			throw new BusinessException("No orders found. Add a new order to the cart.");
		}
		return orders;
	}

	
	/*public OrderItems getOrderItemsById(int id) {
		// TODO Auto-generated method stub
		return orderItemsDao.getOrderItemsById(id);
	}*/

	public void insertOrderItems(OrderItems orderItems) {
		// TODO Auto-generated method stub
		orderItemsDao.insertOrderItems(orderItems);
	}

	public void updateOrderItems(OrderItems OrderItemsItems) {
		// TODO Auto-generated method stub
		orderItemsDao.updateOrderItems(OrderItemsItems);
	}

	/*public void deleteOrderItems(int id) {
		// TODO Auto-generated method stub
		orderItemsDao.deleteOrderItems(id);
	}*/

	public double getTotalPrice(int fid) {
		return foodItemsDao.getFoodItemsCostById(fid)*orderItemsDao.getQuantity(fid);
		
	}

	public List<OrderItems> getOrderItemsByCid(String cid) {
		// TODO Auto-generated method stub
		return (List<OrderItems>) orderItemsDao.getOrderItemsByCid(cid);
		
		
	}
	

}
