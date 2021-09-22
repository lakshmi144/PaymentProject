package com.main.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.beans.Customer;
import com.main.beans.Transaction;
import com.main.repo.CustomerRepository;
//import com.main.repo.CustomerRepository;
//import com.main.service.CustomerService;
//import com.main.service.ICustomerService;
//import com.main.service.CustomerService;
import com.main.service.ITransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	ITransactionService transactionservice;
	@Autowired
	CustomerRepository custser;
	
	@RequestMapping(value = "transaction", method = RequestMethod.POST)
	public Transaction addTransaction(@RequestBody Transaction t) throws IOException,FileNotFoundException {
		Transaction transaction = new Transaction(t.getId(),t.getTdate(),t.getCustid(),t.getBic(),t.getCode(),t.getReceivername(),t.getRecaccnumber(),t.getAmount(),t.getStatus(),t.getReason());
		System.out.println(transaction);
		
		String cust = transaction.getCustid();
		
		Customer custobj = custser.findById(cust).get();
		System.out.println(custobj);
		boolean f = false;
		
		String name = transaction.getReceivername();
		File file = new File("C:\\Users\\Administrator\\Documents\\Project\\MainProject\\src\\main\\java\\com\\main\\controller\\sdnlist.txt");
		Scanner scanner = new Scanner(file);
		double transferfee = 0.25 * transaction.getAmount();
		double newbalance = custobj.getClearbalance() - transferfee - transaction.getAmount() ;
		while (scanner.hasNextLine()) {
			final String lineFromFile = scanner.nextLine();
   			if(lineFromFile.contains(name)) { 
   				transaction.setStatus("Failed");
				transaction.setReason("Can not transfer to specified receiver");
				f=true;
   					break;
   			}
		}
		System.out.println(custobj.getOverdraft());
		System.out.println(newbalance);
		scanner.close();
		if(!(f)) {
			if(newbalance > 0 || custobj.getOverdraft().equals("yes"))
						{
							transaction.setStatus("Success");
							transaction.setReason("NA");
							Customer updatedcust = new Customer(custobj);
							updatedcust.setClearbalance(newbalance);
							custser.save(updatedcust);
						
						}
					else {
						transaction.setStatus("Failed");
						transaction.setReason("Insufficient Balance");
						}
					}
		
		
		System.out.println(transaction);
		
		Transaction trans = transactionservice.addTransaction(transaction);
		return trans;
	}
	
	@GetMapping(value="transaction")
	public ResponseEntity<List<Transaction>> getTransaction() {
		List<Transaction> trans = transactionservice.findAll();
		return new ResponseEntity<List<Transaction>>(trans, HttpStatus.OK);
	}

	

}
