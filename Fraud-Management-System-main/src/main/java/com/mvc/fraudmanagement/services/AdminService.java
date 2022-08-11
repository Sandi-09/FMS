package com.mvc.fraudmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mvc.fraudmanagement.entities.Admin;
import com.mvc.fraudmanagement.repos.AdminRepository;


@Service
public class AdminService {
	
	private List<Admin> adminList = new ArrayList<Admin>();
	
	@Autowired
	private AdminRepository adminRepository;
	
	public void loadAdmin() {
		adminList = adminRepository.findAll();
	}
	
	public boolean validateAdmin(String userId, String password) {
		for(Admin admin: adminList) {
			if(admin.getUserId().equals(userId) && admin.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
//	public Admin getAdmin(String userId, String password) {
//		for(Admin admin: adminList) {
//			if(admin.getUserId().equals(userId) && admin.getPassword().equals(password)) {
//				return admin;
//			}
//		}
//		return null;
//	}
}