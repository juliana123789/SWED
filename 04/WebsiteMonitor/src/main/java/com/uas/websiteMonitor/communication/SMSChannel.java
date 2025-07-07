package com.uas.websiteMonitor.communication;

import com.uas.websiteMonitor.model.Notification;
import com.uas.websiteMonitor.model.User;

public class SMSChannel implements CommunicationChannel {
    @Override
    public void sendNotification(Notification notification, User user) {
        System.out.println("Sending SMS notification to " + user.getPhoneNumber() + ": " + notification.getMessage());
    }
}