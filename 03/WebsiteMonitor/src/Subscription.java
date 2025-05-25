
public class Subscription {
    private String subscriptionID;
    private String url;
    private Frequency frequency;
    private CommunicationChannel communicationChannel;

    public Subscription(String subscriptionID, String url, Frequency frequency, CommunicationChannel communicationChannel) {
        this.subscriptionID = subscriptionID;
        this.url = url;
        this.frequency = frequency;
        this.communicationChannel = communicationChannel;
    }

    public void modify(Frequency newFrequency) {
        this.frequency = newFrequency;
    }

    public void cancel() {
        // Cancel logic
    }
    
    public String getSubscriptionID() {
        return subscriptionID;
    }
    
    public String getUrl() {
        return url;
    }
    
    public Frequency getFrequenc() {
        return frequency;
    }

    public CommunicationChannel getCommunicationChannel() {
        return communicationChannel;
    }
}