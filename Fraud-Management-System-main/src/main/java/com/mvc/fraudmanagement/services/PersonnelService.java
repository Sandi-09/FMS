package com.mvc.fraudmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.fraudmanagement.entities.Personnel;
import com.mvc.fraudmanagement.entities.User;
import com.mvc.fraudmanagement.repos.PersonnelRepository;


@Service
public class PersonnelService {

	private List<Personnel> personnelList=new ArrayList<>();
	@Autowired
	public PersonnelRepository personnelRepository;
	
	public void getAllPersonnel() {
		personnelList=personnelRepository.findAll();
	}
	public boolean isValidLogin(String userId,String password)
	{
		for(Personnel u:personnelList) {
		if(u.getUserId().equals(userId) && u.getPassword().equals(password)) {
		return true;
		}
	}
		return false;
	}
	public Personnel getPersonnelById(String userId) {
		getAllPersonnel();
		for(Personnel personnel:personnelList)
		{
			if(personnel.getUserId().equals(userId))
			return personnel;
		}
		return null;
	}
	
	public List<Personnel> getUnApprovedPersonnel() {
		List<Personnel> unApprovedPersonnel = new ArrayList<Personnel>();
		getAllPersonnel();
		for (Personnel personnel : personnelList) {
			if (personnel.getIsAuthorized()==1) {
				unApprovedPersonnel.add(personnel);
			}
		}

		return unApprovedPersonnel;
	}

	public void rejectPersonnel(int id) {
		for (Personnel personnel : personnelList) {
			if (personnel.getId() == id) {
				personnel.setIsAuthorized(0);
				personnelRepository.save(personnel);
				break;
			}
		}
	}

	public void approvePersonnel(int id) {
		for (Personnel personnel : personnelList) {
			if (personnel.getId() == id) {
				personnel.setIsAuthorized(2);
				personnelRepository.save(personnel);
				break;
			}
		}
	}
	

}
