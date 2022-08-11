package com.mvc.fraudmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.fraudmanagement.entities.Claim;
import com.mvc.fraudmanagement.repos.ClaimRepository;

@Service
public class ClaimService {

	@Autowired
	ClaimRepository claimRepository;

	private List<Claim> claimList = new ArrayList<>();

	public void getAllClaim() {
		claimList = claimRepository.findAll();
	}

	public Claim getClaimById(int id) {
		getAllClaim();
		for (Claim claim : claimList) {
			if (claim.getId() == id) {
				return claim;
			}
		}
		return null;
	}
	
	public  Claim getClaimByUserId(String id) {
		getAllClaim();
		for (Claim claim : claimList) {
			if (claim.getUserId().equals(id)) {
				return claim;
			}
		}
		return null;
	}

	public Claim deleteClaim(String userId) {
		Claim claim = getClaimByUserId(userId);
		if (claim.getUserId().equals(userId)) {
			return claim;
		} else {
			return null;
		}
	}
	
//	public List<Claim> showAllClaimFraud() {
//		List<Claim> claims = new ArrayList<>();
//		getAllClaim();
//		for (Claim c : claims) {
//			claims.add(c);
//		}
//		return claims;
//	}



	public List<Claim> getClaimByUserIdList(String id) {
		
		List<Claim>getUserClaim=new ArrayList<>();
		getAllClaim();
		for (Claim claim : claimList) {
			if (claim.getUserId().equals(id)) {
				getUserClaim.add(claim);
			}
		}
		return getUserClaim;
	}

	
	public List<Claim> getAllCritical() {
		List<Claim> claim=claimRepository.getAllCriticalClaimRepo();
		return claim;
	}
}
