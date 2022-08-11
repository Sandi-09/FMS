package com.mvc.fraudmanagement.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvc.fraudmanagement.entities.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer>  {

	@Query(value="select * from claim where claim.fraud_level='high' order by trans_date",nativeQuery=true)	
	public List<Claim> getAllCriticalClaimRepo();	
}

