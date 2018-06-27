package com.amarkhel.day3;

import java.time.LocalDateTime;

interface MessageType {
    void handle();
}

class ChatMessageType implements MessageType{
    private String mgs;
    private LocalDateTime time;
    private User user;
    public ChatMessageType(String mgs, LocalDateTime time, User user){
        this.mgs = mgs;
        this.time = time;
        this.user = user;
    }
    public String getMessage(){
        return mgs;
    }
    public User getUser(){
        return user;
    }
    public LocalDateTime getTime(){
        return time;
    }

    @Override
    public void handle() {
        /*if(getUser().getName().equals("admin")) System.out.println("");
        else if(...) System.out.println("");
        else ...*/
    }
}
class SystemMessageType implements MessageType{
    private String mgs;
    private LocalDateTime time;
    public SystemMessageType(String mgs, LocalDateTime time){
        this.mgs = mgs;
        this.time = time;
    }
    public String getMessage(){
        return mgs;
    }
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public void handle() {

    }
}
class UserJoinedType implements MessageType{
    private LocalDateTime time;
    private User user;
    public UserJoinedType(LocalDateTime time, User user){
        this.time = time;
        this.user = user;
    }
    public User getUser(){
        return user;
    }
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public void handle() {

    }
}
class UserLeavedType implements MessageType{
    private LocalDateTime time;
    private User user;
    public UserLeavedType(LocalDateTime time, User user){
        this.time = time;
        this.user = user;
    }
    public User getUser(){
        return user;
    }
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public void handle() {

    }
}