package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.beans.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


	
}
