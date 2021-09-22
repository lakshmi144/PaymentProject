package com.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.beans.Message;
import com.main.service.IMessageService;

@RestController
public class MessageController {
	
	@Autowired
	IMessageService messageservice;
	
	@GetMapping(value="message")
	public ResponseEntity<List<Message>> getMessage() {
		List<Message> msgs = messageservice.findAll();
		return new ResponseEntity<List<Message>>(msgs, HttpStatus.OK);
	}
	

	@RequestMapping(value = "mes", method = RequestMethod.POST)
	public ResponseEntity<Message> addMessage(Message message) {
		Message msg = messageservice.addMessage(message);
		return new ResponseEntity<Message>(msg, HttpStatus.OK);
	}
	
	@GetMapping(value="message/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable("id") String id){
		Message mes = messageservice.findById(id);
		return new ResponseEntity<Message>(mes,HttpStatus.OK);
	}
	

}
