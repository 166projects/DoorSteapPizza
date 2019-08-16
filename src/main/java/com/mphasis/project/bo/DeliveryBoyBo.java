
package com.mphasis.project.bo;

import java.util.List;

import com.mphasis.project.entities.DeliveryBoy;

public interface DeliveryBoyBo {
	public void signUp(DeliveryBoy db);
	public DeliveryBoy  login(int did,String dpass);
	public void updateDeliveryBoy(int did,long contactno);
	public void changePassword(int did,String opass,String npass);
	public void deleteDeliveryBoy(int did);
	public List<DeliveryBoy> getAll();
}
