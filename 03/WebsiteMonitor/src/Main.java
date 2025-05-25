
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create communication channels
        CommunicationChannel emailChannel = new EmailChannel();
        CommunicationChannel pushChannel = new PushNotificationChannel();

        // Create a user
        User user = new User("1", "Alice", "alice@example.com", "123-456-7890");

        // Create a subscription for the user
        Subscription subscription = new Subscription(
            "S001",
            "https://example.com/news",
            Frequency.DAILY,
            emailChannel // Can also use pushChannel
        );

        // Add subscription to the user
        user.addSubscription(subscription);

        // Create a WebsiteMonitor and add the subscription
        WebsiteMonitor monitor = new WebsiteMonitor("WM001");
        monitor.addSubscription(subscription);

        // Simulate a notification being generated
        Notification notification = new Notification("N001", "New article available!", new Date());

        // Send the notification using the channel set in the subscription
        subscription.getCommunicationChannel().sendNotification(notification, user);

        // Or simulate the monitor checking for updates (which internally sends a notification)
        monitor.checkForUpdates();
    }
}