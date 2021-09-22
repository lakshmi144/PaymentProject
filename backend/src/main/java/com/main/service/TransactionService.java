package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.beans.Transaction;
import com.main.repo.TransactionRepository;

@Service
public class TransactionService implements ITransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public Transaction addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction findById(int id) {
		// TODO Auto-generated method stub
		return transactionRepository.findById(id).get();
	}

	@Override
	public List<Transaction> findAll() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		Optional<Transaction> trans = transactionRepository.findById(transaction.getId());
		if (trans.isPresent()) {
			return transactionRepository.save(transaction);
		}
		else
			return null;
	}

	@Override
	public Transaction deleteTransaction(int id) {
		// TODO Auto-generated method stub
		Optional<Transaction> trans = transactionRepository.findById(id);
		if (trans.isPresent()) {
			transactionRepository.deleteById(id);
			return transactionRepository.getById(id);
		}
		else
			return null;
	}
	

}
