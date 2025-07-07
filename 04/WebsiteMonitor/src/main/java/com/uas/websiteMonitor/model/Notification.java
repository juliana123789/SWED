package com.uas.websiteMonitor.model;

import java.util.Date;

import com.uas.websiteMonitor.communication.CommunicationChannel;

public class Notification {
    private String notificationID;
    private String message;
    private Date timestamp;

    public Notification(String notificationID, String message, Date timestamp) {
        this.notificationID = notificationID;
        this.message = message;
        this.timestamp = timestamp;
    }

    public void sendNotification(CommunicationChannel channel, User user) {
        channel.sendNotification(this, user);
    }

    public String getMessage() {
        return message;
    }
    
    public String getNotificationID() {
        return notificationID;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
}