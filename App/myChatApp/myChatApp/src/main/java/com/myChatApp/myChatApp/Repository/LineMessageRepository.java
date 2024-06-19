package com.myChatApp.myChatApp.Repository;


import com.linecorp.bot.webhook.model.MessageEvent;

import com.myChatApp.myChatApp.Model.Receive.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LineMessageRepository extends MongoRepository<Message, String> {

    List<Message> findByuserId(String userId);
}
