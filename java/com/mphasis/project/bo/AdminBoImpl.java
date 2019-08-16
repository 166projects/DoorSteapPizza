package com.mphasis.project.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.project.dao.AdminDao;
import com.mphasis.project.entities.Admin;

@Service
public class AdminBoImpl implements AdminBo {
@Autowired
AdminDao adminDao;
	public void signUp(Admin admin) {
	  if(admin.getPassword().matches("[a-zA-Z0-9]{4,}"))
		  admin=adminDao.signUp(admin);
	  else
		 
		  System.out.println("Invalid pattern");
				
	}

	public Admin login(String aid, String pass) {
		return adminDao.login(aid, pass);
	}

	public void updateAdmin(String aid,long contactno) {
		adminDao.updateAdmin(aid, contactno);
		
	}

	public void changePassword(String aid, String opass,String npass) {
		if(!opass.equals(npass))
		adminDao.changePassword(aid, npass);
		else
			System.out.println("Old and new passwords should not be same");
	}

	public void deleteAdmin(String aid) {
		adminDao.deleteAdmin(aid);
	}
}
