package com.main.service;

import java.util.List;

import com.main.beans.Transaction;

public interface ITransactionService {
	Transaction addTransaction( Transaction  transaction);

	Transaction findById(int id);

	List< Transaction> findAll();

	 Transaction updateTransaction( Transaction  transaction);
	
	 Transaction deleteTransaction(int id);

}
