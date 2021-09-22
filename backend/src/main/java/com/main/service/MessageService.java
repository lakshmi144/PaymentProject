package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.beans.Message;
import com.main.repo.MessageRepository;


@Service
public class MessageService implements IMessageService {

	@Autowired
	MessageRepository messageRepo;
	
	
	@Override
	 public Message addMessage(Message message) {
		// TODO Auto-generated method stub
		return messageRepo.save(message);
	}

	@Override
	public Message findById(String code) {
		// TODO Auto-generated method stub
		//return null;
		return messageRepo.findById(code).get();
	}

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return messageRepo.findAll();
	}

}
