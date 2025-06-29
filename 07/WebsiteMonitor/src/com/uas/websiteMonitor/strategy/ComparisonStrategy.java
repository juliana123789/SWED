package com.uas.websiteMonitor.strategy;

public interface ComparisonStrategy {
    boolean isWebsiteChanged(String oldContent, String newContent);
}
