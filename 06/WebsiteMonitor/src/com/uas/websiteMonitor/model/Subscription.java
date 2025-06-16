package com.uas.websiteMonitor.model;

import com.uas.websiteMonitor.communication.CommunicationChannel;

public class Subscription {
    private String subscriptionID;
    private String url;
    private Frequency frequency;
    private CommunicationChannel communicationChannel;
    private User user;

    public Subscription(String subscriptionID, String url, Frequency frequency, CommunicationChannel communicationChannel, User user) {
        this.subscriptionID = subscriptionID;
        this.url = url;
        this.frequency = frequency;
        this.communicationChannel = communicationChannel;
        this.user = user;
    }

    public void modify(Frequency newFrequency) {
        this.frequency = newFrequency;
    }

    public void cancel() {
        // Cancel logic
    }
    
    public String getSubscriptionID() {
        return subscriptionID;
    }
    
    public String getUrl() {
        return url;
    }
    
    public Frequency getFrequency() {
        return frequency;
    }
    
    public User getUser() {
        return user;
    }

    public CommunicationChannel getCommunicationChannel() {
        return communicationChannel;
    }
    
    public void notifyObserver(Notification notification) {
        communicationChannel.sendNotification(notification, user);
    }
}
