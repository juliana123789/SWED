package com.uas.websiteMonitor.observer;

public interface Observer {
    void update(String website, String status);
}