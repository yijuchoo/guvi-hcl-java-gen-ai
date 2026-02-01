package com.guvi.module4.student.notify;

public class ConsoleNotifier implements Notifier {

    @Override
    public void send(String to, String message) {
        // TODO: print in a readable format
        // Example output:
        // [WELCOME] To: asha@gmail.com | Welcome Asha! Your id is <uuid>
        System.out.println("[NOTIFICATION] " + to + " | " + message);
    }
}
