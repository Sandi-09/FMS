package com.mvc.fraudmanagement.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvc.fraudmanagement.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query(value="select * from transaction where transaction.fraud_level='high' order by trans_date",nativeQuery=true)	
	public List<Transaction> getAllCriticalTransactionRepo();
}