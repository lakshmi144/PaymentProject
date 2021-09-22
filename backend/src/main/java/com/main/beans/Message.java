package com.main.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="message")
public class Message {
	@Id String code;
	String instruction;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String code, String instruction) {
		super();
		this.code = code;
		this.instruction = instruction;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@Override
	public String toString() {
		return "Message [code=" + code + ", instruction=" + instruction + "]";
	}
	
	

}
