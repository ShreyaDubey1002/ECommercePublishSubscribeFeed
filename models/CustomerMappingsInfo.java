package ECommercePublishSubscribeFeed.models;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerMappingsInfo {
    HashMap<Integer, ArrayList<Integer>> customerIdToSellerIds;

    public CustomerMappingsInfo() {
        this.customerIdToSellerIds = new HashMap<Integer, ArrayList<Integer>>();
    }

    public HashMap<Integer, ArrayList<Integer>> getCustomerIdToSellerIds() {
        return customerIdToSellerIds;
    }

    public void setCustomerIdToSellerId(HashMap<Integer, ArrayList<Integer>> customerIdToSellerIds) {
        this.customerIdToSellerIds = customerIdToSellerIds;
    }
}
