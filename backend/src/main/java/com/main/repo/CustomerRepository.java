package com.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.beans.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>,CrudRepository<Customer,String>{


	@Query(value = " select * from customer where accountholdername like 'HDFC%' and customerid!= :custid ",nativeQuery = true)
	List<Customer> getbankdetails (@Param("custid") String custid);
}
