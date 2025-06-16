package com.uas.websiteMonitor.communication;

import com.uas.websiteMonitor.model.Notification;
import com.uas.websiteMonitor.model.User;
import com.uas.websiteMonitor.observer.Observer;

public interface CommunicationChannel extends Observer {
    void sendNotification(Notification notification, User user);
}