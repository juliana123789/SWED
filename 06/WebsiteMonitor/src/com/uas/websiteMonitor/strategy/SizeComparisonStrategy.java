package com.uas.websiteMonitor.strategy;

public class SizeComparisonStrategy implements ComparisonStrategy {
    @Override
    public boolean isWebsiteChanged(String oldContent, String newContent) {
        if (oldContent == null || newContent == null) return true;
        return oldContent.length() != newContent.length();
    }
}