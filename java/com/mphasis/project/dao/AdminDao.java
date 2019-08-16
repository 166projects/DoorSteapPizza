package com.mphasis.project.dao;

import com.mphasis.project.entities.Admin;

public interface AdminDao {
	
	public Admin signUp(Admin admin);
	public Admin login(String aid,String pass);
	public void updateAdmin(String aid,long contactno);
	public void changePassword(String aid,String pass);
	public void deleteAdmin(String aid);
}
