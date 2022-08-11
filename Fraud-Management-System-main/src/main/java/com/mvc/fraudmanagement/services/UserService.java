package com.mvc.fraudmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.fraudmanagement.entities.User;
import com.mvc.fraudmanagement.repos.UserRepository;

@Service
public class UserService {
	//private User user;
	private List<User> userList=new ArrayList<>();
	@Autowired
	public UserRepository userRepository;
	
	public void getAllUser() {
		userList=userRepository.findAll();
	}
	public boolean isValidLogin(String userId,String password)
	{
		for(User u:userList) {
		if(u.getUserId().equals(userId) && u.getPassword().equals(password)) {
		return true;
		}
	}
		return false;
	}
	public User getUserById(String userId) {
		getAllUser();
		for(User user:userList)
		{
			if(user.getUserId().equals(userId))
			return user;
		}
		return null;
	}
	
	public List<User> getUnApprovedUser() {
		List<User> unApprovedUser = new ArrayList<User>();
		getAllUser();
		for (User user : userList) {
			if (user.getIsAuthorized()==1) {
				unApprovedUser.add(user);
			}
		}

		return unApprovedUser;
	}

	public void rejectUser(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				user.setIsAuthorized(0);
				userRepository.save(user);
				break;
			}
		}
	}

	public void approveUser(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				user.setIsAuthorized(2);
				userRepository.save(user);
				break;
			}
		}
	}


}
