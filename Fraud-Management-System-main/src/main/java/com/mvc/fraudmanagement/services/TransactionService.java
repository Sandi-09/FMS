package com.mvc.fraudmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.fraudmanagement.entities.Transaction;
import com.mvc.fraudmanagement.repos.TransactionRepository;

@Service
public class TransactionService {
    private List<Transaction> transactionList = new ArrayList<>();
    @Autowired
    public TransactionRepository transactionRepository;

    public void getAllTransaction() {
        transactionList = transactionRepository.findAll();
    }

    public Transaction getTransactionById(int id) {
        getAllTransaction();
        for (Transaction transaction : transactionList) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        return null;
    }

    public Transaction getTransactionByUserId(String id) {
        getAllTransaction();
        for (Transaction transaction : transactionList) {
            if (transaction.getUserId().equals(id)) {
                return transaction;
            }
        }
        return null;
    }

    public Transaction deleteTransaction(String id) {
        Transaction transaction = getTransactionByUserId(id);
        if (transaction.getUserId().equals(id)) {
            return transaction;
        } else {
            return null;
        }
    }

    // public List<Transaction> showAllTransactionFraud() {
    // List<Transaction>transactionds = new ArrayList<>();
    // getAllTransaction();
    // for (Transaction c : transactionList) {
    // transactions.add(c);
    // }
    // return transactions;
    // }

    public List<Transaction> getTransactionByUserIdList(String id) {
        List<Transaction> getUserTransaction = new ArrayList<>();
        getAllTransaction();
        for (Transaction transaction : transactionList) {
            if (transaction.getUserId().equals(id)) {
                getUserTransaction.add(transaction);
            }
        }
        return getUserTransaction;
    }
    
    public List<Transaction> getAllCritical() {
		List<Transaction> transaction=transactionRepository.getAllCriticalTransactionRepo();
		return transaction;
	}
    
}