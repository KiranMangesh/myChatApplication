package com.myChatApp.myChatApp.Model.Receive;
import lombok.Data;
@Data
public class Event {
    private String type;
    private Message message;
    private String webhookEventId;
    private DeliveryContext deliveryContext;
    private String timestamp;
    private Source source;
    private String replyToken;
    private String mode;
}