package com.mvc.fraudmanagement.repos;
	
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvc.fraudmanagement.entities.Card;

	@Repository
		public interface CardRepository extends JpaRepository<Card, Integer> {


		@Query(value="select * from cards where cards.fraud_level='high' order by trans_date",nativeQuery=true)	
		public List<Card> getAllCriticalCardRepo();
	}