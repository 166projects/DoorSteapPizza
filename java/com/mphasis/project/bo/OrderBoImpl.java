package com.mphasis.project.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.project.dao.OrderDao;
import com.mphasis.project.dao.OrderItemsDao;
import com.mphasis.project.entities.Orders;
import com.mphasis.project.exception.BusinessException;
@Service
public class OrderBoImpl implements OrderBo {
	@Autowired
	OrderDao orderDao;
	
	
	public List<Orders> getAllOrders() {
		List<Orders> orders=orderDao.getAllOrders();
		if(orders.isEmpty()) {
			throw new BusinessException("No orders found. Add a new order to the cart.");
		}
		return orders;
	}

	
	public Orders getOrdersById(int oid) {
		// TODO Auto-generated method stub
		return orderDao.getOrdersById(oid);
	}

	public void insertOrders(Orders orders) {
		orderDao.insertOrders(orders);
		
		//orderItemsDao.updateOrderId(orders.getOid());
		
	}

	/*public void updateOrders(Orders orders) {
		// TODO Auto-generated method stub
		orderDao.updateOrders(orders);
	}*/

	/*public void deleteOrders(int id) {
		// TODO Auto-generated method stub
		orderDao.deleteOrders(id);
	}*/

	

	public void updateStatusById(int oid,String status) {
		orderDao.updateStatusById(oid, status);
	}

	public double getTotalCost(int oid) {
		// TODO Auto-generated method stub
		return orderDao.getTotalCost(oid);
	}

}
