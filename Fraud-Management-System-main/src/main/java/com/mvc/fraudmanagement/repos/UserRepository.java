package com.mvc.fraudmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.fraudmanagement.entities.User;
@Repository
	public interface UserRepository extends JpaRepository<User, Integer> {

}