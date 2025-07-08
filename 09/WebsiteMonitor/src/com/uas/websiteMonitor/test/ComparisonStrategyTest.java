package com.uas.websiteMonitor.test;

import com.uas.websiteMonitor.strategy.ComparisonStrategy;
import com.uas.websiteMonitor.strategy.TextContentComparisonStrategy;
import com.uas.websiteMonitor.strategy.ComparisonStrategy;
import com.uas.websiteMonitor.strategy.SizeComparisonStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComparisonStrategyTest {

    @Nested
    @DisplayName("TextContentComparisonStrategy Tests")
    class TextContentComparison {
        private final ComparisonStrategy strategy = new TextContentComparisonStrategy();

        @Test
        void testSameTextDifferentTags() {
            assertFalse(strategy.isWebsiteChanged("<p>Hello</p>", "<div>Hello</div>"));
        }

        @Test
        void testDifferentText() {
            assertTrue(strategy.isWebsiteChanged("<p>Hello</p>", "<p>Hi</p>"));
        }

        @Test
        void testNullValues() {
            assertTrue(strategy.isWebsiteChanged(null, "<p>Hello</p>"));
            assertTrue(strategy.isWebsiteChanged("<p>Hello</p>", null));
            assertTrue(strategy.isWebsiteChanged(null, null));
        }
    }

    @Nested
    @DisplayName("SizeComparisonStrategy Tests")
    class SizeComparison {
        private final ComparisonStrategy strategy = new SizeComparisonStrategy();

        @Test
        void testSameLengthDifferentContent() {
            assertFalse(strategy.isWebsiteChanged("12345", "abcde"));
        }

        @Test
        void testDifferentLength() {
            assertTrue(strategy.isWebsiteChanged("123", "123456"));
        }

        @Test
        void testNullValues() {
            assertTrue(strategy.isWebsiteChanged(null, "text"));
            assertTrue(strategy.isWebsiteChanged("text", null));
            assertTrue(strategy.isWebsiteChanged(null, null));
        }
    }

    @Nested
    @DisplayName("HtmlContentComparisonStrategy Tests")
    class HtmlComparison {
        private final ComparisonStrategy strategy = new HtmlContentComparisonStrategy();

        @Test
        void testSameHtml() {
            String html = "<p>Hello</p>";
            assertFalse(strategy.isWebsiteChanged(html, html));
        }

        @Test
        void testDifferentHtmlSameText() {
            assertTrue(strategy.isWebsiteChanged("<p>Hello</p>", "<div>Hello</div>"));
        }

        @Test
        void testDifferentHtmlDifferentText() {
            assertTrue(strategy.isWebsiteChanged("<p>Hello</p>", "<p>Hi</p>"));
        }

        @Test
        void testNullValues() {
            assertTrue(strategy.isWebsiteChanged(null, "<p>Text</p>"));
            assertTrue(strategy.isWebsiteChanged("<p>Text</p>", null));
            assertTrue(strategy.isWebsiteChanged(null, null));
        }
    }
}