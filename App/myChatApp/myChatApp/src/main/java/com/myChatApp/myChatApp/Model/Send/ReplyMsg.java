package com.myChatApp.myChatApp.Model.Send;

import com.myChatApp.myChatApp.Model.Receive.Message;
import lombok.Data;

@Data
public class ReplyMsg {

    private String replyToken;
    private Message[] messages;
    private boolean notificationDisabled=false;
}