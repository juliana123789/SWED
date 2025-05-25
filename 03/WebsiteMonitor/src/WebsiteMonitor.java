import java.util.ArrayList;
import java.util.List;

public class WebsiteMonitor {
    private String monitorID;
    private List<Subscription> subscriptions = new ArrayList<>();

    public WebsiteMonitor(String monitorID) {
        this.monitorID = monitorID;
    }

    public void checkForUpdates() {
        for (Subscription subscription : subscriptions) {
            Notification notification = new Notification("N001", "Website updated!", new java.util.Date());
            subscription.getCommunicationChannel().sendNotification(notification, null);
        }
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
}
