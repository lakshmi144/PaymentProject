package com.main.beans;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="customer")
public class Customer {
	@Id
	String customerid;
	String accountholdername,overdraft;
	double clearbalance;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Customer cust)
	{
		super();
		this.customerid = cust.getCustomerid();
		this.accountholdername = cust.getAccountholdername();
		this.overdraft = cust.getOverdraft();
		this.clearbalance = cust.getClearbalance();
		
	}
	public Customer(String customerid, String accountholdername, String overdraft, double clearbalance) {
		super();
		this.customerid = customerid;
		this.accountholdername = accountholdername;
		this.overdraft = overdraft;
		this.clearbalance = clearbalance;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getAccountholdername() {
		return accountholdername;
	}
	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}
	public String getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}
	public double getClearbalance() {
		return clearbalance;
	}
	public void setClearbalance(double clearbalance) {
		this.clearbalance = clearbalance;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", accountholdername=" + accountholdername + ", overdraft="
				+ overdraft + ", clearbalance=" + clearbalance + "]";
	}
	

}

