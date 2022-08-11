package com.mvc.fraudmanagement.repos;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.mvc.fraudmanagement.entities.Personnel;

	@Repository
		public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {

	}
