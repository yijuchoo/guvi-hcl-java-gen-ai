package com.guvi.spring_boot_intro.notify;

import org.springframework.stereotype.Component;

@Component
public class ConsoleNotifier implements Notifier {

    @Override
    public void send(String to, String message) {
        // TODO: print in a readable format
        // Example output:
        // [WELCOME] To: asha@gmail.com | Welcome Asha! Your id is <uuid>
        System.out.println("[NOTIFICATION] " + to + " | " + message);
    }
}
