package com.main.service;

import java.util.List;

import com.main.beans.Receiver;

public interface IReceiverService {
	Receiver addReceiver(Receiver receiver);

	Receiver findById(String receiverid);

	List<Receiver> findAll();

	Receiver updateReceiver(Receiver receiver);
	
	Receiver deleteReceiver(String receiverid);


}
