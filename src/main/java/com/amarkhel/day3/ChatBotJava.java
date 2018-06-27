package com.amarkhel.day3;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatBotJava {
    static List<String> stopWords = new ArrayList<>();
    static{
        stopWords.add("Damn");
    }
    public static void main(String[] args){
        User user = new User("user", 18, new Address("Minsk", "Street", 18));
        User admin = new User("admin", 25, new Address("Vilnius", "Street", 18));
        List<Message> messages = new ArrayList<>();
        messages.add(new ChatMessage("Damn, I tired...", LocalDateTime.now(), user));
        messages.add(new ChatMessage("Hello all!", LocalDateTime.now(), admin));
        messages.add(new ChatMessage("Hello all!", LocalDateTime.now(), user));
        messages.add(new UserJoined(LocalDateTime.now(), user));
        messages.add(new UserLeaved(LocalDateTime.now(), user));
        messages.add(new SystemMessage("Conversation ended", LocalDateTime.now()));
        messages.stream().forEach(ChatBotJava::handleMessage);
    }

    public static void handleMessage(Message message) {
        if(message instanceof ChatMessage){
            ChatMessage chatMessage = (ChatMessage)message;
            if(stopWords.stream().filter( m -> chatMessage.getMessage().contains(m)).count() > 0){
                System.out.println("Your message was censored");
            } else if(chatMessage.getUser().getName().equals("admin")){
                System.out.println("Message from admin " + chatMessage.getMessage());
            } else {
                System.out.println(chatMessage.getUser().getName() + " just said " + chatMessage.getMessage());
            }
        }
        if(message instanceof SystemMessage){
            SystemMessage systemMessage = (SystemMessage)message;

            System.out.println(systemMessage.getTime().toString() + " IMPORTANT " + systemMessage.getMessage());
        }
        if(message instanceof UserJoined){
            UserJoined userJoined = (UserJoined)message;
            System.out.println(userJoined.getUser().getName() + " joined at " + userJoined.getTime().toString());
        }
        if(message instanceof UserLeaved){
            UserLeaved userLeaved = (UserLeaved)message;
            System.out.println("Unfortunately " + userLeaved.getUser().getName() + " leaved the room ");
        }
    }
}
class User {
    private String name;
    private int age;
    private Address address;
   public User(String name, int age, Address address) {
       this.name = name;
       this.age = age;
       this.address = address;
   }
   public String getName() {
       return name;
   }
    public int getAge() {
        return age;
    }

    public Address getAddress() {
       return address;
    }
}
class Address {
    private String city;
    private String street;
    private int building;
    public Address(String city, String street, int building){
        this.city = city;
        this.street = street;
        this.building = building;
    }
    public String getCity(){
        return city;
    }
    public String getStreet(){
        return street;
    }
    public int getBuilding(){
        return building;
    }
}
abstract class Message{}
class ChatMessage extends Message{
    private String mgs;
    private LocalDateTime time;
    private User user;
    public ChatMessage(String mgs, LocalDateTime time, User user){
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
}
class SystemMessage extends Message{
    private String mgs;
    private LocalDateTime time;
    public SystemMessage(String mgs, LocalDateTime time){
        this.mgs = mgs;
        this.time = time;
    }
    public String getMessage(){
        return mgs;
    }
    public LocalDateTime getTime(){
        return time;
    }
}
class UserJoined extends Message{
    private LocalDateTime time;
    private User user;
    public UserJoined(LocalDateTime time, User user){
        this.time = time;
        this.user = user;
    }
    public User getUser(){
        return user;
    }
    public LocalDateTime getTime(){
        return time;
    }
}
class UserLeaved extends Message{
    private LocalDateTime time;
    private User user;
    public UserLeaved(LocalDateTime time, User user){
        this.time = time;
        this.user = user;
    }
    public User getUser(){
        return user;
    }
    public LocalDateTime getTime(){
        return time;
    }
}