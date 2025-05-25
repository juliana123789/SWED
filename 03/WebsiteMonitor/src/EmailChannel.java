
public class EmailChannel implements CommunicationChannel {
    @Override
    public void sendNotification(Notification notification, User user) {
        System.out.println("Sending email to " + user.getEmail() + ": " + notification.getMessage());
    }
}