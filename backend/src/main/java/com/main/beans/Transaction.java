package com.main.beans;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id ;
	Date tdate;
	String custid , bic,code,receivername,recaccnumber;
	double amount;
	String status,reason;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int id, Date tdate, String custid, String bic, String code, String receivername,
			String recaccnumber, double amount, String status, String reason) {
		super();
		this.id = id;
		this.tdate = tdate;
		this.custid = custid;
		this.bic = bic;
		this.code = code;
		this.receivername = receivername;
		this.recaccnumber = recaccnumber;
		this.amount = amount;
		this.status = status;
		this.reason = reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getReceivername() {
		return receivername;
	}
	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}
	public String getRecaccnumber() {
		return recaccnumber;
	}
	public void setRecaccnumber(String recaccnumber) {
		this.recaccnumber = recaccnumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", tdate=" + tdate + ", custid=" + custid + ", bic=" + bic + ", code=" + code
				+ ", receivername=" + receivername + ", recaccnumber=" + recaccnumber + ", amount=" + amount
				+ ", status=" + status + ", reason=" + reason + "]";
	}
	

}
