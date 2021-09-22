package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.beans.Receiver;

@Repository
public interface ReceiverRepository extends JpaRepository<Receiver,String> {

}
