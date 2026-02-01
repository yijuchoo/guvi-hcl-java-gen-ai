package com.guvi.spring_boot_intro.notify;

public interface Notifier {
    // TODO
    // send(String to, String message) -> send a message to someone
    public void send(String to, String message);
}
