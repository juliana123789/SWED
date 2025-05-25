
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userID;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Subscription> subscriptions = new ArrayList<>();

    public User(String userID, String name, String email, String phoneNumber) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void register() {
        // Registration logic (e.g., save to DB)
    }

    public void manageSubscriptions() {
        // Example stub method for managing subscriptions
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void removeSubscription(Subscription subscription) {
        subscriptions.remove(subscription);
    }

    public String getEmail() {
        return email;
    }
    
    public String getuserID() {
        return userID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getName() {
        return name;
    }
}