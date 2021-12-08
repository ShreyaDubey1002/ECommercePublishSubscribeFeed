package ECommercePublishSubscribeFeed.driver;

import ECommercePublishSubscribeFeed.services.Actions;

public class Driver {
    public static void main (String[] args) {
        Actions action = new Actions();
        action.createCustomer();
        action.createCustomer();
        action.createSeller(2);
        action.createSeller(5);
        action.publishPost(1, "Lenovo", 200.0);
        action.publishPost(1, "Apple", 300.0);
        action.subscribeToSeller(1, 1);
        action.subscribeToSeller(1, 2);
        action.fetchFeed(1);
        action.deletePost(1, 2);
        action.deleteSeller(1);
        action.fetchFeed(1);
    }
}
