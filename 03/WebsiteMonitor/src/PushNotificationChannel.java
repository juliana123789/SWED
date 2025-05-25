
public class PushNotificationChannel implements CommunicationChannel {
    @Override
    public void sendNotification(Notification notification, User user) {
        System.out.println("Sending push notification to " + user.getPhoneNumber() + ": " + notification.getMessage());
    }
}