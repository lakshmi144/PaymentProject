package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.beans.Message;

public interface MessageRepository extends JpaRepository<Message,String> {

}
