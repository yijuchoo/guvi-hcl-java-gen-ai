package com.guvi.module4.student.notify;

// Tuvesh
public class ConsoleNotifier implements Notifier {

    @Override
    public void send(String to, String message) {
        System.out.println(
            "[NOTIFICATION] To: " + to + " | " + message
        );
    }
}
