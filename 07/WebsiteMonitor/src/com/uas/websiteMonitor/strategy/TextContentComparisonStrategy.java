package com.uas.websiteMonitor.strategy;

public class TextContentComparisonStrategy implements ComparisonStrategy {
    @Override
    public boolean isWebsiteChanged(String oldContent, String newContent) {
        if (oldContent == null || newContent == null) return true;

        String oldText = stripHtmlTags(oldContent);
        String newText = stripHtmlTags(newContent);

        return !oldText.equals(newText);
    }

    private String stripHtmlTags(String html) {
        return html.replaceAll("<[^>]*>", "").trim();
    }
}