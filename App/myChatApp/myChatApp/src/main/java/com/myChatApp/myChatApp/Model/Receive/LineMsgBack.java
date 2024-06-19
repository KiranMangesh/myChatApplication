package com.myChatApp.myChatApp.Model.Receive;
import lombok.Data;
@Data
public class LineMsgBack {
    private String destination;
    private Event[] events;
}