package com.myChatApp.myChatApp.controllers;

import com.linecorp.bot.messaging.client.MessagingApiClient;
import com.linecorp.bot.messaging.model.ReplyMessageRequest;
import com.linecorp.bot.messaging.model.TextMessage;
import com.linecorp.bot.spring.boot.handler.annotation.EventMapping;
import com.linecorp.bot.spring.boot.handler.annotation.LineMessageHandler;
import com.linecorp.bot.webhook.model.Event;
import com.linecorp.bot.webhook.model.MessageEvent;
import com.linecorp.bot.webhook.model.TextMessageContent;
import com.myChatApp.myChatApp.Model.Receive.Message;
import com.myChatApp.myChatApp.Model.Send.ReplyMsg;
import com.myChatApp.myChatApp.Repository.LineMessageRepository;
import com.myChatApp.myChatApp.Service.LineMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@LineMessageHandler
@RestController
@RequestMapping("/Message")
public class messageController {


    static final Logger log = LoggerFactory.getLogger(messageController.class);
    private final MessagingApiClient messagingApiClient;
    LineMsgService lineMsgService;
    public messageController(MessagingApiClient messagingApiClient) {
        this.messagingApiClient = messagingApiClient;
    }

    @Autowired
    private LineMessageRepository lineMessageRepository;

    /*
    handleTextMessageEvent :- This method for handling message from Line webhook.
     */
    @EventMapping
    public void handleTextMessageEvent(MessageEvent event) {
        log.info("event: " + event);

        log.info(String.valueOf(event.message()));
        TextMessageContent msgContent= (TextMessageContent) event.message();
        Message msg=new Message();
        msg.setText(msgContent.text());
        msg.setId(msgContent.id());
        msg.setType("TextMessageContent");
        msg.setUserId(event.source().userId());

        // Saving user and Message info
        lineMessageRepository.save(msg);
        log.info("reply Token : "+ event.replyToken());
        this.replyUser(event);

    }

    /* reply User method for send message to line.
    Since reply token need to send msg to line which is coming along with incoming msg and we can use once that token.
    */

    public void replyUser(MessageEvent event) {
        String originalMessageText;
        if (event.message() instanceof TextMessageContent) {
            TextMessageContent message = (TextMessageContent) event.message();

            originalMessageText = switch (message.text()) {
                case "1" -> "\n Please select service: "  +
                        "    \n a. New Broadband Connection " +
                        "    \n b. Old Broadband Connection ";
                case "2" -> "\n Please select service: "  +
                        "    \n a. New TV Connection " +
                        "    \n b. Old TV Connection ";
                case "a" -> "please leave with contact details . our Agent will connect with you shortly.";
                case "b" -> "please leave with contact details . our Agent will connect with you shortly for your issue.";
                default -> {
                    yield "\n How may i help you? " +
                            "  \n Please select service: " +
                            "  \n 1. Broadband " +
                            "  \n 2. TV";
                }

            };
            messagingApiClient.replyMessage(new ReplyMessageRequest(
                    event.replyToken(),
                    List.of(new TextMessage(originalMessageText)),
                    false));
        }
    }


    /*This API Give the messages of particular user
    */
    @GetMapping("/{userId}")
    public List<Message> getMessagebyUserID(@PathVariable String userId) {
        return lineMessageRepository.findByuserId(userId);
    }

    /* This API Give the message and user details
     */
    @GetMapping
    public List<Message> getMessagebyUserID() {
        return lineMessageRepository.findAll();
    }
    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }

}