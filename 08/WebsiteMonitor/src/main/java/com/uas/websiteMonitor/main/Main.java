package com.uas.websiteMonitor.main;


import java.sql.Date;

import com.uas.websiteMonitor.communication.CommunicationChannel;
import com.uas.websiteMonitor.communication.EmailChannel;
import com.uas.websiteMonitor.model.Frequency;
import com.uas.websiteMonitor.model.Notification;
import com.uas.websiteMonitor.model.Subscription;
import com.uas.websiteMonitor.model.User;
import com.uas.websiteMonitor.service.WebsiteMonitor;
import com.uas.websiteMonitor.observer.Observer;
import com.uas.websiteMonitor.strategy.ComparisonStrategy;
import com.uas.websiteMonitor.strategy.TextContentComparisonStrategy;

public class Main {
    public static void main(String[] args) {
    	
        User user = new User("User1", "Max", "maxmustermann@example.com", "1234567890");
        CommunicationChannel emailChannel = new EmailChannel(user);
        
     // Create a subscription for the user        
        Subscription subscription = new Subscription(
        	    "S001",
        	    "https://example.com/news",
        	    Frequency.DAILY,
        	    emailChannel,
        	    user
        	);

        // Add subscription to the user
        user.addSubscription(subscription);

        // Create a WebsiteMonitor and add the subscription        
        ComparisonStrategy strategy = new TextContentComparisonStrategy();
        WebsiteMonitor monitor = new WebsiteMonitor("Monitor1", strategy);
        monitor.addSubscription(subscription);

        
        Notification notification = new Notification("N001", "New article available!", new Date(06062025));
        
        Observer email = new EmailChannel(user);

        monitor.addObserver(email);
        monitor.checkForUpdates();
        subscription.getCommunicationChannel().sendNotification(notification, user);
    }
}