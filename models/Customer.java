package ECommercePublishSubscribeFeed.models;

public class Customer {
    int customerId;
    static int lastCustomerId = 0;

    public Customer() {
        this.lastCustomerId = this.lastCustomerId+1;
        this.customerId = lastCustomerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
