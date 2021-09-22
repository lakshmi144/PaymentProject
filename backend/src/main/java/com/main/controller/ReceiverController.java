package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.main.beans.Receiver;
import com.main.service.IReceiverService;

@RestController
public class ReceiverController {
	
	@Autowired
	IReceiverService receiverService;
	
	@GetMapping(value="receiver")
	public ResponseEntity<List<Receiver>> getReceivers() {
		List<Receiver> rec = receiverService.findAll();
		return new ResponseEntity<List<Receiver>>(rec, HttpStatus.OK);
	}
	
	@GetMapping(value="receiver/{id}")
	public ResponseEntity<Receiver> getReceiver(@PathVariable("id") String id){
		Receiver rec = receiverService.findById(id);
		return new ResponseEntity<Receiver>(rec,HttpStatus.OK);
	}

	

}
