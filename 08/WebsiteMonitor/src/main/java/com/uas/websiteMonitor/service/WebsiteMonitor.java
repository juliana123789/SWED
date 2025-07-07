package com.uas.websiteMonitor.service;

import com.uas.websiteMonitor.observer.Subject;
import com.uas.websiteMonitor.strategy.ComparisonStrategy;
import com.uas.websiteMonitor.model.Notification;
import com.uas.websiteMonitor.model.Subscription;
import com.uas.websiteMonitor.observer.Observer;
import java.util.*;

public class WebsiteMonitor implements Subject {
    private String monitorID;
    private List<Subscription> subscriptions = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    
    private ComparisonStrategy comparisonStrategy;
    private Map<String, String> lastWebsiteContents = new HashMap<>();

    public WebsiteMonitor(String monitorID, ComparisonStrategy comparisonStrategy) {
        this.monitorID = monitorID;
        observers = new ArrayList<>();
        this.comparisonStrategy = comparisonStrategy;
    }
    
    public void checkForUpdates() {
        for (Subscription subscription : subscriptions) {
            String url = subscription.getUrl();
            String newContent = fetchWebsiteContent(url);

            String oldContent = lastWebsiteContents.get(url);

            boolean changed = comparisonStrategy.isWebsiteChanged(oldContent, newContent);

            if (changed) {
                Notification notification = new Notification("Notification1", "Website updated!", new java.util.Date());
                subscription.getCommunicationChannel().sendNotification(notification, subscription.getUser());
                notifyObservers(url, "UPDATED");
                lastWebsiteContents.put(url, newContent);
            } else {
                notifyObservers(url, "UNCHANGED");
            }
        }
    }
    
    private String fetchWebsiteContent(String url) {
        return "<html>Dummy content from " + url + "</html>";
	}

	public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }
    
    public String getMonitorID() {
        return monitorID;
    }

    public void removeSubscription(Subscription subscription) {
        subscriptions.remove(subscription);
    }

    @Override
    public void notifyObservers(String website, String status) {
        for (Observer o : observers) {
            o.update(website, status);
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}