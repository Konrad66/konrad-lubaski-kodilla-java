package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessage(user, "Hello World!");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not send!");
        }
    }
}
