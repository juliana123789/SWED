package com.uas.websiteMonitor.observer;

public interface Subject {
	void addObserver(Observer o);
	void removeObserver(Observer o);
    void notifyObservers(String website, String status);
}