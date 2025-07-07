package com.uas.websiteMonitor.communication;

import com.uas.websiteMonitor.model.Notification;
import com.uas.websiteMonitor.model.User;

public interface CommunicationChannel {
    void sendNotification(Notification notification, User user);
}