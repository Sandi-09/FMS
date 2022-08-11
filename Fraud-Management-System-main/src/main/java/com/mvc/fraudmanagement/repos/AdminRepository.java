package com.mvc.fraudmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.fraudmanagement.entities.Admin;
@Repository
	public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
