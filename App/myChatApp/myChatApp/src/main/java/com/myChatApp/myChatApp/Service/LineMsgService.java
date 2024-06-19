package com.myChatApp.myChatApp.Service;

public class LineMsgService {
}
/*
import lombok.extern.slf4j.Slf4j;
import org.bson.json.JsonObject;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class LineMsgService {

    @Value("${line.bot.channel-token}")
    private String channel_token;


    private RestTemplate restTemplate;

    private final String replyUrl = "https://api.line.me/v2/bot/message/reply";


    public void replyMsg(ReplyMsg replyMsgs) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth(channel_token);
        HttpEntity<ReplyMsg> httpEntity = new HttpEntity<>(replyMsgs, httpHeaders);
        ResponseEntity<JsonObject> response = restTemplate.exchange(replyUrl, HttpMethod.POST, httpEntity, JsonObject.class);

        if (HttpStatus.OK.equals(response.getStatusCode())) {
            log.info("response status:{}, response msg:{}", response.getStatusCode(), response.getBody());
        }
    }
}
*/