package ECommercePublishSubscribeFeed.models;

import java.util.ArrayList;
import java.util.HashMap;

public class SellerMappingsInfo {
    HashMap<Integer, ArrayList<Integer>> sellerIdToCustomerIds;
    HashMap<Integer, ArrayList<Integer>> sellerIdToPostIds;

    public SellerMappingsInfo() {
        this.sellerIdToCustomerIds = new HashMap<Integer, ArrayList<Integer>>();
        this.sellerIdToPostIds = new HashMap<Integer, ArrayList<Integer>>();
    }

    public HashMap<Integer, ArrayList<Integer>> getSellerIdToCustomerIds() {
        return sellerIdToCustomerIds;
    }

    public void setSellerIdToCustomerId(HashMap<Integer, ArrayList<Integer>> sellerIdToCustomerIds) {
        this.sellerIdToCustomerIds = sellerIdToCustomerIds;
    }

    public HashMap<Integer, ArrayList<Integer>> getSellerIdToPostIds() {
        return sellerIdToPostIds;
    }

    public void setSellerIdToPostId(HashMap<Integer, ArrayList<Integer>> sellerIdToPostId) {
        this.sellerIdToPostIds = sellerIdToPostIds;
    }
}
