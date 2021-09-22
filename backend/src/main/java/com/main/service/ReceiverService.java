package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.beans.Receiver;
import com.main.repo.ReceiverRepository;

@Service
public class ReceiverService implements IReceiverService {

	@Autowired
	ReceiverRepository receiverRepo;

	@Override
	public Receiver addReceiver(Receiver receiver) {
		// TODO Auto-generated method stub
		return receiverRepo.save(receiver);
	}

	@Override
	public Receiver findById(String bic) {
		// TODO Auto-generated method stub
		return receiverRepo.findById(bic).get();
	}

	@Override
	public List<Receiver> findAll() {
		// TODO Auto-generated method stub
		return receiverRepo.findAll();
	}

	@Override
	public Receiver updateReceiver(Receiver receiver) {
		// TODO Auto-generated method stub
		Optional<Receiver> optReceiver = receiverRepo.findById(receiver.getBic());
		if (optReceiver.isPresent()) {
			return receiverRepo.save(receiver);
		}
		else
			return null;
	}

	@Override
	public Receiver deleteReceiver(String bic) {
		// TODO Auto-generated method stub
		//return null;
		Optional<Receiver> optReceiver = receiverRepo.findById(bic);
		if (optReceiver.isPresent()) {
			receiverRepo.deleteById(bic);
			return receiverRepo.getById(bic);
		}
		else
			return null;
		 
	}
}
