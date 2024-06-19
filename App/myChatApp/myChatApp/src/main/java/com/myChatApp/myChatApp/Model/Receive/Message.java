package com.myChatApp.myChatApp.Model.Receive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private String type;
    private String id;
    private String text;
    private String userId;
}