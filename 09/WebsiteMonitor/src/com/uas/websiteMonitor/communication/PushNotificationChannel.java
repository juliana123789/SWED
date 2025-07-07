package com.uas.websiteMonitor.communication;

import com.uas.websiteMonitor.model.Notification;
import com.uas.websiteMonitor.model.User;

public class PushNotificationChannel implements CommunicationChannel {
	private User user;

    public PushNotificationChannel(User user) {
        this.user = user;
    }

    @Override
    public void sendNotification(Notification notification, User user) {
        System.out.println("Sending email to " + user.getEmail() + ": " + notification.getMessage());
    }

    @Override
    public void update(String website, String status) {
        Notification notification = new Notification("ID1", "Website " + website + " is " + status, new java.util.Date());
        sendNotification(notification, this.user);
    }
}