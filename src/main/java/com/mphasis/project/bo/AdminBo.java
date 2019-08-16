package com.mphasis.project.bo;

import com.mphasis.project.entities.Admin;

public interface AdminBo {
	public void signUp(Admin admin);
	public Admin login(String aid,String pass);
	public void updateAdmin(String aid,long contactno);
	public void changePassword(String aid,String opass,String npass);
	public void deleteAdmin(String aid);
}

