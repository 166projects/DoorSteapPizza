package com.mphasis.project.dao;



import java.util.List;

import com.mphasis.project.entities.DeliveryBoy;

public interface DeliveryBoyDao {
	public DeliveryBoy signUp(DeliveryBoy db);
	public DeliveryBoy  login(int did,String dpass);
	public void updateDeliveryBoy(int did,long contactno);
	public void changePassword(int did,String dpass);
	public void deleteDeliveryBoy(int did);
	public List<DeliveryBoy> getAll();
}
