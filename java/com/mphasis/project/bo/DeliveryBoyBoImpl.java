package com.mphasis.project.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.project.dao.DeliveryBoyDao;
import com.mphasis.project.entities.DeliveryBoy;
@Service
public class DeliveryBoyBoImpl implements DeliveryBoyBo {
@Autowired
DeliveryBoyDao deliveryBoyDao;
	public void signUp(DeliveryBoy db) {
		  if(db.getDpass().matches("[a-zA-Z0-9]{4,}"))
			  db=deliveryBoyDao.signUp(db);
		  else
			  System.out.println("Invalid pattern");
		
	}

	public DeliveryBoy login(int did, String dpass) {
		return deliveryBoyDao.login(did, dpass);
	}
	

	public void updateDeliveryBoy(int did, long contactno) {
		deliveryBoyDao.updateDeliveryBoy(did, contactno);
	}

	public void changePassword(int did, String opass, String npass) {
		if(!opass.equals(npass))
			deliveryBoyDao.changePassword(did, npass);
			else
				System.out.println("Old and new passwords should not be same");
	}

	public void deleteDeliveryBoy(int did) {
		deliveryBoyDao.deleteDeliveryBoy(did);

	}

	public List<DeliveryBoy> getAll() {
		return deliveryBoyDao.getAll();
	}

}
