package com.main.service;

import java.util.List;

import com.main.beans.Message;

public interface IMessageService {
	Message findById(String code);
	List<Message> findAll();
	Message addMessage(Message msg);
	
}
